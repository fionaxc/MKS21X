public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String a, String t, String I, String call){
        super(a,t,I,call);
        currentHolder = null;
        dueDate = null;
    }

    public String getCurrentHolder(){
        return currentHolder;
    }

    public String getDueDate(){
        return dueDate;
    }

    public void setCurrentHolder(String holdername){
        currentHolder = holdername;
    }

    public void setDueDate(String date){
        dueDate = date;
    }

    public void checkout(String patron, String due){
        currentHolder = patron;
        dueDate = due;
    }

    public void returned(){
        currentHolder = null;
        dueDate = null;
    }

    public String circulationStatus(){
        if(currentHolder != null){
            return "Current Holder: "+currentHolder+ " Due Date: "+dueDate;
        }
        else{
            return "book available on shelves";
        }
    }

    public String toString(){
      if (currentHolder != null){
    			return super.toString() + " Current Holder:  " + currentHolder + " Due Date: " + dueDate;
    		}

    		return super.toString();

    }
}
