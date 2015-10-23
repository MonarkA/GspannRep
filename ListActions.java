package Practice1;

import java.util.ArrayList;

public class ArrayListActions {

	static ArrayList<Integer> arrayList = new ArrayList<Integer>();

	public static void main(String[] args) {

		Long startTime = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			arrayList.add(i);
		}
		System.out.println("Arraylist add time with 10 elements : "+(System.currentTimeMillis() - startTime));
		
		arrayList = new ArrayList<Integer>();
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			arrayList.add(i);
		}
		System.out.println("Arraylist add time with 1000 elements: "+(System.currentTimeMillis()-startTime));
		
		arrayList = new ArrayList<Integer>();
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			arrayList.add(i);
		}
		System.out.println("Arraylist add time with 10000 elements: "+(System.currentTimeMillis()-startTime));
		
		startTime = System.currentTimeMillis();
		arrayList.remove(2);
		System.out.println("Arraylist removing element: "+(System.currentTimeMillis()-startTime));
		
	}

}
