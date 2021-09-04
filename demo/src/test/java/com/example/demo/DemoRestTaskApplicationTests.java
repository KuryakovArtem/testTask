package com.example.demo;

import com.example.demo.parser.StringParser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoRestTaskApplicationTests {

	@Test
	void contextLoads() {
		StringParser parser = new StringParser();
		parser.parseString("sum,1,2,3,4");
	}

}
