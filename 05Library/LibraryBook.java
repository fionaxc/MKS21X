public abstract Class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;
    
    public LibraryBook(String a, String t, String I, String call){
	   super(a,t,I,call);
	   callNumber = call;
    }

    public String getCallNumber(){
        return callNumber;
    }
    
    abstract void checkout(String patron, String due);
    abstract void returned();
    abstract String circulationStatus();
    
    public int compareTo(LibraryBook other){
        return Integer.compare(this.callNumber, other.callNumber);
    }
    
    public String toString(){
        return super.toString()+" "+this.circulationStatus()+" "+callNumber
    }


}
