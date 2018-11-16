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

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@RequestMapping("/demo")
	public String demo(@RequestParam(value = "name", defaultValue = "World") String name) {
		
		readFile();
		return name;
	}

	public void readFile() {
		String fileInput = "C:\\Users\\CommVault\\Documents\\workspace-sts-3.9.6.RELEASE\\demo\\input.txt";
		String fileOutput = "C:\\Users\\CommVault\\Documents\\workspace-sts-3.9.6.RELEASE\\demo\\output.txt";
		// read file into stream, try-with-resources

		try {
			final BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutput,true));

			BufferedReader br = Files.newBufferedReader(Paths.get(fileInput));

			Stream<String> lines = br.lines().map(str -> getOddEven(new Integer(str)));

			lines.forEach(arg0 -> {
				try {

					java.util.Date date = new java.util.Date();
					Timestamp t = new Timestamp(date.getTime());
					System.out.println(t + ":" + arg0 + "\n");
					writer.write(t + ":" + arg0 + "\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			lines.close();
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getOddEven(Integer value) {
		if (value % 2 == 0) {
			return "EVEN";
		} else {
			return "ODD";
		}

	}

	

}