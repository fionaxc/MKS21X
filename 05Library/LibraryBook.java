public abstract Class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;
    public LibraryBook(String a, String t, String I, String call){
	super(a,t,I,call);
	callNumber = call;
    }

   



}
