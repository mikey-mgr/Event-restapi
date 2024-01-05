package mike.com.EventScheduler.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@GetMapping("/message")
	public String getMessage() {
		return "Welcome To Event Scheduler";
	}

}
