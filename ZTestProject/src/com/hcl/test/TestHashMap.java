package com.hcl.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * This is the TestHashMap Class to test various function related to Map. 
 * @author vipin.r
 * 
 */
public class TestHashMap {
/**
*main method
*/
	public static void main(String[] args) {
		

		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < 15; i++) {
			map.put("key" + i, new Integer(i + 1));
		}

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		System.out.println("--------------------------------");
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		System.out.println("--------------------------------");
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		
		String s1 = "vishal";
		String s2 = new String(s1);
		System.out.println(s2);
		System.out.println(s1==s2);
		
		ArrayList<String> l = new ArrayList<>();
		
	}

}
