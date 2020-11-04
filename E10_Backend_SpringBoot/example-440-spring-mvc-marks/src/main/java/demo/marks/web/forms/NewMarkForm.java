package demo.marks.web.forms;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class NewMarkForm {

	@NotEmpty
	private String courseId;

	@NotNull
	@Min(0)
	@Max(150)
	private double score = 50.0;

	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private LocalDate date = LocalDate.now();

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
