package demo.marks.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import demo.marks.Course;
import demo.marks.CourseService;
import demo.marks.Mark;
import demo.marks.MarkService;
import demo.marks.web.forms.EditMarkForm;
import demo.marks.web.forms.NewMarkForm;

@Controller
class MarksController {

	private final MarkService markService;

	private final CourseService courseService;

	@Autowired
	public MarksController(MarkService markService, CourseService courseService) {
		this.markService = markService;
		this.courseService = courseService;
	}

	@GetMapping("/")
	public String showIndexPage() {
		return "index";
	}

	@GetMapping("/list")
	public String showListPage(Model model) {

		model.addAttribute("marks", markService.findAll());

		return "list";
	}

	@GetMapping("/new")
	public String showNewPage(Model model) {

		model.addAttribute("newMarkForm", new NewMarkForm());
		model.addAttribute("courses", courseService.findAll());

		return "new";
	}

	@PostMapping("/new")
	public String postNew(@Valid @ModelAttribute NewMarkForm newMarkForm, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("courses", courseService.findAll());
			return "new";
		}

		Course course = courseService.resolveCourse(newMarkForm.getCourseId());
		Mark mark = new Mark(course, newMarkForm.getScore(), newMarkForm.getDate());

		if (markService.isCourseAlreadyGraded(mark.getCourse())) {
			bindingResult.addError(
					new ObjectError("newMarkForm", String.format("Course '%s' is already graded!", course.getLabel())));
			model.addAttribute("courses", courseService.findAll());
			return "new";
		}

		markService.save(mark);

		return "redirect:/list";
	}

	@GetMapping("/edit")
	public String showEditPage(@RequestParam String markId, @ModelAttribute EditMarkForm editMarkForm) {

		Mark mark = markService.findMarkById(markId);
		editMarkForm.setCourse(mark.getCourse());
		editMarkForm.setMarkId(markId);
		editMarkForm.setDate(mark.getDate());
		editMarkForm.setScore(mark.getScore());

		return "edit";
	}

	@PostMapping("/edit")
	public String applyEdit(@Valid @ModelAttribute EditMarkForm editMarkForm, BindingResult bindingResult) {

		Mark mark = markService.findMarkById(editMarkForm.getMarkId());
		if (bindingResult.hasErrors()) {
			editMarkForm.setCourse(mark.getCourse());
			return "edit";
		}

		mark.setScore(editMarkForm.getScore());
		mark.setDate(editMarkForm.getDate());

		return "redirect:/list";
	}

	@GetMapping("/delete")
	public String showDeletePage(@RequestParam String markId, Model model) {

		model.addAttribute("mark", markService.findMarkById(markId));

		return "delete";
	}

	@PostMapping("/delete")
	public String applyDelete(@RequestParam String markId) {

		markService.removeMarkById(markId);

		return "redirect:/list";
	}

}
