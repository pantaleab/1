import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author Abigail Pantaleon
 *  @version HT 2020
 *  
 *  Times in milliseconds
 *  						Insert 	Selection 	Merge Recursive 	Merge Iterative 	Quick
	10 random			|	0	  |	  0		  |	 0				|	0				|	0
	100 random			|	1	  |	  1		  |  0				|	0				|	1
	1000 random			|	9	  |	  6		  |  6				|	1				|	8
	1000 few unique		|	2	  |	  1		  |  3				|	0				|	7
	1000 nearly ordered	|	0	  |	  1		  |  3				|	0				|	8
	1000 reverse order	|	1	  |	  0		  |  2				|	0				|	0
	1000 sorted			|	1 	  |	  0		  |  2				|	1				|	0
	
	a. Which of the sorting algorithms does the order of input have an impact on? Why?
	Quick sort and insertion sort because it only swaps unsorted inputs, therefore the more sorted it is, the faster and vice versa.
	
	b. Which algorithm has the biggest difference between the best and worst performance, based
	on the type of input, for the input of size 1000? Why?
	Quick sort and insertion sort for the sane reasons as question a.
	
	c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
	based on the input size? Please consider only input files with random order for this answer.
	Insertion sort.
	
	d. Did you observe any difference between iterative and recursive implementations of merge
	sort?
	In this implementation, merge sort iterative was faster or same in all cases than recursive. 
	
	e. Which algorithm is the fastest for each of the 7 input files?
	In this case, merge sort iterative. But in general it would be merge sort recursive. 
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	double[] list = null;
    	
    	assertEquals(list, SortComparison.insertionSort(list) );
    	assertEquals(list, SortComparison.selectionSort(list) );
    	assertEquals(list, SortComparison.quickSort(list) );
    	assertEquals(list, SortComparison.mergeSortIterative(list) );
    	assertEquals(list, SortComparison.mergeSortRecursive(list) );
    }


    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.
    
    @Test
    public void testInsertionSort()
    {
    	double[] list = {1};
    	assertEquals("Check insertion sort with one element", list, SortComparison.insertionSort(list) );
    	
    	list = new double[] {1,2,3,4,4};
    	assertEquals("Check insertion sort with already sorted list", list, SortComparison.insertionSort(list) );
    	
    	double[] sortedList = list;
    	
    	list = new double[] {4,2,4,1,3};
    	assertArrayEquals("Check insertion sort with unsorted list", sortedList, SortComparison.insertionSort(list), 0 );
    }
    
    @Test
    public void testSelectionSort()
    {
    	double[] list = {1};
    	assertEquals("Check selection sort with one element", list, SortComparison.selectionSort(list) );
    	
    	list = new double[] {1,2,3,4,4};
    	assertEquals("Check selection sort with already sorted list", list, SortComparison.selectionSort(list) );
    	
    	list = new double[] {4,2,4,1,3};
    	assertArrayEquals("Check selection sort with unsorted list", new double[]{1,2,3,4,4}, SortComparison.selectionSort(list), 0 );
    	
    }
    
    @Test
    public void testQuickSort()
    {
    	double[] list = {1};
    	assertEquals("Check quick sort with one element", list, SortComparison.quickSort(list) );
    	
    	list = new double[] {1,2,3,4,4};
    	assertEquals("Check quick sort with already sorted list", list, SortComparison.quickSort(list) );
    	
    	double[] sortedList = list;
    	
    	list = new double[] {4,2,4,1,3};
    	assertArrayEquals("Check quick sort with unsorted list", sortedList, SortComparison.quickSort(list), 0 );
    }
    
    @Test
    public void testMergeSortIterative()
    {
    	double[] list = {1};
    	assertEquals("Check iterative merge sort with one element", list, SortComparison.mergeSortIterative(list) );
    	
    	list = new double[] {1,2,3,4,4};
    	assertEquals("Check iterative merge sort with already sorted list", list, SortComparison.mergeSortIterative(list) );
    	
    	double[] sortedList = list;
    	
    	list = new double[] {4,2,4,1,3};
    	assertArrayEquals("Check iterative merge sort with unsorted list", sortedList, SortComparison.mergeSortIterative(list), 0 );
    }
    
    @Test
    public void testMergeSortRecursive()
    {
    	double[] list = {1};
    	assertEquals("Check recursive merge sort with one element", list, SortComparison.mergeSortRecursive(list) );
    	
    	list = new double[] {1,2,3,4,4};
    	assertEquals("Check recursive merge sort with already sorted list", list, SortComparison.mergeSortRecursive(list) );
    	
    	double[] sortedList = list;
    	
    	list = new double[] {4,2,4,1,3};
    	assertArrayEquals("Check recursive merge sort with unsorted list", sortedList, SortComparison.mergeSortRecursive(list), 0 );
    }

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    
    public static void main(String[] args) throws FileNotFoundException
    {
    	File numbers10 = new File("C:\\Users\\Abby\\Desktop\\numbers\\numbers10.txt");
    	double[] numbers10List = fileToList(numbers10, 10);
    	System.out.println("Numbers 10 list");
    	algorithmsStopwatch(numbers10List);
    	
    	
    	File numbers100 = new File("C:\\Users\\Abby\\Desktop\\numbers\\numbers100.txt");
    	double[] numbers100List = fileToList(numbers100, 100);
    	System.out.println("Numbers 100 list");
    	algorithmsStopwatch(numbers100List);
    	
    	File numbers1000 = new File("C:\\Users\\Abby\\Desktop\\numbers\\numbers1000.txt");
    	double[] numbers1000List = fileToList(numbers1000, 1000);
    	System.out.println("Numbers 1000 list");
    	algorithmsStopwatch(numbers1000List);
    	
    	File numbers1000Duplicates = new File("C:\\Users\\Abby\\Desktop\\numbers\\numbers1000Duplicates.txt");
    	double[] numbers1000DuplicatesList = fileToList(numbers1000Duplicates, 1000);
    	System.out.println("Numbers 1000 Duplicates list");
    	algorithmsStopwatch(numbers1000DuplicatesList);
    	
    	File numbersNearlyOrdered1000 = new File("C:\\Users\\Abby\\Desktop\\numbers\\numbersNearlyOrdered1000.txt");
    	double[] numbersNearlyOrdered1000List = fileToList(numbersNearlyOrdered1000, 1000);
    	System.out.println("Numbers Nearly Ordered 1000 list");
    	algorithmsStopwatch(numbersNearlyOrdered1000List);
    	
    	File numbersReverse1000 = new File("C:\\Users\\Abby\\Desktop\\numbers\\numbersReverse1000.txt");
    	double[] numbersReverse1000List = fileToList(numbersReverse1000, 1000);
    	System.out.println("Numbers Reverse 1000 list");
    	algorithmsStopwatch(numbersReverse1000List);
    	
    	File numbersSorted1000 = new File("C:\\Users\\Abby\\Desktop\\numbers\\numbersSorted1000.txt");
    	double[] numbersSorted1000List = fileToList(numbersSorted1000, 1000);
    	System.out.println("Numbers Sorted 1000 list");
    	algorithmsStopwatch(numbersSorted1000List);
    	
        //TODO: implement this method
    }
    
    public static double[] fileToList( File inputFile, int length )throws FileNotFoundException
    {
    	Scanner sc = new Scanner(inputFile); 
    	double[] list = new double[length];

    	for (int i = 0; i < length; i++ ) 
    		list[i] = new Double (sc.nextLine());
    	
    	return list;
    }
    
    public static void algorithmsStopwatch( double[] list  )
    {
    	final double[] originalList = list;
    	long startTime = System.currentTimeMillis();
    	SortComparison.insertionSort(list);
    	long endTime = System.currentTimeMillis();
    	long timeTaken = endTime - startTime;
    	
    	System.out.println("Time for insertion sort: " + timeTaken + "ms");
    	
    	list = originalList;
    	startTime = System.currentTimeMillis();
    	SortComparison.selectionSort(list);
    	endTime = System.currentTimeMillis();
    	timeTaken = endTime - startTime;
    	
    	System.out.println("Time for selection sort: " + timeTaken + "ms");

    	list = originalList;
    	startTime = System.currentTimeMillis();
    	SortComparison.quickSort(list);
    	endTime = System.currentTimeMillis();
    	timeTaken = endTime - startTime;
    	
    	System.out.println("Time for quick sort: " + timeTaken + "ms");

    	list = originalList;
    	startTime = System.currentTimeMillis();
    	SortComparison.mergeSortIterative(list);
    	endTime = System.currentTimeMillis();
    	timeTaken = endTime - startTime;
    	
    	System.out.println("Time for merge sort iterative sort: " + timeTaken + "ms");

    	list = originalList;
    	startTime = System.currentTimeMillis();
    	SortComparison.mergeSortRecursive(list);
    	endTime = System.currentTimeMillis();
    	timeTaken = endTime - startTime;
    	
    	System.out.println("Time for merge sort recursive sort: " + timeTaken + "ms");
    }

}