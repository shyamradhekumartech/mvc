package com.example.controller;

import java.time.LocalDateTime;

import javax.mail.MessagingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Person;
import com.example.service.IPersonService;
import com.example.util.EmailUtil;

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
	public String createPerson(@RequestBody Person person) {
		logger.info("<PersonController started> at " + LocalDateTime.now().toString());
		String message = personService.createPerson(person);
		logger.info("<PersonController completed> at " + LocalDateTime.now().toString());
		return message;
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
