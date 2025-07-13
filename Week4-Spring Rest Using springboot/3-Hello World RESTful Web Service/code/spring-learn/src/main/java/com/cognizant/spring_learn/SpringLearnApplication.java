package com.cognizant.spring_learn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		LOGGER.info("START");
		SpringApplication.run(SpringLearnApplication.class, args);

		// Call the Hands-on 2 method
		SpringLearnApplication app = new SpringLearnApplication();
		app.displayDate();

		LOGGER.info("END");
	}

	public void displayDate() {
		LOGGER.info("START");

		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");

		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);

		try {
			Date date = format.parse("31/12/2018");
			LOGGER.debug("Parsed Date: {}", date.toString());
		} catch (ParseException e) {
			LOGGER.error("Date parsing failed", e);
		}

		LOGGER.info("END");
	}
}



//handson1
//package com.cognizant.spring_learn;
//
//
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class SpringLearnApplication {
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
//
//	public static void main(String[] args) {
//		LOGGER.info("START");
//		SpringApplication.run(SpringLearnApplication.class, args);
//		LOGGER.info("END");
//	}
//}
