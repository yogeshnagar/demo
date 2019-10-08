package com.yogesh.kuber;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller("/kuber")
@RestController("/kuber")
public class KubeController {

	@RequestMapping(path="/hit", method=RequestMethod.GET)
	public @ResponseBody String getKube() {
		return "Hitting the Kube! New One!";
	}
	
}
