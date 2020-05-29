package com.dimka.system;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SystemApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SystemApplication.class)
				.headless(false)
				.run(args);
	}

}
