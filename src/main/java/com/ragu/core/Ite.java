package com.ragu.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.management.ImmutableDescriptor;

public class Ite {

	public static void main(String[] args) {
		List<String> al = new ArrayList<String>();
		// add elements to the array list
		al.add("C");
		al.add("A");
		al.add("E");
		al.add("B");
		al.add("D");
		al.add("F");
		
		List<String> list = new ArrayList<String>();
	      // add elements to the array list
		list.add("C");
		list.add("A");
		list.add("E");
		list.add("B");
		list.add("D");
		list.add("F");

		for (String s : al) {
			System.out.println(s);
		}

		Iterator<String> sl = al.iterator();

		//System.out.println(al);
		while (sl.hasNext()) {
			System.out.println(sl.next());
			sl.remove();
		}
		//System.out.println("al " + al);
		
		ListIterator<String> listIte = list.listIterator();
		
		while (listIte.hasNext()){
			System.out.println(listIte.next() + listIte.nextIndex());
		}
		

		Map<String, String> map = new HashMap<String, String>();
		
		map.put("Test1", "Value1");map.put("Test2", "Value2");map.put("Test3", "Value3");
		
		Collections.synchronizedMap(map);
	}

}
