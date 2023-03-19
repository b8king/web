package com.web.web;

import com.web.web.domain.SearchMusic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(WebApplication.class, args);
	}

}
