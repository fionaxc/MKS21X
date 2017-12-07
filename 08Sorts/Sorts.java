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
}
	  

