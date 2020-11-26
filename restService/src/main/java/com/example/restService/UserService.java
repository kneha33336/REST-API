package com.example.restService;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class UserService {
	private final AtomicLong counter = new AtomicLong();
	
	@PostMapping("/registerUser")
	@ResponseBody
	public User registerUser(@RequestBody String name,@RequestBody String address, @RequestBody String dob, @RequestBody String city, @RequestBody String pinCode) {
		return new User(counter.incrementAndGet(), name, address, dob, city, pinCode);
	}
	
	
	@PostMapping("/registerUserEmpty")
	public String registerUserEmpty() {
		return "Posted successfully";
	}
	
	@PostMapping("/registerUserSingleParam")
	@ResponseBody
	public String registerUserSingleParam(@RequestBody String name) throws JsonMappingException, JsonProcessingException {
		System.out.println("single ==> starts");
		System.out.println(name);
		name = name.substring(1, name.length()-1);           //remove curly brackets
		String[] keyValuePairs = name.split(",");              //split the string to creat key-value pairs
		Map<String,String> map = new HashMap<>();               

		for(String pair : keyValuePairs)                        //iterate over the pairs
		{
		    String[] entry = pair.split(":");                   //split the pairs to get key and value 
		    map.put(entry[0].trim(), entry[1].trim());          //add them to the hashmap and trim whitespaces
		    System.out.println("key :" + entry[0].trim() + " and value : " + entry[1].trim());
		}

		//ObjectMapper mapper = new ObjectMapper();
		//User user = mapper.readValue(name, User.class);
		//User user1 = new User(map.get("name"), map.get("address"));
		//System.out.println(user1);
		
		User user2 = new User(counter.incrementAndGet(),map.get("name"), map.get("address"), map.get("dob"), map.get("city"), map.get("pinCode"));
		System.out.println(map.get("name")+" "  + map.get("address") + " " + map.get("dob") + " " + map.get("city") + " " + map.get("pinCode"));
		System.out.println(user2.toString());
		return "One parameter posted successfully.";
	}
}
