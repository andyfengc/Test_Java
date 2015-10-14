package andy.test.algorithm;

import java.util.HashSet;
import java.util.Set;

public class CollectionTester {

	public static void main(String[] args) {
		Set<Integer> sets = new HashSet<Integer>();
		Integer a = new Integer(5);
		Integer b = new Integer(10);
		Integer c = new Integer(5);
		sets.add(a);
		sets.add(b);
		sets.add(c);
		for (Integer i : sets){
			System.out.println(i);
		}
	}
	 
}
