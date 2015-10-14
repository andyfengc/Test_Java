package andy.test.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomRemove {

	public static void main(String[] args) {
		List<Integer> dataset = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			dataset.add(i);
		}
		for (int i = 0; i < dataset.size(); i++)
			System.out.print(dataset.get(i) + " ");
		System.out.println();

		int currentSize = dataset.size();
		int targetSize = 2;
		int j = 0;
		Random r = new Random();
		for (int i = dataset.size() - 1; i > targetSize - 1; i--) {
			int index = r.nextInt(i + 1);
			System.out.print("remove["+index+"] ");
			dataset.remove(index);
			j++;
		}
		System.out.println();
		for (int i = 0; i < dataset.size(); i++)
			System.out.print(dataset.get(i) + " ");
	}

}
