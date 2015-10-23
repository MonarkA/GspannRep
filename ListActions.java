package Practice1;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListActions {

	static LinkedList<Integer> linkedList = new LinkedList<Integer>();

	public static void main(String[] args) {

		Long startTime = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			linkedList.add(i);
		}
		System.out.println("LinkedList add time with 10 elements : "+(System.currentTimeMillis() - startTime));
		
		linkedList = new LinkedList<Integer>();
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			linkedList.add(i);
		}
		System.out.println("LinkedList add time with 1000 elements: "+(System.currentTimeMillis()-startTime));
		
		linkedList = new LinkedList<Integer>();
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			linkedList.add(i);
		}
		System.out.println("LinkedList add time with 10000 elements: "+(System.currentTimeMillis()-startTime));
		
		startTime = System.currentTimeMillis();
		linkedList.remove(2);
		System.out.println("LinkedList removing element: "+(System.currentTimeMillis()-startTime));
		
	}

}
