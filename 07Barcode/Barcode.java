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
        if(zip.length() != 5){
            throw new IllegalArgumentException();
        }

        this.zip = zip;
      }

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
	    	    sum += Integer.parseInt(zip.substring(i,i+1));
	    	    ans += getNumCode(Integer.parseInt(zip.substring(i,i+1)));
	    	}
	    	ans += getNumCode(sum % 10);
	    	return "|"+ ans + "|";
    }

    private static String getNumCode(int i){
        String[] codes = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:", "|:|::"};
        return codes[i];
    }
    public int compareTo(Barcode b){
       return this.zipToInt() - b.zipToInt();
    }

    public boolean checkNum(String target){
        int sum = 0;
        for(int i = 0; i< target.length();i++){
            if("012345689".indexOf(target.charAt(i)) == -1){
                sum ++;
            }
        }
        return sum == 0;
    }

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
    		Barcode tmp = new Barcode(zip);
    		return tmp.getCode();
    }

    public String toString(){
	return getCode() + " (" + zip + ")";
    }


    public boolean equals(Barcode b){
	return this.zipToInt() == b.zipToInt();
    }

}
