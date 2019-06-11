package com.subbu.springboot.collegerestapi.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RootRestController {

	@RequestMapping(value="/")
	public String handleHome () {
		return "TODO: Redirect to Swagger";
	}
}
