package com.fenghuang.job;

import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = PageHelperAutoConfiguration.class)
public class FindJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindJobApplication.class, args);
	}

}
