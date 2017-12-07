public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;
    
    public LibraryBook(String a, String t, String I, String call){
	   super(a,t,I);
	   callNumber = call;
    }

    public String getCallNumber(){
        return callNumber;
    }
    
    abstract void checkout(String patron, String due);
    abstract void returned();
    abstract String circulationStatus();
    
    public int compareTo(LibraryBook other){
        return this.callNumber.compareTo(other.callNumber);
    }
    
    public void setCallNumber(String call){
        callNumber = call;
    }
    public String toString(){
        return super.toString()+" Circulation Status:  "+this.circulationStatus()+" Call Number: "+callNumber;
    }


}
