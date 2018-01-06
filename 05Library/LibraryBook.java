public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;

    public LibraryBook(String a, String t, String I, String call){
	   super(a,t,I);
	   callNumber = call;
    }

    public String getCallNumber(){
        return callNumber;
    }

    public abstract void checkout(String patron, String due);
    public abstract void returned();
    public abstract String circulationStatus();

    public int compareTo(LibraryBook other){
        return callNumber.compareTo(other.getCallNumber());
    }

    public void setCallNumber(String call){
        callNumber = call;
    }
    public String toString(){
        return super.toString()+" Circulation Status:  "+circulationStatus()+" Call Number: "+callNumber;
    }


}
