package dataStructuresPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArraysAndStrings {
	

	private List<String> employeeNames = new ArrayList<String>();
	// Cannot user premitivies such as int
	private HashMap<Integer, String>  employees = new HashMap<Integer, String>();
	
	public ArraysAndStrings(){
		createSampleNames();
		createSampleEmployeesData();
	}
	
	private void createSampleNames(){
		employeeNames.add("Avi K");
		employeeNames.add("Abhi K");
		employeeNames.add("Robby B");
	}
	
	private void createSampleEmployeesData(){
		for (int i = 0; i < employeeNames.size() ; i++){
			employees.put(i, employeeNames.get(i));
		}
	}
	
	public void printEmployeesData(){
		
		for (int i = 0; i < employeeNames.size() ; i++){
			Integer key = (Integer)employees.keySet().toArray()[i];
			String value = (String) employees.values().toArray()[i];
			System.out.println(" key,value: " + key + ", " + value);
		}
		
	}
	
	public void printEmployeeNames(){
		for (String name: employeeNames ){
			System.out.println(" name " + name);
		}
	}
	
	public void printNamesWithUniqueChars(){
		for(int i = 0; i < employeeNames.size() ; i++){
			String currName = employeeNames.get(i);
			if (isAllUniqueChars(currName))
				System.out.println(" name with unique characters " + currName);
			else 
				System.out.println(" name wihtout unique character " + currName);
		}
	}
	
	public boolean isAllUniqueChars(String str){
		boolean isUnique = true;
		
		for (int outer_i=0; outer_i<str.length(); outer_i++){
			char currChar = str.charAt(outer_i);
			
			// check each char with with every other char of string
			for(int inner_i=0; inner_i<str.length(); inner_i++){
				
				boolean isCharsEqual = str.charAt(inner_i) == currChar;
				boolean isiEqual = outer_i == inner_i;
				
				if ( isCharsEqual && !isiEqual) 
					isUnique = false;
			}
			
		}
		
		return isUnique;	
	}
	
	public String reverseString(String str){
		if(str.isEmpty()) return str;
		else if (str.length() < 2) return str;
		
		StringBuffer strInReverse = new StringBuffer();
		
		for (int i=0; i<str.length(); i++){
			strInReverse.append(str.charAt(str.length()-(i+1)));
		}
		
		return strInReverse.toString();
	}
	
	// Strings are immutable hence any change requires a buffer
	public String removeDuplicateChars(String str){
		
		int len = str.length();
		
		if (len <= 1) return str;
		
		for(int i=0; i < len; i++){
			for(int j=0; j < len; j++){
				if (str.charAt(i) == str.charAt(j)){
					if((j > i) || (j < i)){
						break;
					}
					if (j == i) {
						str+= str.charAt(i);
						break;
					}
				}
			}
		}
		
		return str.substring(len, str.length());
		
	}
	
	public boolean isAnagram(String original, String modified){
		int len = original.length();
		
		if(original.isEmpty() && modified.isEmpty()) return false;
		else if (len != modified.length()) return false;
		
		for(int i=0; i<len; i++){
			
			char originalChar = original.charAt(i);
			
			int numModifiedChars = 0;
			int numOriginalChars = 0;
			
			for (int j=0; j<len; j++){
				if (originalChar == modified.charAt(j)){
					numModifiedChars++;
				}
				
				if (originalChar == original.charAt(j)){
					numOriginalChars++;
				}
			}
			
			if (numModifiedChars != numOriginalChars) return false;
		}
		
		return true;
	}
	
	// replaces all spaces in String with %20
	public String replaceAllSpaces(String str){
		//
		String modified = str.replaceAll("\\s", "%20");
		return modified;
	}
	
	public boolean isSubstring(String originalStr, String rotatedStr){
		// handle situation if there is only one character and then there are 2 characters
		
		int rotLength = rotatedStr.length();
		int orgLength = rotatedStr.length();
		
		if(rotLength==1 && orgLength==1) return true;
//		else if(rotLength==2 && orgLength==2){
//			
//		}
		else if(rotLength != orgLength) return false;
		
		// Fetch the first two characters and the last character and combine then
		String firstTwoChars = originalStr.substring(0, 2);
		
		int r1Index = -1;
		int r2Index = -1;
		
		// iterate thorugh the secod string
		for (int i=0; i<rotLength; i++){
			// check to see if the first and the second letter match, track the index
			char r1 = rotatedStr.charAt(i);
			char r2;
			int r2I = -1;
			if (i == (rotLength-1)) {
				r2I = 0;
				r2=rotatedStr.charAt(r2I);
			}
			else {
				r2I = i+1;
				r2 = rotatedStr.charAt(r2I);
			}
			String combined = Character.toString(r1)+ Character.toString(r2);
			
			if(firstTwoChars.equals(combined) || r2I==0 ){
				r1Index = i;
				r2Index = r2I;
				break;
			}
			// if at the end check for last and first character, track the index
			// cut the strings and reassemble and check for equaliance
		}
		
		String combined = null;
		if(r2Index > r1Index)
			// 0 to r1
			// r1 to length
			// combine them
			combined = rotatedStr.substring(r1Index, rotLength) + rotatedStr.substring(0, r1Index) ;
		
		else 
			combined = rotatedStr.substring(r1Index, r1Index+1) + rotatedStr.substring(r2Index, r2Index+1) + rotatedStr.substring(r2Index+1,r1Index);
		
		if (combined.equals(originalStr)) return true;
		else return false;
	}
//	String pattern = "([a-z])\1+";
//	
//	str.replaceAll("([A-Za-z])\\1", "$1");
//	str.replaceAll("(\\p{Alpha})\\1", "$1");
//	
//	String modifiedStr = str.replaceAll("(\\w)\\1+", "$1");
//	System.out.println(modifiedStr);
//	
//	str.matches(pattern);
	
//    if ( str.length() <= 1 ) return str;
//    if( str.substring(1,2).equals(str.substring(0,1)) ) return removeDuplicateChars(str.substring(1));
//    else return str.substring(0,1) + removeDuplicateChars(str.substring(1));	
	
//	// function takes a char array as input.
//	// modifies it to remove duplicates and adds a 0 to mark the end
//	// of the unique chars in the array.
//	public void removeDuplicates(char[] str) {
//	  if (str == null) return; // if the array does not exist..nothing to do return.
//	  int len = str.length; // get the array length.
//	  if (len < 2) return; // if its less than 2..can't have duplicates..return.
//	  int tail = 1; // number of unique char in the array.
//	  // start at 2nd char and go till the end of the array.
//	  for (int i = 1; i < len; ++i) { 
//	    int j;
//	    System.out.println(" i " + i);
//	    // for every char in outer loop check if that char is already seen.
//	    // char in [0,tail) are all unique.
//	    for (j = 0; j < tail; ++j) {
//	      if (str[i] == str[j])
//	    	  {
//	    	  System.out.println(" true  str[i] == str[j] " + i + " " + j + " "+ str[i] + " " + str[j]);
//	    	  break; // break if we find duplicate.
//	    	  }
//	    }
//
//    	System.out.println( " j " + j);
//	    System.out.println(" tail " + tail);
//	    // if j reachs tail..we did not break, which implies this char at pos i
//	    // is not a duplicate. So we need to add it our "unique char list"
//	    // we add it to the end, that is at pos tail.
//	    if (j == tail) {
//	    	System.out.println( " j == tail (true)" + j + " " + tail);
//	      str[tail] = str[i]; // add
//	      System.out.println( " str[tail] " + str[tail] + " str[i] " + str[i]);
//	      ++tail; // increment tail...[0,tail) is still "unique char list"
//	    }
//	    System.out.println( " str " + str[0] +  str[1] + str[2] + str[3]);
//	  }
//	  
//	  str[tail] = 0; // add a 0 at the end to mark the end of the unique char.
//	  
//	  System.out.println( " lsat " + str[0] +  str[1] + str[2] + str[3]);
//	}
	
}
