package demo.marks;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MarkService {

	private final MarksRepository markRepository;

	public MarkService(MarksRepository markRepository) {
		this.markRepository = markRepository;
	}

	public boolean isCourseAlreadyGraded(Course course) {
		return markRepository.findMarkByCourse(course) != null;
	}

	public Mark findMarkById(String markId) {
		return markRepository.findMarkById(markId);
	}

	public Mark findMarkByCourse(Course course) {
		return markRepository.findMarkByCourse(course);
	}

	public void save(Mark mark) {
		markRepository.save(mark);
	}

	public List<Mark> findAll() {
		return markRepository.findAll();
	}

	public boolean removeMarkById(String markId) {
		return markRepository.removeMarkById(markId);
	}
}
