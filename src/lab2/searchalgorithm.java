package lab2;
import java.util.Scanner;
import java.util.Arrays;

public class searchalgorithm {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);

	    // Prompt the user to enter the length of the array
	    System.out.print("Enter the number of elements in the array: ");
	    int length = scanner.nextInt();
	    System.out.print("Enter the elements in the array: " + '\n');
	    // Create an array to store the numbers
	    int[] numbers = new int[length];

	    // Prompt the user to enter the numbers and store them in the array
	    for (int i = 0; i < length; i++) {
	        numbers[i] = scanner.nextInt();
	    }
	    
	    // Ask user for search key
	    System.out.print("Enter the serach key: ");
	    int serach_key = scanner.nextInt();
	    
	    scanner.close();
	    
	    boolean found = false;
	    
	    long startTimelinear = System.nanoTime();
	    
	    //Linear simple search algorithm
	    for (int i=0; i < length; i++) {
	    	
	    	if (numbers[i] == serach_key) {
	    		System.out.println('\n'+"Sample Output:");
	    		System.out.println("Using Linear Search:");
	    		System.out.println("Search key FOUND at index "+i+".");
	    		found = true;
	    		break;
	    	}
	    }
    	 
	    //Linear improved search algorithm
	   
	    long endTimelinear = System.nanoTime();
	    long timeElapsedlinear = endTimelinear - startTimelinear;
	    System.out.println("Execution time in nanoseconds: " + timeElapsedlinear);
	    
	    long startTimelinearimprov = System.nanoTime();
	    
	    for (int i = length/2; i < length; i++) {
	    		if (numbers[i] == serach_key) {
	    			System.out.println('\n'+"Sample Output:");
		    		System.out.println("Using Linear Improved Search:");
		    		System.out.println("Search key FOUND at index "+i+".");
	    			found = true;
	    			break;
	    		}
	    		if (numbers[length-(i+1)] == serach_key) {
	    			System.out.println('\n'+"Sample Output:");
		    		System.out.println("Using Linear Improved Search:");
		    		System.out.println("Search key FOUND at index "+(length-(i+1))+".");
	    			found = true;
	    			break;
	    		}
	       	}
	    
	    long endTimelinearimprov = System.nanoTime();
	    long timeElapsedlinearimprov = endTimelinearimprov - startTimelinearimprov;
	    System.out.println("Execution time in nanoseconds: " + timeElapsedlinearimprov);
	    
	    //INTERPOLATION search algorithm
	    	int[] copiedArray = Arrays.copyOf(numbers, numbers.length);
	    	Arrays.sort(copiedArray);
	    	int low = 0, pos, mid, high = copiedArray.length -1;
	    	pos = (serach_key - copiedArray[0])/(copiedArray[length-1]-copiedArray[0]) ;
	    	mid = copiedArray[0]+ ((copiedArray[length-1]-copiedArray[0])*pos);
	    	
	    	long startTimeinter = System.nanoTime();
	    	while (low <= high)
	    	{
	    		mid = (low + high)/2;
	    		if (serach_key < copiedArray[mid])
	    				high = mid -1;
	    		else if(copiedArray[mid] < serach_key)
	    				low = mid + 1;
	    		else {
	    			System.out.println('\n'+"Using Interpolation Search:");
	    			System.out.println("Search key FOUND at index "+mid+".");
	    			found = true;
	    			break;
	    		}
	    			    			    	
	    	}	 	
	    	long endTimeinter = System.nanoTime();
	    	long timeElapsedinter = endTimeinter - startTimeinter;
	    	System.out.println("Execution time in nanoseconds: " + timeElapsedinter);
	
	// Display message if search key is not found
	if (found == false) {
		System.out.println("Search key NOT FOUND");
	}
}
}