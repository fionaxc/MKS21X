import java.util.*;
public class SuperArray implements Iterable<String>{
    private String[] data;
    private int size;

    public SuperArray(){
        data = new String[10];
    }

    public SuperArray(int startingCapacity){
	size = startingCapacity;
    }


    public void clear(){
        data = new String[data.length];
        size = 0;
    }

    public int size(){
        return size;    
    } 
    
    public boolean isEmpty(){
        return size() == 0;
    }


    public boolean add(String element){
        if (size() == data.length){
            resize();
        }
        data[size()] = element;
        size++;
        return true;
    }
    
    
    public String toString(){
        String strArr = "[";
        for (int i = 0; i < size() - 1; i++){
            strArr += get(i) + ", "; 
        }
        return  strArr += get(size() - 1) + "]";    
    }
    

    public String get(int index){
        if (index < 0 || index >= size()){
            System.out.println("Invalid index at: "+index);
        
        }
     return data[index]; 
    }

    public String set(int index, String element){
        if (index < 0 || index >= size()){  
            System.out.println("Invalid index at: "+index);     
     
        }
        String getsReturned = get(index);
        data[index] = element;
        return getsReturned;
    }

    private void resize(){
        String[] resizedArray = new String[size * 2];
        for (int i = 0; i < size(); i++){
            resizedArray[i] = get(i);
        }
        data = resizedArray;
    }

    public boolean contains(String element){
        boolean contain = false;
        for (int i = 0; i < size(); i++){
            if (get(i).equals(element)) {
                contain = true;
            }
        }
        return contain;
    }

    public int indexOf(String element){
        for (int i = 0; i < size(); i++){
            if (get(i).equals(element)){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(String element){
        int high = 0;
        for (int i = 0; i < size(); i++){
            if (get(i).equals(element)){
                high = i;
            }
        }
        return high;
    }

    public void add(int index, String element){
        
        if (index < 0 || index >= size()){
            System.out.println("Invalid index at: "+index);
        }else {
            resize();
        
            for (int i = size() - 1; i > index -1; i--) {
                data[i + 1] = get(i);
            }
        
            set(index, element); 
            size++;
        }
    }

    public String remove(int index){
        if (index < 0 || index >= size()){
            System.out.println("Invalid index at: "+index); 

        }
        
        String element = get(index);
        for (int i = index; i < size() - 1; i++){
            set(i, get(i + 1));
        }
        size--;
        return element;
    }

    public boolean remove(String element){
        if (indexOf(element) != -1) {
            remove(indexOf(element));
            return true;
        }
        return false;
    }
    
    public Iterator<String> iterator(){
        return new SuperArrayIterator(this);
    }


}
