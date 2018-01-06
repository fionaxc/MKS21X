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

    public void checkout(String patron, String due){
        System.out.println("cannot check out reference book");
    }

    public void returned(){
        System.out.println("reference book could not have been checked out -- return impossible");
    }

    public String circulationStatus(){
        return "non-circulating reference book";
    }

    public String toString(){
        return super.toString() + "Collection: " + collection;
    }
}
