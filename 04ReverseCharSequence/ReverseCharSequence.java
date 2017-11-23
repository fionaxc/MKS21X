public class ReverseCharSequence implements CharSequence{
    private bkstring;
    public ReverseCharSequence(String str){
	String ans = "";
	for(int i = str.length-1; i>=0;i--){
	    ans += str.substring(i,i+1);
	}
	bkstring = ans;
    }
    
    public static char charAt(int index){
	return bkstring.charAt(index);
    }

    public static int length(){
	return bkstring.length();
    }

    public static CharSequence subSequence(int start, int end){
    }

    public static String toString(){
	return bkstring;
    }
    
}
