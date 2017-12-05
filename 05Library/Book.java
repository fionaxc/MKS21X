public class Book{
    private String author;
    private String title;
    private String isbn;

    public Book(String a, String t, String I){
        author = a;
        title = t;
        isbn = I;
    }

    public String getAuthor(){
	return author;
    }

    public String getTitle(){
	return title;
    }

    public String getISBN(){
	return isbn;
    }

    public void setAuthor(String a){
	author = a;
    }

    public void setTitle(String t){
	title = t;
    }

    public void setIBSN(String I){
        isbn= I;
    }

    public String toString(){
	return "Title: "+title+"; Author: "+author+"; IBSN: "+isbn;
    }
}

    
