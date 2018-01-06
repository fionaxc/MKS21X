import java.util.*;
import java.util.ArrayList;
public class SuperArray{

    private String[] data;
    private int size = 0;

    public SuperArray(){
        data = new String[10];
    }

    public SuperArray(int capacity){
	     data = new String[capacity];
    }


    public void clear(){
        data = new String[10];
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }


    public boolean add(String element){
        if (data.length == size){
            resize();
        }
        data[size] = element;
        size++;
        return true;
    }


    public String toString(){
      if (size == 0){
          return "[]";
      }
      String arr = "[";
      for (int i = 0 ; i < size() - 1 ; i++) {
          arr += data[i];
          arr += ", ";
      }
      return arr + data[size()-1] + "]";
    }


    public String get(int index){
        if (index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();

        }
     return data[index];
    }

    public String set(int index, String element){
        if (index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();

        }
        String getsReturned = data[index];
        data[index] = element;
        return getsReturned;
    }

    private void resize(){
        String[] resizedArray = new String[size * 2];
        for (int i = 0; i < size; i++){
            resizedArray[i] = data[i];
        }
        data = resizedArray;
    }

    public boolean contains(String element){
        for (int i = 0; i < size; i++){
            if (data[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void add(int index, String element){
      if(data.length == size){
        resize();
      }

          String[] tmp = new String[data.length];
        if (index < 0 || index > size()){
            throw new IndexOutOfBoundsException();
        }
        if (data.length == size){
    	    		resize();
    		}


            for (int i = 0; i < index; i++){
        			tmp[i] = data[i];
        		}
        		tmp[index] = element;
        		for (int i=index; i<size; i++){
        		    tmp[i+1] = data[i];
        		}
        		data = tmp;
        		size+=1;
    }

    public int indexOf(String element){
        for (int i = 0; i < size; i++){
            if (data[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(String element){
        for (int i = size-1; i >= 0; i--){
            if (data[i].equals(element)){
                return i;
            }
        }
        return -1;

    }



    public String remove(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();

        }

        String element = data[index];
        String[] tmp = new String[size-1];
        for (int i = 0; i < index; i++){
            tmp[i] = data[i];
        }
        for (int i = index; i < size - 1 ; i++){
    	    		tmp[i] = data[i+1];
    		}
    		data = tmp;
        size -=1;
        return element;
    }

    public boolean remove(String element){
        if (contains(element)) {
            remove(indexOf(element));
            return true;
        }
        return false;
    }
/*
    public static void main(String[] args) {
      SuperArray s1 = new SuperArray();
      ArrayList<String> s2 = new ArrayList<>();
      s1.add("0");
      s2.add("0");
      s1.add("1");
      s2.add("1");
      s1.add(1,"5");
      s2.add(1,"5");
      s1.add(0,"6");
      s2.add(0,"6");
      s1.add(s1.size(),"4");
      s2.add(s2.size(),"4");
    }
*/
}
