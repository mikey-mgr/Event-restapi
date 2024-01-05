package mike.com.EventScheduler.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mike.com.EventScheduler.Repository.EventRepo;
import mike.com.EventScheduler.models.Event;
import mike.com.EventScheduler.service.EventService;

@RestController
@RequestMapping("event-restapi")
public class EventController {
	
	@Autowired
	private EventService eventService;
	@Autowired
	private EventRepo eventRepo;
	

	//Read Events
	// http://localhost:8080/event-restapi/all-events
	@GetMapping("/all-events")
	public List <Event> getAllEvents(){
		return eventService.getEventList();
	}

	// http://localhost:8080/event-restapi/event-by-id/10
	@GetMapping("/event-by-id/{id}")
	public Event getEventById(@PathVariable("id") int eventId) {
		return eventService.getById(eventId);
	}
	// http://localhost:8080/event-restapi/event-by-title/Meeting
	@GetMapping("/event-by-title/{title}")
	public List <Event> getEventByTitle(@PathVariable String title){
		return eventService.getEventByTitle(title);
	}
	// http://localhost:8080/event-restapi/event-by-date/2024-01-06
	@GetMapping("/event-by-date/{date}")
	public List <Event> getEventByDate(@PathVariable LocalDate date){
		return eventService.getEventByDate(date);
	}
	// http://localhost:8080/event-restapi/event-by-time/10:00:00
	@GetMapping("/event-by-time/{time}")
	public List <Event> getEventByTime(@PathVariable LocalTime time){
		return eventService.getEventByTime(time);
	}
	
	@PostMapping("/add-event")
	public ResponseEntity<Event> addEvent(@RequestBody Event event){
		Event eventObj = eventRepo.save(event);
		
		return new ResponseEntity<>(eventObj, HttpStatus.OK);
	}
	
	@PostMapping("/update-event-by-id/{Id}")
	public ResponseEntity<Event> updateEventById(@PathVariable Integer Id, @RequestBody Event newEventData) {
		Optional <Event> oldEventData = eventRepo.findById(Id);
		
		if (oldEventData.isPresent()) {
			Event updateEventData = oldEventData.get();
			updateEventData.setTitle(newEventData.getTitle());
			updateEventData.setTime(newEventData.getTime());
			updateEventData.setDescription(newEventData.getDescription());
			updateEventData.setDate(newEventData.getDate());
			
			Event eventObj = eventRepo.save(updateEventData);
			return new ResponseEntity<>(eventObj, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/delete-event-by-id/{Id}")
	public ResponseEntity<HttpStatus> deleteEventById(@PathVariable Integer Id){
		eventRepo.deleteById(Id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
}
