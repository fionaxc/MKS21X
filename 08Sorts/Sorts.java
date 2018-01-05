import java.util.Arrays;

public class Sorts{
	  /**EDIT THIS METHOD TO MATCH YOUR NAME 
	  */
	  public static String name(){
	    return "09.Cai.Fiona"; 
	  }

	  /**Selection sort of an int array. 
	  *Upon completion, the elements of the array will be in increasing order.
	  *@param data  the elements to be sorted.
	  */
	  public static void selectionSort(int[] data){  
	  	for(int i = 0; i < data.length-1;i++) {
	  		int index = i;
	  		for(int k = i+1; k <data.length;k++) {
	  			if(data[k] < data[index]) {
	  				index = k;
	  			}
	  		}
	  		int smallernum = data[index];
	  		data[index] = data[i];
	  		data[i] = smallernum;
	  	}
	  }
	  
	  public static void insertionSort(int[] data) {
		  int temp;
	        for (int i = 1; i < data.length; i++) {
	            for(int j = i ; j > 0 ; j--){
	                if(data[j] < data[j-1]){
	                    temp = data[j];
	                    data[j] = data[j-1];
	                    data[j-1] = temp;
	                }
	            }
	        }
	  }
  
  public static void swap(int index1, int index2, int[] Array){
   		int secondvalue = Array[index2];
    	int firstvalue = Array[index1];
    	Array[index1] = secondvalue;
    	Array[index2] = firstvalue;
  }
  
  public static void bubbleSort(int[] data){
    int numswap = 2;
    while(numswap > 0){
    numswap = 0;
    for(int i = 0; i<data.length-1;i++){
      if(data[i+1] < data[i]){
        swap(i,i+1,data);
        numswap++;
      }
    }
    }
  }
  
  public static void printArray(int[] arr){
  	int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
  }
  public static void main(String[]args){
      /*
    //Change this part with any test case you like by
    //commenting and uncommenting
    
    //int[] a = {64, 25, 12, 22, 11};
    int[] a = {34, 25, 12, 22, 12};
    //int[] a = {6, 25, -12, 22, 1, 32, 22};
    //int[] a = {-5, -25, -12, -15, 1};
    //int[] a = {1, 1, 0, 1, 0, 0};
    //int[] a = {1932, -25, 12, 12, 3};
    //int[] a = {4, 23, -12, 0, 11, 1, 4, 99, 32, 14, 19, 23};
	System.out.println("---Unsorted Array---");
    printArray(a);
    bubbleSort(a);
    System.out.println("---Sorted Array---");
    printArray(a);
      */
	}
}

	  

