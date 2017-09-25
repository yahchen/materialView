package com.hx.syncer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.util.Assert;

@SpringBootApplication
public class CoreSyncerApplication {

	public static void main(String[] args) {
		String s = "{true} and {false}";

		SpelExpressionParser parser = new SpelExpressionParser();
		boolean result = parser.parseExpression(s).getValue(boolean.class);
		System.out.println(result+"-----------------");
		//SpringApplication.run(CoreSyncerApplication.class, args);
	}
}
