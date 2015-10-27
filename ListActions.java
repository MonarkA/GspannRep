package Practice1;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListActions {

	static ArrayList<Integer> arrayList = new ArrayList<Integer>();
	static LinkedList<Integer> linkedList = new LinkedList<Integer>();

	public static void main(String[] args) {

		Long startTime = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			arrayList.add(i);
		}
		System.out.println("Arraylist add time with 10 elements(in ms) : "+(System.currentTimeMillis() - startTime));
		
		arrayList = new ArrayList<Integer>();
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			arrayList.add(i);
		}
		System.out.println("Arraylist add time with 1000 elements(in ms) : "+(System.currentTimeMillis()-startTime));
		
		arrayList = new ArrayList<Integer>();
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			arrayList.add(i);
		}
		System.out.println("Arraylist add time with 10000 elements(in ms) : "+(System.currentTimeMillis()-startTime));
		
		startTime = System.currentTimeMillis();
		arrayList.remove(2);
		System.out.println("Arraylist removing element(in ms) : "+(System.currentTimeMillis()-startTime));
		
		for (int i = 0; i < 10; i++) {
			linkedList.add(i);
		}
		System.out.println("LinkedList add time with 10 elements(in ms) : "+(System.currentTimeMillis() - startTime));
		
		linkedList = new LinkedList<Integer>();
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			linkedList.add(i);
		}
		System.out.println("LinkedList add time with 1000 elements(in ms) : "+(System.currentTimeMillis()-startTime));
		
		linkedList = new LinkedList<Integer>();
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			linkedList.add(i);
		}
		System.out.println("LinkedList add time with 10000 elements(in ms) : "+(System.currentTimeMillis()-startTime));
		
		startTime = System.currentTimeMillis();
		linkedList.remove(2);
		System.out.println("LinkedList removing element(in ms) : "+(System.currentTimeMillis()-startTime));
		
	}

}
