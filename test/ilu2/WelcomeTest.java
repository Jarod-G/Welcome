package ilu2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WelcomeTest {
	
	Welcome wel;
	
	@BeforeEach
	void setup() throws Exception{
		wel = new Welcome();
	}
	
	@Test
	void test_EX1() {
		assertEquals("Hello, Bob", wel.welcome("bob"));
	}
	
	@Test
	void test_EX2() {
		assertEquals("Hello, my friend", wel.welcome("    "));
		assertEquals("Hello, my friend", wel.welcome(""));
		assertEquals("Hello, my friend", wel.welcome(null));
	}
	
	@Test
	void test_EX3() {
		assertEquals("HELLO, JERRY !", wel.welcome("JERRY"));
		assertEquals("HELLO, JAMES !", wel.welcome("JAMES"));
		assertEquals("Hello, Kevin", wel.welcome("KEVIn"));
	}
	
	@Test
	void test_EX4() {
		assertEquals("Hello, Amy and Bob", wel.welcome("amy,bob"));
		assertEquals("Hello, James and Kevin", wel.welcome("james,kevin"));
		assertNotEquals("Hello, James", wel.welcome("james,kevin"));
	}
	
	@Test
	void test_EX5() {
		assertEquals("Hello, Amy, Bob and Jerry", wel.welcome("Amy,bob,jerry"));
		assertEquals("Hello, Kevin, James and Théo", wel.welcome("kevin,james,théo"));
		assertNotEquals("Hello, Kevin and James", wel.welcome("kevin,james,théo"));
	}
	
	@Test
	void test_EX6() {
		assertEquals("Hello, Amy and Jerry. AND HELLO, BOB !", wel.welcome("Amy,BOB,Jerry"));
		assertEquals("Hello, James and Théo. AND HELLO, KEVIN !", wel.welcome("KEVIN,james,théo"));
		assertEquals("Hello, Kevin, James and Els", wel.welcome("KEVIn,james,els"));
	}
	
	@Test
	void test_EX7() {
		assertEquals("Hello, Bob, Amy and Jerry", wel.welcome("bob,amy,jerry"));
		assertEquals("Hello, Bob and Jerry. AND HELLO, AMY AND JACK !", wel.welcome("bob, AMY, jerry, JACK"));
		assertEquals("Hello, Bob and Jerry. AND HELLO, AMY, JACK AND JAMES !", wel.welcome("bob, AMY, jerry, JACK, JAMES"));
	}
	
	@Test
	void test_EX8() {
		assertEquals("Hello, Bob and Amy", wel.welcome("bob  , amy  "));
		assertEquals("Hello, Bob and Jerry. AND HELLO, AMY AND JACK !", wel.welcome("  bob,  AMY  ,  jerry  ,  JACK"));
	}
	
	@Test
	void test_EX9() {
		assertEquals("Hello, Bob (x3) and Amy. AND HELLO, JERRY (x2) !", wel.welcome("bob, JERRY, amy, bob, JERRY, bob"));
		assertEquals("Hello, Bob (x4) and Amy. AND HELLO, JERRY !", wel.welcome("bob, bob, amy, bob, JERRY, bob"));
		assertEquals("Hello, Bob (x2) and Amy (x2). AND HELLO, JERRY (x3) !", wel.welcome("bob, amy, JERRY, JERRY, JERRY, amy,bob"));
		assertEquals("Hello, Bob and Amy (x3). AND HELLO, JERRY !", wel.welcome("bob, amy, amy, JERRY, amy"));
		assertEquals("Hello, Bob (x7)", wel.welcome("bob, bob, bob, bob, bob, bob,bob"));
		assertEquals("HELLO, JERRY (x4) !", wel.welcome("JERRY, JERRY, JERRY, JERRY"));
	}
	
}













