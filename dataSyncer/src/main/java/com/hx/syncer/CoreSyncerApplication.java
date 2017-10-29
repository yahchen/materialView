package com.hx.syncer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.util.Assert;

@SpringBootApplication
public class CoreSyncerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreSyncerApplication.class, args);
	}
}
