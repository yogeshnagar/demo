package com.yogesh.micro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller("/micro")
@RestController("/micro")
public class MicroController {

	@RequestMapping(path="/hit", method=RequestMethod.GET)
	public @ResponseBody String getKube() {
		return "Hitting the Micro!";
	}
	
}