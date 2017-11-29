public class Book{
    private String author;
    private String title;
    private String ISBN;

    public Book{
	
    }

    public Book(String a, String t, String I){
	author = a;
	title = t;
	ISBN = I;
    }

    public String getAuthor(){
	return author;
    }

    public String getTitle(){
	return title;
    }

    public String getISBN(){
	return ISBN;
    }
}

    
