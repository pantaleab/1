import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2020
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
    
    public void testInsertionSort()
    {
    	double[] list = {1};
    	assertEquals("Check insertion sort with one element", list, SortComparison.insertionSort(list) );
    	
    	list = new double[] {1,2,3,4,4};
    	assertEquals("Check insertion sort with already sorted list", list, SortComparison.insertionSort(list) );
    	
    	double[] sortedList = list;
    	
    	list = new double[] {4,2,4,1,3};
    	assertEquals("Check insertion sort with unsorted list", sortedList, SortComparison.insertionSort(list) );
    }
    
    public void testSelectionSort()
    {
    	double[] list = {1};
    	assertEquals("Check selection sort with one element", list, SortComparison.selectionSort(list) );
    	
    	list = new double[] {1,2,3,4,4};
    	assertEquals("Check selection sort with already sorted list", list, SortComparison.selectionSort(list) );
    	
    	double[] sortedList = list;
    	
    	list = new double[] {4,2,4,1,3};
    	assertEquals("Check selection sort with unsorted list", sortedList, SortComparison.selectionSort(list) );
    	
    }
    
    public void testQuickSort()
    {
    	double[] list = {1};
    	assertEquals("Check quick sort with one element", list, SortComparison.quickSort(list) );
    	
    	list = new double[] {1,2,3,4,4};
    	assertEquals("Check quick sort with already sorted list", list, SortComparison.quickSort(list) );
    	
    	double[] sortedList = list;
    	
    	list = new double[] {4,2,4,1,3};
    	assertEquals("Check quick sort with unsorted list", sortedList, SortComparison.quickSort(list) );
    }
    
    public void testMergeSortIterative()
    {
    	double[] list = {1};
    	assertEquals("Check iterative merge sort with one element", list, SortComparison.mergeSortIterative(list) );
    	
    	list = new double[] {1,2,3,4,4};
    	assertEquals("Check iterative merge sort with already sorted list", list, SortComparison.mergeSortIterative(list) );
    	
    	double[] sortedList = list;
    	
    	list = new double[] {4,2,4,1,3};
    	assertEquals("Check iterative merge sort with unsorted list", sortedList, SortComparison.mergeSortIterative(list) );
    }
    
    public void testMergeSortRecursive()
    {
    	double[] list = {1};
    	assertEquals("Check recursive merge sort with one element", list, SortComparison.mergeSortRecursive(list) );
    	
    	list = new double[] {1,2,3,4,4};
    	assertEquals("Check recursive merge sort with already sorted list", list, SortComparison.mergeSortRecursive(list) );
    	
    	double[] sortedList = list;
    	
    	list = new double[] {4,2,4,1,3};
    	assertEquals("Check recursive merge sort with unsorted list", sortedList, SortComparison.mergeSortRecursive(list) );
    }

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
        //TODO: implement this method
    }

}
