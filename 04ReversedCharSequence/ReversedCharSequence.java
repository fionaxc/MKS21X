public class ReversedCharSequence implements CharSequence{
    public String bkstring;
    public String string;
    public ReversedCharSequence(String str){
        String ans = "";
	    for(int i = str.length()-1; i>=0;i--){
	        ans += str.substring(i,i+1);
	    }
	    bkstring = ans;
        string = str;
    }
    
    public char charAt(int index){
	   return bkstring.charAt(index);
    }

    public int length(){
	   return bkstring.length();
    }

    public CharSequence subSequence(int start, int end){
        ReversedCharSequence r = new ReversedCharSequence(bkstring.substring(start,end));
        return new ReversedCharSequence(r.bkstring);
    }

    public String toString(){
	   return bkstring;
    }

    /*
    public static void main(String[] args){
        String s = "ABCDEF";
        ReversedCharSequence r = new ReversedCharSequence(s);
        System.out.println(r.subSequence(0,4));
    }
    */
}
