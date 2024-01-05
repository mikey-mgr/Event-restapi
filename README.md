# Java Spring Boot RESTful API

## Project Overview
This project is a Java Spring Boot application that provides a RESTful API. The API can be used for various operations such as registering a new user, retrieving all events, retrieving an event by its ID, title, date, or time, adding a new event, updating an existing event by its ID, and deleting an event by its ID.

## Setup Instructions
1. Clone the project repository from GitHub/GitLab to your local machine using the command: `git clone https://github.com/yourusername/yourrepository.git`
2. Change your current directory to the project directory: `cd yourrepository`
3. Use Maven to build the project: `mvn clean install`
4. Run the application: `java -jar target/yourproject-0.0.1-SNAPSHOT.jar`

## API Documentation
### API Endpoints
1. `/register-user (POST)`: Registers a new user. Request format is a JSON object with the fields username and password. Response format is a JSON object with the fields userId, username, and password.
2. `/event-restapi/all-events (GET)`: Retrieves all events. Response format is a list of Event objects.
3. `/event-restapi/event-by-id/{id} (GET)`: Retrieves an event by its ID. Path variable is id - The ID of the event. Response format is an Event object.
4. `/event-restapi/event-by-title/{title} (GET)`: Retrieves events by their title. Path variable is title - The title of the event. Response format is a list of Event objects.
5. `/event-restapi/event-by-date/{date} (GET)`: Retrieves events by their date. Path variable is date - The date of the event in YYYY-MM-DD format. Response format is a list of Event objects.
6. `/event-restapi/event-by-time/{time} (GET)`: Retrieves events by their time. Path variable is time - The time of the event in HH:MM:SS format. Response format is a list of Event objects.
7. `/event-restapi/add-event (POST)`: Adds a new event. Request format is an Event object. Response format is an Event object.
8. `/event-restapi/update-event-by-id/{Id} (POST)`: Updates an existing event by its ID. Path variable is Id - The ID of the event. Request format is an Event object with the new event data. Response format is an Event object.
9. `/event-restapi/delete-event-by-id/{Id} (DELETE)`: Deletes an event by its ID. Path variable is Id - The ID of the event. Response format is an HTTP status code.

## Database Configuration
The application uses an H2 in-memory database to store data. The `DatabaseLoader` class is responsible for initializing the database with sample data when the application starts.

## Spring Security Configuration
This class is annotated with @Configuration and @EnableWebSecurity, indicating that it is a configuration class for Spring Security.

## Beans
1. `UserDetailsService userDetailsService(PasswordEncoder encoder)`: This bean is responsible for retrieving user-related data. It is used by the Spring Security framework to handle authentication. This implementation returns an InMemoryUserDetailsManager instance, which is a UserDetailsService implementation based on an in-memory map. It creates two users, “javatalent” and “pytalent”, with their passwords encoded using the provided PasswordEncoder.
2. `SecurityFilterChain securityFilterChain(HttpSecurity http)`: This bean defines the security filter chain for the application. This implementation configures the HttpSecurity.
3. `PasswordEncoder passwordEncoder()`: This bean is responsible for encoding passwords. This implementation returns a BCryptPasswordEncoder instance, which is a PasswordEncoder implementation that uses the BCrypt strong hashing function.
