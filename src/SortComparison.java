// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Abigail Pantaleon
 *  @version HT 2020
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
    	
    	if ( a == null ) return null;
    	
    	double temp;
    	for (int i = 1; i < a.length; i++) 
    	{    	
    		for(int j = i ; j > 0 ; j--)
    		{
    			if(a[j] < a[j-1])
    			{
			    	temp = a[j];
			    	a[j] = a[j-1];
			    	a[j-1] = temp;
		    	}
    		}
    	}
    	return a;
    }//end insertionsort
	
	    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
    	
    	if ( a == null ) return null;
    	
    	int n = a.length;
    	
    	// One by one move boundary of unsorted subarray
    	for (int i = 0; i < n-1; i++)
    	{
	    	// Find the minimum element in unsorted array
	    	int min_idx = i;
	    	for (int j = i+1; j < n; j++)
	    	if (a[j] < a[min_idx])
	    	min_idx = j;
	    	
	    	// Swap the found minimum element with the first element
	    	double temp = a[min_idx];
	    	a[min_idx] = a[i];
	    	a[i] = temp;
    	}
    	
    	return a;

         //todo: implement the sort

    }//end selectionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
	
    	if ( a == null ) return null;
    	
    	recursiveQuick(a, 0, a.length-1);
    	return a;

    }
    
    private static void recursiveQuick(double[] numbers, int lo, int hi) {
    	if (hi <= lo) return;
    	
    	int pivotPos = partition(numbers, lo, hi);
    	recursiveQuick(numbers, lo, pivotPos-1);
    	recursiveQuick(numbers, pivotPos+1, hi);
    }
    
    private static int partition(double[] numbers, int lo, int hi) {
    	int i = lo;
		int j = hi+1;
		double pivot = numbers[lo];
		while(true) {
			while(numbers[++i] < pivot) 
			{
				if(i == hi) break;
			}
			while(numbers[--j] > pivot) 
			{
				if(j == lo) break;
			}
			
			if(i >= j) break;
			
			double temp = numbers[i];
			numbers[i] = numbers[j];
			numbers[j] = temp;
		}
		numbers[lo] = numbers[j];
		numbers[j] = pivot;
		return j;
    }//end quicksort
    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {
    	 /* Iterative mergesort function to sort arr[0...n-1] */
    	
    	if ( a == null ) return null;
              
    	int n = a.length;
    	// For current size of subarrays to be merged curr_size varies from 1 to n/2 
        int curr_size;  
                      
        // For picking starting index of left subarray to be merged 
        int left_start; 
                          
          
        // Merge subarrays in bottom up manner. 
        // First merge subarrays of size 1 to create sorted subarrays of size 2, 
        // then merge subarrays of size 2 to create sorted subarrays of size 4,  
        // and so on. 
        for (curr_size = 1; curr_size <= n-1; curr_size = 2*curr_size) 
        { 
              
            // Pick starting point of different subarrays of current size 
            for (left_start = 0; left_start < n-1; 
                        left_start += 2*curr_size) 
            { 
                // Find ending point of left subarray. mid+1 is starting point of right 
                int mid = Math.min(left_start + curr_size - 1, n-1); 
          
                int right_end = Math.min(left_start  
                             + 2*curr_size - 1, n-1); 
          
                // Merge Subarrays arr[left_start...mid] & arr[mid+1...right_end] 
                merge(a, left_start, mid, right_end); 
            } 
        } 
        
        return a;
        
    }
    
    /* Function to merge the two haves arr[l..m] and arr[m+1..r] of array arr[] */
    static void merge(double arr[], int l, int m, int r) { 
        int i, j, k; 
        int n1 = m - l + 1; 
        int n2 = r - m; 
      
        /* create temp arrays */
        double L[] = new double[n1]; 
        double R[] = new double[n2]; 
      
        /* Copy data to temp arrays L[] and R[] */
        for (i = 0; i < n1; i++) 
            L[i] = arr[l + i]; 
        for (j = 0; j < n2; j++) 
            R[j] = arr[m + 1+ j]; 
      
        /* Merge the temp arrays back into arr[l..r]*/
        i = 0; 
        j = 0; 
        k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
      
        /* Copy the remaining elements of L[], if there are any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
      
        /* Copy the remaining elements of R[], if there are any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } //end mergesortIterative
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    
    static double[] mergeSortRecursive( double a[] )
    {
    	if ( a == null ) return null; 
    	
    	recursive(a, 0, a.length - 1);
    	return a; 
    }
    
    private static void recursive (double a[], int left, int right)
    {
    	int mid;
	    if (right > left)
	    {
	    	mid = (right + left) / 2;
	    	recursive(a, left, mid);
	    	recursive(a, (mid + 1), right);
	    
	        doMerge(a, left, (mid+1), right);
	    }

    }
    
    private static void doMerge(double [] a, int left, int mid, int right)
    {
<<<<<<< HEAD
    	double [] temp = new double[1000];
=======
    	double [] temp = new double[25];
>>>>>>> 10c4063420121e003556e10db916813dc4d09af1
    	int i, left_end, num_elements, tmp_pos;
    	left_end = (mid - 1);
    	tmp_pos = left;
    	num_elements = (right - left + 1);
    	
    	while ((left <= left_end) && (mid <= right))
    	{
    		if (a[left] <= a[mid])
                temp[tmp_pos++] = a[left++];
            else
                temp[tmp_pos++] = a[mid++];
    	}
    	
    	while (left <= left_end)
          temp[tmp_pos++] = a[left++];
    	while (mid <= right)
          temp[tmp_pos++] = a[mid++];
    	
    	for (i = 0; i < num_elements; i++)
    	{
    		a[right] = temp[right];
    		right--;
    	}
    }
    
    //todo: implement the sort
	
   //end mergeSortRecursive

 }//end class