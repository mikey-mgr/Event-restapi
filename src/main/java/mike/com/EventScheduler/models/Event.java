package mike.com.EventScheduler.models;


import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Event {
	
	
	public Event() {
	}

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer eventId;
	String title;
    String description;
    LocalDate date;
    LocalTime time;
	
	public Event(String title, String description, LocalDate date, LocalTime time, int eventId) {
		this.title = title;
		this.description = description;
		this.date = date;
		this.time = time;
		this.eventId = eventId;
	}

	public Integer getEventId() {
		return this.eventId;
	}

	public Object getTitle() {
		return this.title;
	}

	public Object getDate() {
		return this.date;
	}

	public Object getTime() {
		return this.time;
	}

	public Object getDescription() {
		return this.description;
	}

	public void setTitle(Object title2) {
		this.title = (String) title2;
		
	}

	public void setTime(Object time2) {
		this.time = (LocalTime) time2;
		
	}

	public void setDescription(Object description2) {
		this.description = (String) description2;
		
	}

	public void setDate(Object date2) {
		this.date = (LocalDate) date2;
		
	}

}
