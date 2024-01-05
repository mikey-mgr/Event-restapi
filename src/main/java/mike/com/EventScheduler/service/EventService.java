package mike.com.EventScheduler.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import mike.com.EventScheduler.models.Event;

@Service
public interface EventService{
	
	Event getById(int eventId);
	List <Event> getEventByTitle(String title);
	List <Event> getEventByDate(LocalDate date);
	List <Event> getEventByTime(LocalTime time);
	List <Event> getEventByDescription(String description);
	
	List<Event> getEventList();
}
