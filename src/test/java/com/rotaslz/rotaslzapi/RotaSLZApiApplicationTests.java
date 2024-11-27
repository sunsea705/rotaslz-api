package com.rotaslz.rotaslzapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RotaSLZApiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testarSoma() {
		int a = 3;
		int b = 7;
		int c = a + b;
		assertEquals(7, c, 0);
	}


}
