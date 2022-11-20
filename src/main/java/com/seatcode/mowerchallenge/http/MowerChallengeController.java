package com.seatcode.mowerchallenge.http;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seatcode.mowerchallenge.application.MowerService;

@RestController 
@RequestMapping("/mowerchallenge")
public class MowerChallengeController {
	
	@PostMapping(value = "/mowers" , consumes = {MediaType.TEXT_PLAIN_VALUE})
	public String mowersPostEndPoint(@RequestBody String mowersRequest) {
		MowerService mowersService = new MowerService();
		
		return mowersService.executeMowerMovements(mowersRequest);
	}

}
