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
		for(int i=0;i<100000;i++);
		
		return "Ciao <img src='https://www.newspam.it/media/uploads/2016/08/mare-696x522.jpg'>";
	}

	@RequestMapping("/{input}")
	public String congrats(@PathVariable String input) {
		return "Congratulaz:" + input + " your application deployed successfully "	;
	}


}
