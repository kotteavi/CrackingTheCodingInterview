package dataStructuresTests;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class ArraysAndStrings {

	private dataStructuresPractice.ArraysAndStrings sample = new dataStructuresPractice.ArraysAndStrings();
	
	// annotation for ignoring the test method
	@Ignore
	public void test() {
		fail("Not yet implemented");
	}
	
	@Ignore
	public void printValues(){
		sample.printEmployeeNames();
		sample.printEmployeesData();
	}
	
	@Ignore
	public void testisAllUniqueChars(){
		boolean unique = sample.isAllUniqueChars("Avi");
		boolean nonUnique = sample.isAllUniqueChars("AAvVi");
		
		assertTrue(unique);
		assertFalse(nonUnique);
	}
	
	@Ignore
	public void testPrintNamesWithUniqueChars(){
		sample.printNamesWithUniqueChars();
	}
	
	@Ignore
	public void testReverseString(){
		String reversed = sample.reverseString("Avi");
		assertEquals(" 'Avi' reversed should be "  , new String("ivA"), reversed);
		
		String reversedFullName = sample.reverseString("AvinashKotte");
		assertEquals(" 'AvinashKotte' reversed should be "  , new String("ettoKhsanivA"), reversedFullName);
	}
	
	@Ignore
	public void testRemoveDuplicateChars(){

		String strExpected = "AvikZbf";
		String strActual = sample.removeDuplicateChars("AvvvikZAbbf");
		assertEquals(strExpected, strActual);
		
		
		String strExpected1 = "";
		String strActual1 = sample.removeDuplicateChars("");
		assertEquals(strExpected1, strActual1);
		
		String strExpected2 = "abc";
		String strActual2 = sample.removeDuplicateChars("abc");
		assertEquals(strExpected2, strActual2);
		
//		char[] charsInitial = {'a', 'b', 'b', 'c'};
//		char[] charsFinal = {'a', 'b', 'c', 'b', 'b', 'a'};
//		System.out.println( charsFinal );
//		sample.removeDuplicates(charsFinal);
//		System.out.println( charsFinal);
		
	}
	
	@Test
	public void testIsAnagram(){
		String original = "dogdd hello";
		String modified = "goddd hello";
		
		boolean isAnagram = sample.isAnagram(original, modified);
		assertTrue(isAnagram);
		
		String original2 = "";
		String modified2 = "";
		
		boolean isAnagram2 = sample.isAnagram(original2, modified2);
		assertFalse(isAnagram2);
	}
	
	@Test
	public void testReplaceAllSpaces(){
		String original = "avi K is";
		String modified = "avi%20K%20is";
		assertEquals(modified, sample.replaceAllSpaces(original));
		
		assertEquals("", sample.replaceAllSpaces(""));
	}
	
	@Test
	public void testIsSubstring(){
		assertTrue(sample.isSubstring("avi", "iav"));
		assertTrue(sample.isSubstring("dogBad", "ogBadd"));
		assertTrue(sample.isSubstring("avikotte", "kotteavi"));
		assertTrue(sample.isSubstring("waterbottle", "erbottlewat"));
		
	}
}
