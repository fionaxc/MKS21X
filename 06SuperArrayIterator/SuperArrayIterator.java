private class SuperArrayIterator extends SuperArray implements Iterator<String>{
        private SuperArray target;
        private int element;
        public SuperArrayIterator(SuperArray s, int i){
            target = s;
            element = i;
        }
        public String next(){
            if(hasNext()){
                element++;
            }
            else{
                System.exit(0);
            }
            return target.get(element-1);
        }
        public boolean hasNext(){
            return element < target.size();
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }