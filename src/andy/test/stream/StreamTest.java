package andy.test.stream;

import java.util.Arrays;

public class StreamTest {
	public static void main(String[] args) {
		// distinctStrings();
		sortNumbers();
	}

	private static void sortNumbers() {
		Integer[] numbers = new Integer[] { 38, 2, 99, 73, 64, 85, 21, 37, -5, 9, 6, 101, 55 };
		// natural sort, ascending
		// way1
		// Object[] sorted = (Object[])
		// Arrays.asList(numbers).stream().sorted().toArray();
		// Arrays.asList(sorted).stream().forEach((n)->{
		// System.out.println(n);
		// });
		// way2
//		Arrays.asList(numbers).stream().sorted().forEach((n) -> {
//			System.out.println(n);
//		});
		// decending
		Arrays.asList(numbers).stream().sorted((a, b) -> {
			return b - a;
		}).forEach((n) -> {
			System.out.println(n);
		});
	}

	public static void distinctStrings() {
		String[] strs = new String[] { "cat", "cow", "cat", "dog", "sheep", "sheep", "dog", "doggy", "horse" };
		// Object[] result = Arrays.stream(strs).filter(str -> {
		// // return Arrays.asList(result).contains(str);
		// return true;
		// }).toArray();
		Object[] result = Arrays.asList(strs).stream().distinct().toArray(); 
		System.out.println(result);
	}
}
