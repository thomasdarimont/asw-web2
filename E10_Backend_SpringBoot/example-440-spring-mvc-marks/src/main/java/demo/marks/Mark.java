package demo.marks;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Mark {

	private String id;

	private Course course;

	private double score;

	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private LocalDate date;

	public Mark() {
	}

	public Mark(Course course, double score, LocalDate date) {
		this.course = course;
		this.score = score;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mark other = (Mark) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mark [id=" + id + ", course=" + course + ", score=" + score + ", date=" + date + "]";
	}

}
