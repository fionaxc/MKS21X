public class OrderedSuperArray extends SuperArray{

 
  public OrderedSuperArray(){
      super();
  }

  public OrderedSuperArray(int capacity){
	super(capacity);
    }

  public void add(int index, String value){
    add(value);
  }

  public boolean add(String value){
      super.add(findIndexBinary(value),value);
      return true;
  }

  public int indexOfBinary(String element){
      if (size() <= 0) {
			return -1;
		}
		int start = 0;
		int end = size()-1;
		while (start != end) {
			int middle = (start + end) / 2;
			if (super.get(middle).compareTo(element) == 0) {
				end = middle;
			}
			else if (super.get(middle).compareTo(element) < 0) {
				start = middle + 1;
			}
			else {
				end = middle;
			}
		}
		return start;
    }
  private int findIndexBinary(String element){
      if(size()==0){
          return 0;
      }
      int start = 0;
        int end = size()-1;
        while(start < end-2){
            int middle = (start+end)/2;
            if(element.compareTo(super.get(middle)) > 0){
                start = middle + 1;
            }
            else{
                end = middle;
            }
        }
      if(start == end){
          return start + 1;
      }
      else{
          return end;
      }
    }
}


