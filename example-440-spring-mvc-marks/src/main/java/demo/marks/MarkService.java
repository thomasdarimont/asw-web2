package demo.marks;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class MarkService {

	// Dummy marks "database"
	private static final List<Mark> MARKS = new ArrayList<>();

	public Mark findMarkById(String markId) {

		for (Mark mark : MARKS) {
			if (mark.getId().equals(markId)) {
				return mark;
			}
		}

		return null;
	}
	
	public boolean isCourseAlreadyGraded(Course course) {
		return findMarkByCourse(course) != null;
	}

	public Mark findMarkByCourse(Course course) {

		for (Mark mark : MARKS) {
			if (mark.getCourse().getId().equals(course.getId())) {
				return mark;
			}
		}

		return null;
	}

	public void save(Mark mark) {
		mark.setId(UUID.randomUUID().toString());
		MARKS.add(mark);
	}

	public List<Mark> findAll() {
		return MARKS;
	}

	public boolean removeMarkById(String markId) {
		return MARKS.removeIf(m -> m.getId().equals(markId));
	}
}
