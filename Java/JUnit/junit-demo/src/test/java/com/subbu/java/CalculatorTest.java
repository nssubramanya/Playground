/**
 * 
 */
package com.subbu.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

/**
 * @author subramanyans
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class CalculatorTest {
	private static Calculator calc = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		calc = new Calculator();
		System.out.println("Before ALL");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("After ALL");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Before EACH");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("After EACH");
	}

	@Test
	@Disabled
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	@DisplayName("Multiplication with 0 returns 0")
	void testMultiply() {
		assertEquals(0, calc.multiple(5, 0));
	}
	
	@Test
	@DisplayName("Test Addition of Ints to return Float")
	void testAdd() {
		assertEquals(10.0, calc.add(5, 5));
	}

	@Test
	@DisplayName("Test adding Zero")
	void testAddZero() {
		System.out.println("Test adding Zero");
		assertEquals(5.0, calc.add(5.0, 0));
	}

//	@Test
//	@DisplayName("Test Divide by Zero")
//	void testAddingString() {
//
//		assertThrows(NullPointerException.class, () -> {
//			throw new NullPointerException();
//		});
//
//	}

}
