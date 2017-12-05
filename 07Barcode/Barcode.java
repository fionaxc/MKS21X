public class Barcode implements Comparable<Barcode>{
    private String zip;
    public Barcode(String zip){
        if(zip.length() != 5 || this.checkNum(zip)){
            throw new IllegalArgumentException;
        }
        else{
             this.zip = zip;     
        }

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
    
    public int getSum(String target){
        int sum = 0;
        for(int i = 0; i<target.length;i++){
            
        }
    }
    
    public String getZip(){
        return zip;
    }
    
    public static String toCode(String zip){
        
    }
    public String toString(){
        
    }
}