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
    
    public String checkout(String patron, String due){
        return "cannot check out reference book";
    }
    
    public String returned(){
        return "reference book could not have been checked out -- return impossible";
    }
    
    public String circulationStaus(){
        return "non-circulating reference book";
    }
    
    public String toString(){
        super.toString() + "Collection: " + getCollection();
    }
}