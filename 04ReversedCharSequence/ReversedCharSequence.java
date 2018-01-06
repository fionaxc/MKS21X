public class ReversedCharSequence implements CharSequence{
    public String bkstring;
    public String string;


    public ReversedCharSequence(String str){
      string = str;
      bkstring = "";
	    for(int i = str.length()-1; i> -1;i--){
	        bkstring += str.substring(i,i+1);
	    }
    }

    public char charAt(int index){
	   return bkstring.charAt(index);
    }

    public int length(){
	   return bkstring.length();
    }

    public ReversedCharSequence subSequence(int start, int end){
        String sub ="";
    for (int i = start; i < end; i++) {
      sub += bkstring.charAt(i);
    }
    String tmp = "";
    for (int i = sub.length() - 1; i >= 0; i--) {
      tmp += sub.charAt(i);
    }
    ReversedCharSequence ans = new ReversedCharSequence(tmp);
    return ans;


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
