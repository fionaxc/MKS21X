
import java.util.*;
import java.io.*;

public class Barcode implements Comparable<Barcode>{
    //Field variables
	private String zip;
    
	//Constructor
    public Barcode(String zip){
        if(zip.length() != 5 || this.checkNum(zip)){
            throw new IllegalArgumentException();
        }
        else{
             this.zip = zip;     
        }

    }
    
    //Getter Methods
    public String getZip(){
        return zip;
    }
    
    public String getCode(){
	    	String ans = "";
<<<<<<< HEAD
	    	int sum = 0;
	    	for (int i = 0; i < zip.length(); i++){
	    		String target = zip.substring(i,i+1);
	    	    sum += Integer.parseInt(target);
	    	    ans += getNumCode(Integer.parseInt(target));
	    	}
	    	ans += getNumCode(total % 10);
	    	return "|"+ ans + "|";
    }
    
    //get the sum of the zip
    public int getSum(String target){
        int sum = 0;
        for(int i = 0; i<target.length;i++){
            sum += Integer.parseInt(target.zip.substring(i,i+1));
        }
        return sum;
    }
    
    //Match number to code
    private  String getNumCode(int i){
    		String[] codes = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:", "|:|::"};
    		return code[i];
    }
    
    //check if all numbers of zip are numbers 
    public boolean checkNum(String target){
        int sum = 0;
        for(int i = 0; i< target.length();i++){
            if("012345689".indexOf(target.charAt(i)) == -1){
                sum ++;
            }
        }
        return sum == 0;
    }
    
	    	for (int i = 0; i < zip.length(); i++){
	    		String target = zip.substring(i,i+1);
	    	    ans += getNumCode(Integer.parseInt(target));
	    	}
      		int sum = getSum(zip);
	    	ans += getNumCode(sum % 10);
	    	return "|"+ ans + "|";
    }
    

    //Compare TO
    public int compareTo(Barcode target){
    	return Integer.parseInt(zip) - Integer.parseInt(target.zip);
        }
    
    //code to zip
    public static String toZip(String code){
		    	if (code.length() != 32 || code.charAt(0) != '|' || code.charAt(code.length() - 1) != '|'){
		    	    throw new IllegalArgumentException();
		    	}
		    	code = code.substring(1, 31);
		    	int total = 0;
		    	String ans = "";
		    	String[] codes = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:", "|:|::"};
		    	ArrayList<String> a = new ArrayList<String>();
		    	for (int i = 0; i < 10; i++){
		    	    a.add(codes[i]);
		    	}
		    	
		    	for (int i = 0; i < 25; i++){
		    	    int found = a.indexOf(code.substring(i, i + 5));
		    	    if (found == -1){
		    	    		throw new IllegalArgumentException();
		    	    }
		    	    total += found;
		    	    ans += found;
		    	    i += 4;
		    	}
		    	return ans;
    }
    
    //zip to code
    public static String toCode(String zip){
    		Barcode tmp = new Barcode(zip);
    		return tmp.getCode();
    }

    //To string 
    public String toString(){
    	return getCode() + " (" + zip + ")";
    }
    
    //Supplementary Methods---------------------
    //get the sum of the zip
    public int getSum(String target){
        int sum = 0;
        for(int i = 0; i<target.length();i++){
            sum += Integer.parseInt(target.substring(i,i+1));
        }
        return sum;
    }
    
    //Match number to code
    private static String getNumCode(int i){
    		String[] codes = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:", "|:|::"};
    		return codes[i];
    }
    
    //check if all numbers of zip are numbers 
    public boolean checkNum(String target){
        int sum = 0;
        for(int i = 0; i< target.length();i++){
            if("012345689".indexOf(target.charAt(i)) == -1){
                sum ++;
            }
        }
        return sum == 0;
    }
    


