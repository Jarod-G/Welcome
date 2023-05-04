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
		assertEquals("Hello, Amy, Bob", wel.welcome("amy,bob"));
		assertEquals("Hello, James, Kevin", wel.welcome("james,kevin"));
		assertNotEquals("Hello, James", wel.welcome("james,kevin"));
	}
	
	@Test
	void test_EX5() {
		assertEquals("Hello, Amy, Bob, Jerry", wel.welcome("Amy, bob,jerry"));
		assertEquals("Hello, Kevin, James, Théo", wel.welcome("kevin,james,théo"));
		assertNotEquals("Hello, Kevin, James", wel.welcome("kevin,james,théo"));
	}
}
