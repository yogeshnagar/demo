package com.yogesh.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/demo")
@Controller
public class DemoController {

	@RequestMapping(method=RequestMethod.GET, path="/hello")
	public @ResponseBody String sayHello() {
		return "Hello Thr!";
	}
	
}
