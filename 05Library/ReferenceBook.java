public class ReferenceBook extends LibraryBook{
    private String collection;
    
    public ReferenceBook(String a, String t, String I, String call, String c){
        super(a,t,I,call);
        collection = c;
    }
    
    public String getCollection(){
        return collection;
    }
}