package com.example.restService;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingService {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "fname", defaultValue = "There") String fname, @RequestParam(value = "lname", defaultValue = "Boss")String lname) {
		String name = fname + lname;
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
