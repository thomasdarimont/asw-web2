package de.asw.training.beans;

import java.util.Objects;

/**
 * 
 * Source -> Generate Getters & Setters
 * Source -> Generate toString()
 * Source -> Generate hashCode() & equals()
 * Refactor -> Rename
 *
 */
public class Todo extends Object{

	private String title;

	private Boolean completed;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "Todo [title=" + title + ", completed=" + completed + "]";
	}
	
	

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((completed == null) ? 0 : completed.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Todo other = (Todo) obj;
		if (completed == null) {
			if (other.completed != null)
				return false;
		} else if (!completed.equals(other.completed))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public static void main(String[] args) {
		
		Todo todo1 = new Todo();
		todo1.setTitle("Vorlesung Vorbereiten");
		todo1.setCompleted(true);
		
		System.out.println("Todo: " + todo1);
		
		Todo todo2 = new Todo();
		todo2.setTitle("Vorlesung Vorbereiten");
		todo2.setCompleted(true);
		
		System.out.println("Todo: " + todo2);
		
		System.out.println(todo1 == todo2);
		System.out.println(todo1.equals(todo2));
		
		System.out.println("HashCode Todo1: " + todo1.hashCode());
		System.out.println("HashCode Todo2: " + todo2.hashCode());
	}
}
