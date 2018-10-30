package com.nagarro.yourmartapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestApi {

	@GetMapping("/user")
	public String getMessage() {
		return "Hello";
	}
}
