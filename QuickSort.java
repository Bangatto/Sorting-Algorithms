import java.util.Arrays;

public class QuickSort {
	/* 
	This function takes last element as pivot, 
    places the pivot element at its correct 
    position in sorted array, and places all 
    smaller (smaller than pivot) to left of 
    pivot and all greater elements to right 
    of pivot
    */
	int partition(int arr[], int leftdx, int rightIdx) 
 { 
     int pivot = arr[rightIdx];  
     int wall = (leftdx-1); // index of smaller element 
     for (int j=leftdx; j<rightIdx; j++) 
     { 
         // If current element is smaller than the pivot 
         if (arr[j] < pivot) 
         { 
             wall++; 
             // swap arr[wall] and arr[j] 
             int temp = arr[wall]; 
             arr[wall] = arr[j]; 
             arr[j] = temp; 
         } 
     } 

     // swap arr[wall] and arr[rightIdx] (or pivot) 
     int temp = arr[wall+1]; 
     arr[wall+1] = arr[rightIdx]; 
     arr[rightIdx] = temp; 

     return wall+1; 
 } 
 /* The main function that implements QuickSort() 
   arr[] --> Array to be sorted, 
   leftIdx --> Starting index, 
  rightIdx --> Ending index 
 */
 void QuickSort(int arr[], int leftIdx, int rightIdx) 
 { 
     if (leftIdx < rightIdx) 
     { 
         /* pivot is partitioning index, arr[pivot] is  
           now at right place */
         int pivot = partition(arr, leftIdx, rightIdx); 
      // Recursively sort elements smaller than the pivot
         QuickSort(arr, leftIdx, pivot-1); 
      // Recursively sort elements bigger than the pivot
         QuickSort(arr, pivot+1, rightIdx); 
     } 
 } 
	public static void main(String[] args) {
		int arr[] = {10, 7, 8, 9, 1, 5}; 
        int n = arr.length; 
        QuickSort object = new QuickSort(); 
        object.QuickSort(arr, 0, n-1); 
        System.out.println(Arrays.toString(arr));

	}
/*
 * time complexity  is O(nlogn)
 * worst case O(n^2)...if the pivot chosen is the smallest element or its the largest element 
 */
}
