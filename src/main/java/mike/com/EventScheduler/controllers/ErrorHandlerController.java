package mike.com.EventScheduler.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@Controller
public class ErrorHandlerController {

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleNotFoundError(Exception ex) {
        return "redirect:/message";
    }
}
