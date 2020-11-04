package todos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Todo {

	@Id
	@GeneratedValue
	Long id;

	@NotNull
	String title;

	@NotNull
	Boolean completed;
}