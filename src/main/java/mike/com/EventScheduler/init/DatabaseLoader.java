package mike.com.EventScheduler.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import mike.com.EventScheduler.Repository.EventRepo;
import mike.com.EventScheduler.models.Event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final EventRepo eventRepo;

    @Autowired
    public DatabaseLoader(EventRepo eventRepository) {
        this.eventRepo = eventRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        addSampleEvents();
    }

    public void addSampleEvents() {
        List<Event> events = Arrays.asList(
            new Event("Project Kickoff", "Kickoff meeting for the new project", LocalDate.of(2024, 1, 5), LocalTime.of(10, 0), 1),
            new Event("Code Review", "Weekly code review session", LocalDate.of(2024, 1, 6), LocalTime.of(14, 0), 2),
            new Event("Client Meeting", "Meeting with the client to discuss requirements", LocalDate.of(2024, 1, 7), LocalTime.of(11, 0), 3),
            new Event("Team Building", "Team building activity at the local park", LocalDate.of(2024, 1, 8), LocalTime.of(13, 0), 4),
            new Event("Project Demo", "Demo of the current project state to stakeholders", LocalDate.of(2024, 1, 9), LocalTime.of(15, 0), 5),
            new Event("Brainstorming", "Brainstorming session for new project ideas", LocalDate.of(2024, 1, 10), LocalTime.of(10, 0), 6),
            new Event("Hackathon", "Internal hackathon to develop new features", LocalDate.of(2024, 1, 11), LocalTime.of(9, 0), 7),
            new Event("Training", "Training session on new technologies", LocalDate.of(2024, 1, 12), LocalTime.of(14, 0), 8),
            new Event("Performance Review", "Quarterly performance review meeting", LocalDate.of(2024, 1, 13), LocalTime.of(11, 0), 9),
            new Event("Company Outing", "Company outing at a local amusement park", LocalDate.of(2024, 1, 14), LocalTime.of(10, 0), 10),
            new Event("Budget Planning", "Annual budget planning meeting", LocalDate.of(2024, 1, 15), LocalTime.of(15, 0), 11),
            new Event("Product Launch", "Launch event for the new product", LocalDate.of(2024, 1, 16), LocalTime.of(13, 0), 12),
            new Event("Charity Event", "Participation in a local charity event", LocalDate.of(2024, 1, 17), LocalTime.of(9, 0), 13),
            new Event("Health and Safety", "Health and safety training for all employees", LocalDate.of(2024, 1, 18), LocalTime.of(14, 0), 14),
            new Event("Year-End Party", "Year-end party to celebrate achievements", LocalDate.of(2024, 1, 19), LocalTime.of(19, 0), 15)
        );

        for (Event event : events) {
            eventRepo.save(event);
        }
    }

}
