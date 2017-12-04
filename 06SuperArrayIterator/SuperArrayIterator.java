import java.util.*;
public class SuperArrayIterator implements Iterator<String>{
        private SuperArray target;
        private int position = 0;
    
        public SuperArrayIterator(SuperArray s){
            target = s;
        }
        public String next(){
            if(hasNext()){
                position++;
            }
            else{
                System.exit(0);
            }
            return target.get(position-1);
        }
        public boolean hasNext(){
            return position < target.size();
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }