package week2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.ComparisonFailure;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class Week2Test {

	// question 1
	// a " was missing, just made the code clear and easier to read
	@Test
	public void Writing_Sometext_Backwards() {
		
		StringBuilder word = new StringBuilder("Jag");
		String reversed = word.reverse().toString();
		
		assertEquals("checking reverse",
				"gaJ", reversed);
		//assertE
		}
	
	// question 2
	// A JUnit test method must be a "void" method. The runner class does not check any return values.
	@Test
	public void JustASimpleAssert() {
	String name = "My name";
	assertEquals("My name", name);
	}
	
	
	
	// question 3
	// 
	public class Person {
		String firstname = "first name";
		String lastname = "last name";
		int phonenumber = 0701111111;
		String streetaddress = "my cool street";
	}
	
	Person person = new Person();
	
	@Test
	public void TestingFirstName() {
		assertEquals("first name", person.firstname);
	}
	@Test
	public void TestingLastName() {
		assertEquals("last name", person.lastname);
	}
	@Test
	public void TestingPhoneNumber() {
		assertEquals(0701111111, person.phonenumber);
	}
	@Test
	public void TestingStreetAdress() {
		assertEquals("my cool street", person.streetaddress);
	}
	
	// question 4
	// As long as there is nothing that "fails" the test in the method, it will always pass, even if it's an empty method.
	@Test
	public void TestingLengthOfString() {
	
	 System.out.println("Junit 5");
	
	String word = "Junit 5";
	assertEquals("Checking length",
			7, word.length());
	}
	
	// question 5
	// @Test was missing
	@Test
	public void GiveMeASimpleVerification() {
		assertEquals(100, 100);
		}
	
	// question 6
	//When you create String object using new() operator, it always create a new object in heap memory.
	//assertEquals: Asserts that two objects are equal. assertSame: Asserts that two objects refer to the same object.
	@Test
	public void CheckingSame() {
	String s1 = new String("S1");
	String s2 = s1;
	assertSame(s1, s2);
	}
	
	// question 7 
	@Test
	public void CheckingBytes() {
	byte smallByte1 = 100;
	byte smallByte2 = smallByte1;
	assertTrue(smallByte1 == smallByte2);
	}
	
	// question 9 
	
	@Test
	public void CheckingTrue() {
	Object obj1 = new Object();
	Object obj2 = obj1;
	assertTrue(obj1 == obj2);
	}
	// Or if we just want to check if they use the same class
	@Test
	public void CheckingTrue2() {
	Object obj1 = new Object();
	Object obj2 = new Object();
	assertTrue(obj1.getClass().equals(obj2.getClass()));
	}
	
	// question 10
	//	Because assertFalse expected the condition to be false but it was true
	@Test
	public void CheckingFalse() {
	Object obj1 = new Object();
	Object obj2 = new Object();
	assertFalse(obj1 == obj2);
	}
	// Or
	@Test
	public void CheckingFalse2() {
	Object obj1 = new Object();
	Object obj2 = obj1;
	assertFalse(obj1 != obj2);
	}
	
	//Bonus question
	
	static MyInfo myInfo; // declare instance of class
		
	@Test
	@DisplayName("Testing my name") // Unique name for test
	public void testMyName() {
		try {
			assertEquals("Testing my name,", // test description
					"Pedram", myInfo.name );
		} catch(ComparisonFailure e) {		  // catch AssertionError, ComparisonFailure is specific for strings. same thing
			System.out.println(e.getMessage()); // print the message on console
			fail();								// to fail the test if we happen to catch the fail(cause it will still pass on fail since we catch the fail)
		}
	}
	@Test
	@DisplayName("Testing my lastname")
	public void testMyLastName() {
		try {
			assertEquals("Testing my lastname,",
					"Mirhosseini", myInfo.lastName );
		} catch(ComparisonFailure e) {
			System.out.println(e.getMessage()); // 
			fail();
		}
	}
	@Test
	@DisplayName("Testing my age")
	public void testMyAge() {
		try {
			assertEquals("Testing my age,",
					28, myInfo.age);
		} catch(AssertionError e) {
			System.out.println(e.getMessage());
			fail();
		}
	}
	
	public static class MyInfo{
		String name = "Pedram";
		String lastName = "Mirhosseini";
		byte age = 28;
	}
	
	@BeforeAll
	public static void getMyInfo() {
		myInfo = new MyInfo();
	}
	
	// bonus
	
}
