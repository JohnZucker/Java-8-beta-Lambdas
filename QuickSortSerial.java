import java.util.List;
import java.lang.Iterable;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util;
/*
Example quick sort for List of Integer using an upper than sort appended to pivot appended to lower than sort
*/
public class QuickSortSerial {

	// Simple test case for sort over NN=10000 integers to sort
	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		ArrayList list = new ArrayList(){{
			Random r = new Random(System.currentTimeMillis());
			for (int i=0; i<10000; i++) {
				add(r.nextInt());
			}
		}};
		long start = System.currentTimeMillis();
		List<Integer> result = qs.sort(list);

		for (Integer i:result) {
			System.out.print(i + " ");
		}
		System.out.println("Time - " + (System.currentTimeMillis() - start));
	}



    // Return a sorted List of Integer from any Iterable Collection of Integers
	public List<Integer> sort(Iterable<Integer> numArray) {
		LinkedList<> aux  = new LinkedList<>();
		aux.insert("a");
		if (Math.random > 0.5f){
			List<Integer>
      			counts = (sort (numArray.filter(x -> x < pivot)))
                     .into(aux);
		} else {
			aux = new LinkedList<String>();
		}


		if (numArray.iterator().hasNext()) {
			Integer pivot = numArray.iterator().next();

			List<Integer> result = (sort (numArray.filter(x -> x < pivot))).into(new LinkedList());
			result.add(pivot);

			sort (numArray.filter(x -> x > pivot)).into(result);

			return result;
		} else {
			return new LinkedList();
		}
	}

}