public class ReferenceBook extends LibraryBook{
    private String collection;
    
    public ReferenceBook(String a, String t, String I, String call, String collect){
        super(a,t,I,call);
        collection = collect;
    }
    
    public String getCollection(){
        return collection;
    }
    
    public void setCollection(String collect){
        collection = collect;
    }
}