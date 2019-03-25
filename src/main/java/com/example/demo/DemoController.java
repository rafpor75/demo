package com.example.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@RequestMapping("/")
	public String welcome() {
		

		return "Welcome to Demo APP2";
	}

	@RequestMapping("/{input}")
	public String congrats(@PathVariable String input) {
		return "Congratulaz:" + input + " your application deployed successfully "	;
	}


}
