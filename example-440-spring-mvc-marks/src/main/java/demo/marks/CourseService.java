package demo.marks;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CourseService {

	private static final List<Course> COURSES = Arrays.asList( //
			new Course("MATH1", "Mathematik I"), //
			new Course("ENGLISH", "Englisch"), //
			new Course("ECONOMICS", "BWL"), //
			new Course("WEB1", "Web I"), //
			new Course("WEB2", "Web II"), //
			new Course("PROG1", "Prog I") //
	);

	public List<Course> findAll() {
		return COURSES;
	}

	public Course resolveCourse(String courseId) {

		for (Course course : findAll()) {
			if (course.getId().equals(courseId)) {
				return course;
			}
		}

		return null;
	}
}
