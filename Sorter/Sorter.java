/**
 *
 * @author pask
 */

import java.util.Random;
import java.util.Arrays;	// for javaIt()

//TODO:
// [ ]	Придумать обёртку для вызова функций сортировке, в которой подсчитывать и ограничивать время и выводить результат.
// [ ]	

public class Sorter {
	static int[] testArray;
	
	// Bubble sorter
	private static int[] bubbleIt(int[] array) {
		boolean changed = false;
		int[] retArray = array.clone();
		do {
			changed = false;
			for (int i = 0; i < retArray.length - 1; i++) {
				if (retArray[i] > retArray[i + 1]) {
					int val = retArray[i];
					retArray[i] = retArray[i + 1];
					retArray[i + 1] = val;
					
					changed = true;
				}
			}
		} while (changed);
		return retArray;
	}

	// Shaker sorter
	private static int[] shakeIt(int[] array) {
		boolean changed;
		int[] retArray = array.clone();
		do {
			changed = false;
			// Forward
			for (int i = 0; i < retArray.length - 2; i++) {
				if (retArray[i] > retArray[i + 1]) {
					int val = retArray[i];
					retArray[i] = retArray[i + 1];
					retArray[i + 1] = val;
					
					changed = true;
				}
			}
			// Check if sorted yet
			if (!changed) {
				break;
			}
			// Backward
			changed = false;
			for (int i = retArray.length - 2; i >= 0; i--) {
				if (retArray[i] > retArray[i + 1]) {
					int val = retArray[i];
					retArray[i] = retArray[i + 1];
					retArray[i + 1] = val;
					
					changed = true;
				}
			}
		} while (changed);
		return retArray;
	}
	
	// Comb sorter
	private static int[] combIt(int[] array) {
		final double factor = 1.24733095010;
		int[] retArray = array.clone();
		int gap = retArray.length;
		boolean changed = true;
		
		while (gap > 1 || changed) {
			//gap = (gap > 1) ? (int) (gap / factor) : gap;
			if (gap > 1) {
				gap = (int) (gap / factor);
			}
			changed = false;
			for (int i = 0; i + gap < retArray.length; i++) {
				if (retArray[i] > retArray[i + gap]) {
					int val = retArray[i];
					retArray[i] = retArray[i + gap];
					retArray[i + gap] = val;
					
					changed = true;
				}
			}
		}
		return retArray;
	}
	
	// Standard Java array sort
	private static int[] javaIt(int[] array) {
		int[] retArray = array.clone();
		Arrays.sort(retArray);
		return retArray;
	}
	
	public static void main(String[] args) {
		int size = 200000;	// Size of an array
		int max = 51200;	// Maximum value

		long timeStart;
		long timeFinish;
		
		int[] sortedArray;
		
		// Randomly fill the array
		timeStart = System.currentTimeMillis();
		Random random = new Random();	// Array randomizer
		timeFinish = System.currentTimeMillis();
		System.out.println("Array of random integers contains " + size + " elements filled in " + (timeFinish - timeStart) + "ms");

		testArray = new int[size];
		for (int i = 0; i < size; i++) {
			testArray[i] = random.nextInt(max);
		}

		// Test Bubble
		timeStart = System.currentTimeMillis();
		sortedArray = bubbleIt(testArray);
		timeFinish = System.currentTimeMillis();
		System.out.println("...And we've sorted them with Bubble in " + (timeFinish - timeStart) + "ms");
		// Test Shake
		timeStart = System.currentTimeMillis();
		sortedArray = shakeIt(testArray);
		timeFinish = System.currentTimeMillis();
		System.out.println("...And we've sorted them with Shake in " + (timeFinish - timeStart) + "ms");
		// Test Comb
		timeStart = System.currentTimeMillis();
		sortedArray = combIt(testArray);
		timeFinish = System.currentTimeMillis();
		System.out.println("...And we've sorted them with Comb in " + (timeFinish - timeStart) + "ms");
		// Test Java's sort
		timeStart = System.currentTimeMillis();
		sortedArray = javaIt(testArray);
		timeFinish = System.currentTimeMillis();
		System.out.println("...And we've sorted them with Arrays.sort() in " + (timeFinish - timeStart) + "ms");
	}
}