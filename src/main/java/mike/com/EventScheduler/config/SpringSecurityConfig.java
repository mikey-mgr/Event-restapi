package mike.com.EventScheduler.config;

import mike.com.EventScheduler.models.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder1() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	//Sample users creation
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		UserDetails user1 = org.springframework.security.core.userdetails.User.withUsername("javatalent")
				.password(encoder.encode("javatalent"))
				.roles("USER")
				.build();
		UserDetails user2 = org.springframework.security.core.userdetails.User.withUsername("pytalent")
				.password(encoder.encode("pytalent"))
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user1, user2);
	}

	
	
	 private Map<String, User> users = new HashMap<>();
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    User user = users.get(username);
	    if (user == null) {
	        throw new UsernameNotFoundException(username);
	    }
	    return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
	            .password(user.getPassword())
	            .roles("USER")
	            .build();
	}

	
	
	//Authentication
	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable()
				.authorizeHttpRequests().requestMatchers("/event-restapi/**").authenticated().and()
				.csrf().ignoringRequestMatchers("/h2/**").and()
				.headers().frameOptions().sameOrigin().and()
				.authorizeHttpRequests().requestMatchers("/h2/**", "/message").permitAll().and()
				.formLogin().and().build();
	}

	@PostMapping("/register")
	public ResponseEntity<UserDetails> register(@RequestBody User user) {
	    // Encode the user's password
	    user.setPassword(passwordEncoder.encode(user.getPassword()));

	    // Create a UserDetails object
	    UserDetails userDetails = org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
	        .password((String) user.getPassword())
	        .roles("USER")
	        .build();

	    // Add the user to the UserDetailsService
	    ((InMemoryUserDetailsManager) userDetailsService).createUser(userDetails);

	    // Return the UserDetails object
	    return new ResponseEntity<>(userDetails, HttpStatus.CREATED);
	}
}
