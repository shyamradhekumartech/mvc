package com.example.validation;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.example.model.Person;

/**
 * This PersonUtil is used for validation
 * @author user
 * @since 27 JAN 2020
 */
@Component
public class PersonUtil {

	/**
	 * This method validates Person object's name with Regular Expression
	 * @param person
	 * @return boolean
	 */
	public static boolean validate(Person person) {
		return Pattern.compile("[A-Za-z]{5}").matcher(person.getName()).matches();
	}

}
