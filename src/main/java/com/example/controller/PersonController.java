package com.example.controller;

import java.time.LocalDateTime;

import javax.mail.MessagingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Person;
import com.example.service.IPersonService;
import com.example.type.response.CustomResponse;
import com.example.util.EmailUtil;
import com.example.validation.PersonUtil;

import io.swagger.annotations.ApiOperation;

@RestController
public class PersonController {

	private static final Logger logger = LogManager.getLogger(PersonController.class);
	
	@Autowired
	private IPersonService personService;
	
	@ApiOperation(value="Create a New Person by passing his/her details",
			notes="only for creating person entity",
			response=String.class,
			responseContainer="String",
			produces="String")
	@PostMapping("/person")
	public ResponseEntity<CustomResponse> createPerson(@RequestBody Person person) {
		logger.info("<PersonController started> at " + LocalDateTime.now().toString());
		
		CustomResponse response = new CustomResponse();
		
		String message = null;
		if(PersonUtil.validate(person)) {
			message = personService.createPerson(person);
			response.setMessage(message);
			response.setStatus("SUCCESS");
			response.setStatusCode(200);
		} else {
			message = "Bad Request";
			response.setMessage(message);
			response.setStatus("FAILED");
			response.setStatusCode(403);
		}
		
		logger.info("<PersonController completed> at " + LocalDateTime.now().toString() + 
				" with respoonse message: " + response);
		
		return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
	}
	
	@GetMapping("/mail")
	public String sendMail() {
		logger.info("< Mail sending... > at " + LocalDateTime.now().toString());
		try {
			EmailUtil.isSend();
			logger.info("Mail Sent Successfully! at " + LocalDateTime.now().toString());
		} catch (MessagingException e) {
			logger.error("< Mail failed... > with " + e.getMessage() + " at " + LocalDateTime.now().toString());
			return "Failed";
		}
		return "Send";
	}
}
