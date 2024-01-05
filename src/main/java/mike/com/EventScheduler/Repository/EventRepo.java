package mike.com.EventScheduler.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mike.com.EventScheduler.models.Event;


@Repository
public interface EventRepo extends JpaRepository<Event, Integer> {

}
