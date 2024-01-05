package mike.com.EventScheduler.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mike.com.EventScheduler.Repository.EventRepo;
import mike.com.EventScheduler.models.Event;

@Service
public class EventServiceImpl implements EventService{

	@Autowired
	private EventRepo eventRepo;
	
	
	@Override
	public Event getById(int eventId) {
		return getEventList()
				.stream()
				.filter((event)->event.getEventId()==eventId)
				.findAny()
				.orElse(new Event(null, null, null, null, eventId));
	}

	@Override
	public List<Event> getEventByTitle(String title) {
		// TODO Auto-generated method stub
		return getEventList()
				.stream()
				.filter((event)->event.getTitle().equals(title))
				.collect(Collectors.toList());
	}

	@Override
	public List<Event> getEventByDate(LocalDate date) {
		return getEventList()
				.stream()
				.filter((event)->event.getDate().equals(date))
				.collect(Collectors.toList());
	}
	@Override
	public List<Event> getEventByTime(LocalTime time) {
		return getEventList()
				.stream()
				.filter((event)->event.getTime().equals(time))
				.collect(Collectors.toList());
	}
	@Override
	public List<Event> getEventByDescription(String description) {
		return getEventList()
				.stream()
				.filter((event)->event.getDescription().equals(description))
				.collect(Collectors.toList());
	}


    public List<Event> getEventList() {
        return eventRepo.findAll();
    }
	

}
