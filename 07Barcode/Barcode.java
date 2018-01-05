import java.util.*;
import java.io.*;

public class Barcode implements Comparable<Barcode>{
    private String zip;
    public Barcode(String zip){
        for (int i = 0; i < zip.length(); i++){
	    if ("0123456789".indexOf(zip.substring(i,i+1)) == -1){
		throw new IllegalArgumentException();
	    }
	}
        if(zip.length() != 5 || this.checkNum(zip)){
            throw new IllegalArgumentException();
        }
       
        this.zip = zip;     

<<<<<<< HEAD
        this.zip = zip;
      }
=======
    }
>>>>>>> fb52034814ec6e0a11ff509844c1b3b41f757ec1

    public String getZip(){
        return zip;
    }
    private int zipToInt(){
	     return Integer.parseInt(zip);
    }

    public String getCode(){
	    	String ans = "";
	    	int sum = 0;
	    	for(int i = 0; i < zip.length(); i++){
	    	    String target = zip.substring(i,i+1);
	    	    sum += Integer.parseInt(target);
	    	    ans += getNumCode(Integer.parseInt(target));
	    	}
	    	ans += getNumCode(sum % 10);
	    	return "|"+ ans + "|";
    }
<<<<<<< HEAD

    private static String getNumCode(int i){
        String[] codes = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:", "|:|::"};
        return codes[i];
    }


=======
    
    public int getSum(String target){
        int sum = 0;
        for(int i = 0; i<target.length();i++){
            sum += Integer.parseInt(target.zip.substring(i,i+1));
        }
        return sum;
    }
    
    private static String getNumCode(int i){
    		String[] codes = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:", "|:|::"};
    		return codes[i];
    }
   
>>>>>>> fb52034814ec6e0a11ff509844c1b3b41f757ec1
    public boolean checkNum(String target){
        int sum = 0;
        for(int i = 0; i< target.length();i++){
            if("012345689".indexOf(target.charAt(i)) == -1){
                sum ++;
            }
        }
        return sum == 0;
    }

<<<<<<< HEAD

=======
    
>>>>>>> fb52034814ec6e0a11ff509844c1b3b41f757ec1
    public static String toZip(String code){
		    	if (code.length() != 32 || code.charAt(0) != '|' || code.charAt(code.length() - 1) != '|'){
		    	    throw new IllegalArgumentException();
		    	}
		    	code = code.substring(1, 31);
		    	int total = 0;
		    	String ans = "";
		    	String[] codes = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:", "|:|::"};
		    	ArrayList<String> tmp = new ArrayList<String>();
		    	for (int i = 0; i < 10; i++){
		    	    tmp.add(codes[i]);
		    	}

		    	for (int i = 0; i < 25; i++){
		    	    int found = tmp.indexOf(code.substring(i, i + 5));
		    	    if (found == -1){
		    	    		throw new IllegalArgumentException();
		    	    }
		    	    total += found;
		    	    ans += found;
		    	    i += 4;
		    	}
          if (!(code.substring(25,30).equals(getNumCode(total % 10)))){
        	    throw new IllegalArgumentException();
        	}
		    	return ans;
    }

    public static String toCode(String zip){
<<<<<<< HEAD
    		Barcode code = new Barcode(zip);
    		return code.getCode();
=======
    		Barcode tmp = new Barcode(zip);
    		return tmp.getCode();
>>>>>>> fb52034814ec6e0a11ff509844c1b3b41f757ec1
    }

    public String toString(){
	return getCode() + " (" + zip + ")";
    }

    public int compareTo(Barcode b){
<<<<<<< HEAD
	return this.zipToInt() - b.zipToInt();
    }

    public boolean equals(Barcode b){
	return this.zipToInt() == b.zipToInt();
    }

}
=======
	return zipToInt() - b.zipToInt();
    }

    public boolean equals(Barcode b){
	return zipToInt() == b.zipToInt();
    }

}

>>>>>>> fb52034814ec6e0a11ff509844c1b3b41f757ec1
