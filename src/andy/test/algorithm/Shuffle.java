package andy.test.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Shuffle {
	public static void main(String[] args) {
		// List<Integer> a = new ArrayList<Integer>();
		List<Integer> a = new LinkedList<Integer>();
		int totalSize = 100;
		int splitSize = 70;

		for (int i = 1; i <= totalSize; i++) {
			a.add(i);
		}
		for (int i = 0; i < a.size(); i++)
			System.out.print(a.get(i) + " ");

		System.out.println();

		Random r = new Random();
		// shuffle, way1, backwoard in-place
		// for (int i = a.size() - 1; i > 0; i--){
		// int j = r.nextInt(i); // j is the random index
		// Integer temp = a.get(i);
		// a.set(i, a.get(j));
		// a.set(j, temp);
		// }
		
		// shuffle way1, shuffle split a into b and c
		// first shuffle a 
		for (int i = a.size() - 1; i > 0; i--){
			 int j = r.nextInt(i); // j is the random index
			 Integer temp = a.get(i);
			 a.set(i, a.get(j));
			 a.set(j, temp);
			 }
		// then split
		List<Integer> b = new ArrayList<Integer>();
		List<Integer> c = new ArrayList<Integer>();
		for (int i = 0; i < a.size(); i++){
			if (i < splitSize){
				b.add(a.get(i));
			}
			else {
				c.add(a.get(i));
			}
		}
			
		// shuffle, way2, forward in-place
		// for (int i = 0; i < a.size()-1; i++){
		// int j = i + r.nextInt(a.size() - i);
		// int temp = a.get(i);
		// a.set(i, a.get(j));
		// a.set(j, temp);
		// }

		// shuffle, way3, inside-out
		// List<Integer> b = new ArrayList<Integer>();
		// for (int i = 0; i < a.size(); i++){
		// b.add(a.get(i));
		//
		// int j = r.nextInt(i+1);
		// b.set(i, b.get(j));
		// b.set(j, a.get(i));
		// }

		// shuffle, way3, inside-out, shuffle split a into b and c
//		List<Integer> shuffledA = new ArrayList<>();
//		List<Integer> b = new ArrayList<Integer>();
//		List<Integer> c = new ArrayList<Integer>();
//		// first shuffle a into another shuffledA
//		for (int i = 0; i < a.size(); i++) {
//			shuffledA.add(a.get(i));
//				// shuffle switch
//				int j = r.nextInt(i + 1);
//				
////				int temp = shuffledA.get(i);
////				shuffledA.set(i, shuffledA.get(j));
////				shuffledA.set(j, temp);
//				shuffledA.set(i, shuffledA.get(j));
//				shuffledA.set(j, a.get(i));
//		}
//		for (int i = 0; i < shuffledA.size(); i++){
//			if (i < splitSize){
//				b.add(shuffledA.get(i));
//			}
//			else {
//				c.add(shuffledA.get(i));
//			}
//		}

		System.out.println();
		for (int i = 0; i < b.size(); i++)
			System.out.print(b.get(i) + " ");
		System.out.println();
		for (int i = 0; i < c.size(); i++)
			System.out.print(c.get(i) + " ");
	}
}
