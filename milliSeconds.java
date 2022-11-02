package mergeSort;

import java.util.Arrays;

public class milliSeconds {
   private static void merge(int[] numbers, int i, int j, int k) {
      int mergedSize = k - i + 1;                // Size of merged partition
      int[] mergedNumbers = new int[mergedSize]; // Dynamically allocates temporary
                                                 // array for merged numbers
      int mergePos = 0;                          // Position to insert merged number
      int leftPos = i;                           // Initialize left partition position
      int rightPos = j + 1;                      // Initialize right partition position
      
      // Add smallest element from left or right partition to merged numbers
      while (leftPos <= j && rightPos <= k) {
         if (numbers[leftPos] <= numbers[rightPos]) {
            mergedNumbers[mergePos] = numbers[leftPos];
            leftPos++;
         }
         else {
            mergedNumbers[mergePos] = numbers[rightPos];
            rightPos++;
         }
         mergePos++;
      }
      
      // If left partition is not empty, add remaining elements to merged numbers
      while (leftPos <= j) {
         mergedNumbers[mergePos] = numbers[leftPos];
         leftPos++;
         mergePos++;
      }
   
      // If right partition is not empty, add remaining elements to merged numbers
      while (rightPos <= k) {
         mergedNumbers[mergePos] = numbers[rightPos];
         rightPos++;
         mergePos++;
      }
   
      // Copy merged numbers back to numbers
      for (mergePos = 0; mergePos < mergedSize; mergePos++) {
         numbers[i + mergePos] = mergedNumbers[mergePos];
      }
   }
   
   private static void mergeSort(int[] numbers, int i, int k) {
      int j = 0;
      
      if (i < k) {
         j = (i + k) / 2;  // Find the midpoint in the partition

         // Recursively sort left and right partitions
         mergeSort(numbers, i, j);
         mergeSort(numbers, j + 1, k);
            
         // Merge left and right partition in sorted order
         merge(numbers, i, j, k);
      }
   }
   
   
   public static void quicksort(int[] numbers, int startIndex, int endIndex) {
		// Only attempt to sort the array segment if there are
		// at least 2 elements
		if (endIndex <= startIndex) {
			return;
		}

		// Partition the array segment
		int high = partition(numbers, startIndex, endIndex);

		// Recursively sort the left segment
		quicksort(numbers, startIndex, high);

		// Recursively sort the right segment
		quicksort(numbers, high + 1, endIndex);
	}
   
	public static int partition(int[] numbers, int startIndex, int endIndex) {
		// Select the middle value as the pivot.
		int midpoint = startIndex + (endIndex - startIndex) / 2;
		int pivot = numbers[midpoint];

		// "low" and "high" start at the ends of the array segment
		// and move towards each other.
		int low = startIndex;
		int high = endIndex;

		boolean done = false;
		while (!done) {
			// Increment low while numbers[low] < pivot
			while (numbers[low] < pivot) {
				low = low + 1;
			}

			// Decrement high while pivot < numbers[high]
			while (pivot < numbers[high]) {
				high = high - 1;
			}

			// If low and high have crossed each other, the loop
			// is done. If not, the elements are swapped, low is
			// incremented and high is decremented.
			if (low >= high) {
				done = true;
			} else {
				int temp = numbers[low];
				numbers[low] = numbers[high];
				numbers[high] = temp;
				low++;
				high--;
			}
		}
		return high;
		
	}

   public static void main(String[] args) {
      // Create an array of numbers to sort
      int[] numbers = new int[10000];
   
      long start = System.currentTimeMillis();
      
    		  
      for (int i = 0; i < 10000; i++) {
			numbers[i] = (int) ((Math.random() * 10));
		}
      
      // Display the contents of the array
      System.out.println("UNSORTED: " + Arrays.toString(numbers));
      
      // Call the mergeSort method
      mergeSort(numbers, 0, numbers.length - 1);
      
      
      // Display the sorted contents of the array
      System.out.println("SORTED:   " + Arrays.toString(numbers));
      long end = System.currentTimeMillis();
      System.out.println(end-start);

      
      }
      
   }
      
      
      