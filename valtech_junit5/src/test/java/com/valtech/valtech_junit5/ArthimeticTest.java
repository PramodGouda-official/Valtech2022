package com.valtech.valtech_junit5;


import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ArthimeticTest {
	
	private Arthimetic arithmetic;
	
	private static int ZERO;
	
			
	@BeforeAll
	public static void executeMeFirst() {
		System.out.println("Before All - Executed First.....");
		ZERO=0;
	}
	
	@BeforeEach
	public void runBeforetest()
	{
		arithmetic=new ArthimeticImpl();
		System.out.println("Run Before.........");
		
	}
	
	@Test
	public void testHello()
	{
//		assertTrue(true);
		System.out.println("Hello......");
	}
	
	@Test
	public void testHi()
	{
//		assertTrue(true);
		System.out.println("Hi......");
	}
	
	@Test
	@DisplayName("Generic Test Cases for add")
	public void testAdd(){
		assertEquals(5, arithmetic.add(2, 3));
		assertEquals(5, arithmetic.add(3, 2));
		assertEquals(3, arithmetic.add(0, 3));
		assertEquals(3, arithmetic.add(3, 0));
		assertEquals(5, arithmetic.add(-2, 7));
		assertEquals(-5, arithmetic.add(-7, 2));
		assertEquals(-9, arithmetic.add(-7, -2));
		assertEquals(0, arithmetic.add(0, 0));
	}
	
	public static Stream<Arguments> argumentsForAdd(){
		return Stream.of(Arguments.of(2,3,5),Arguments.of(1,3,4));
	}
	
	
	@DisplayName(value = "{index} {0} {1} + {2} = {3}")
	@ParameterizedTest
	@CsvSource({
		"'Adding 2 Positive Numbers',2,3,5",
		"'Adding 2 Negative Numbers',-2,-3,-5",
		"'Adding a Positive and a Negative Number',-2,3,1"
	})
	public void testAdd(String name, int a, int b, int res){
		arithmetic = new ArthimeticImpl();
		assertEquals(res, arithmetic.add(a, b));
	}	
	
	@DisplayName(value = "{index} Testing for add with {0} and {1} should be equals {2}")
	@ParameterizedTest
	@MethodSource("argumentsForAdd")
	public void testAdd(int a, int b, int res){
	}
	
	@ParameterizedTest
	@ValueSource(ints={-3,-2,-1,0,1,2,3})
	@DisplayName(value = "{index} Testing for add with {0} and 0")
	public void testAdd(int a ){
		assertEquals(a, arithmetic.add(a, ZERO));
	}
	
	@Nested
	@DisplayName("This is for Testing subtraction method of the Arithmetic")
	public class SubtractionTest{
		
		private Arthimetic arithmetic;
		@ParameterizedTest
		@CsvSource({
			"'Subtracting 2 Positive Numbers',2,3,-1",
			"'Subtracting 2 Negative Numbers',-2,-3,1",
			"'Subtracting a Positive and a Negative Number',-2,3,-5"
		})
		public void testAdd(String name, int a, int b, int res){
			arithmetic = new ArthimeticImpl();
			assertEquals(res, arithmetic.sub(a, b));
		}
	}
	
	@Nested
	@DisplayName("This is for Testing division method of the Arithmetic")
	public class DivisonTest{
		
		private Arthimetic arithmetic;
		
		@Test
		public void testDivisionByZero(){
			arithmetic = new ArthimeticImpl();
			assertThrows(ArithmeticException.class,() -> { arithmetic.div(2, ZERO);});
		}
	}
	
	@AfterEach
	public void afterTest()
	{
		System.out.println("AfterEach Method.........");
	}
	
	@AfterAll
	public static void executeMeJustBeforeProgramExits() {
		System.out.println("Last method to be executed...");
	}
	

}
