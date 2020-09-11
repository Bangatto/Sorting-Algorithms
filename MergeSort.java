import java.util.Arrays;

public class MergeSort {
	//Idea is divide the array into two parts (i) left array and (ii) right array
	//Sort the resulting parts recursively using merge sort algorithm
	//Combine the two parts once each is sorted fully
	//Start at the beginning of the collective array and pick the smallest element between left (LA) and Right(RA)
	//Repeat the same until all elements from LA and RA are in the collective array
	private void Sort(int arr[], int leftId, int rightId) {
		if (leftId < rightId) {
			int midId = (leftId + rightId)/2; // divide the array into two parts
			Sort(arr, leftId, midId);  // sort the left side recursively
			Sort(arr, midId+1, rightId); // sort the right side recursively
			
			//merge the two halves
			mergeSort(arr, leftId, midId, rightId);
		}
	}

	private void mergeSort(int arr[], int leftId, int midId, int rightId) {
		//two array leftside (Lx) and right side (Rx)
		//arr[Lx......Mid] and arr[mid+1----Rx]
		//find the lenght of each array
		int LL = midId -leftId + 1; //LL--length of left array
		int LR = rightId - midId;  //LR -- length of right array
		
		//populate the size of the two array and create Temp arrays
		int[] LA = new int[LL]; //LA-->Left Array
		int[] RA = new int[LR]; // RA --> Right Array
		
		//Copy elements into the Temp Array
		for (int i = 0; i < LL; i++) { 
			LA[i] = arr[leftId + i]; //copy into left array
		}
		for (int j = 0; j < LR; j++) { //copy into the right array
			RA[j] = arr[midId+1+j];
		}
		//check for the smallest element and add into the collective array
		int i = 0; int j = 0;
		int k = leftId;
		while (i < LL && j < LR){
			if (LA[i] < RA[j]) {
				arr[k] = LA[i];
				i++;
			}else {
				arr[k] = RA[j];
				j ++;
			}
			k++;
		}
		//case where there are remaining elements in Left Array, copy into collective array
		while ( i < LL) {
			arr[k]= LA[i] ;
			i++;
			k++;
		}
		//case where there are remaining elements in Right Array, copy into collective array
		while ( j < LR) {
			 arr[k] =  RA[j];
			 j ++;
			 k ++;
		}
		
	}
	/* A utility function to print array of size n
    static void printArray(int arr[]){ 
        int n = arr.length; 
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
    */
	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7 }; 
		  
        System.out.println("Given the unsorted Array---->" + Arrays.toString(arr)); 
        MergeSort merge = new MergeSort(); 
        merge.Sort(arr, 0, arr.length - 1); 
  
        System.out.println("The Sorted array ----------->" + Arrays.toString(arr)); 

	}

}
