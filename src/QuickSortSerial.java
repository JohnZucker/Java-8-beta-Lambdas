import java.util.List;
import java.lang.Iterable;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Example quick sort for List of Integer using a lower-than sort appended to
 * pivot appended to greater-than sort. Requires Java8, in beta at time of
 * writing this
 */
public class QuickSortSerial {
    
    // Simple test case for sort over 10000 integers to sort
    public static void main(String[] args) {
        
        QuickSortSerial qs = new QuickSortSerial();
        ArrayList<Integer> list = new ArrayList<Integer>() {
            private static final long serialVersionUID = 1L;
            {
                Random r = new Random(System.currentTimeMillis());
                for (int i = 0; i < 10000; i++) {
                    add(r.nextInt());
                }
            }
        };
        long start = System.currentTimeMillis();
        List<Integer> result = qs.sort(list);
        
        for (Integer i : result) {
            System.out.print(i + " ");
        }
        System.out.println("Time - " + (System.currentTimeMillis() - start));
    }
    
    // Return a sorted List of Integer from any Iterable Collection of Integers
    public List<Integer> sort(Iterable<Integer> numArray) {
		if (numArray.iterator().hasNext()) {
			Integer pivot = numArray.iterator().next();
			
            /* Use of lambda expressions, requires Java8, in beta at time of writing this */
			List<Integer> result = (sort (numArray.filter(x -> x < pivot))).into(new LinkedList<Integer>());
			result.add(pivot);
            
			sort (numArray.filter(x -> x > pivot)).into(result);
            
			return result;
		} else {
			return new LinkedList<Integer>();
		}
	}
}

// TODO - Use parallelize() to provide explicit concurrency.
// Here is what we would have expected to leverage: “users should be able to
// select parallelism in an explicit but unobtrusive manner”
// (collections-overview.html, first para in section Parallelism).