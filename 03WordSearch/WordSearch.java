import java.util.*;//random, scanner, arrayList
import java.io.*;//file, filenotfoundexception

public class WordSearch{
    private char[][]data;
    private ArrayList<String> wordsToAdd = new ArrayList<String>();
    private ArrayList<String> wordsAdded = new ArrayList<String>();
    private Random rand;
    private char[][] key;
    private int seed;
    
    
    
    /**Initialize the grid to the size specified 
     *fill all of the positions with '_'
     *@param row is the starting height of the WordSearch
     *@param col is the starting width of the WordSearch
     */

    public WordSearch(int rows, int cols, String fileName){
        data = new char[rows][cols];
        key = new char[rows][cols];
        int randSeed = (int)(Math.random()*100000);
        rand = new Random(randSeed);
        seed = randSeed;
        clear();
        try{
            File f = new File(fileName);//can combine
            Scanner in = new Scanner(f);//into one line
            while (in.hasNext()){
                String wordin = in.next();
                wordsToAdd.add(wordin);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File Not Found: "+ fileName);
            //e.printStackTrace();
            System.exit(1);
        }
        addAllWords();
        fill();
    }
    
    public WordSearch(int rows, int cols, String fileName, int randSeed){
        data = new char[rows][cols];
        key = new char[rows][cols];
        rand = new Random(randSeed);
        seed = randSeed;
        clear();
        try{
            File f = new File(fileName);//can combine
            Scanner in = new Scanner(f);//into one line
            while (in.hasNext()){
                String wordin = in.next();
                wordsToAdd.add(wordin);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File Not Found: "+ fileName);
            //e.printStackTrace();
            System.exit(1);
        }
        addAllWords();
        fill();

    }
    /**Set all values in the WordSearch to underscores'_'*/
    private void clear(){
        for(int i = 0;i<data.length;i++){
            for(int p = 0;p<data[i].length;p++){
                data[i][p] = '_';
            }
        }
    }

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
    public String toString(){
        String ans = "";
        for(int i = 0;i<data.length;i++){
            for(int p = 0;p<data[i].length;p++){
                if(p == data[i].length-1){
                    ans += "|"+data[i][p]+"\n";
                }
                else{
                    ans += "|"+data[i][p];
                }
            }
        }
        
        return ans+"\nSeed: "+ this.getRandomSeed();
    }


    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     * or there are overlapping letters that do not match, then false is returned 
     * and the board is NOT modified.
     */
    public boolean addWordHorizontal(String word,int row, int col){
        for(int i = 0; i< word.length();i++){
            //if(data[row][col+i] != word.charAt(i)){
              //  return false;
            //}
            //else{
                data[row][col+i] = word.charAt(i);
            //}
        }
        return true;
    }

   /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top to bottom, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     *and the board is NOT modified.
     */
    public boolean addWordVertical(String word,int row, int col){
        for(int i = 0; i<word.length();i++){
            //if(data[row+i][col] != word.charAt(i)){
              //  return false;
            //}
            //else{}
                data[row+i][col]=word.charAt(i);
            //}
        }
        return true;
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top left to bottom right, must fit on the WordGrid,
     *and must have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordDiagonal(String word,int row, int col){
	   for(int i = 0; i<word.length();i++){
        data[row+i][col+i]=word.charAt(i);
	   }
        return true;
    }
    
    private boolean addWord(int row, int col, String word, int rowIncrement, int colIncrement){
        if(rowIncrement == 0 && colIncrement == 0){
            return false;
        }
        for(int i = 0; i< word.length();i++){
            try{
                if(data[row+(i*rowIncrement)][col+(i*colIncrement)] != word.charAt(i) && data[row+(i*rowIncrement)][col+(i*colIncrement)] != '_'){
                    return false;
                }
            }
            catch(ArrayIndexOutOfBoundsException e){
                return false;
            }
        }
        for(int i = 0;i<word.length();i++){
            data[row+(i*rowIncrement)][col+(i*colIncrement)] = word.charAt(i);
        }
        wordsAdded.add(word);
        wordsToAdd.remove(word);
        return true;
        
    }
    
    private boolean addAllWords(){
         int []  inc = {-1, 0, 1};
        for(int x = 0; x < 1000; x ++){
            if (wordsToAdd.size() == 0){
            return true;
            }
            int row = rand.nextInt(data.length);
            int col = rand.nextInt(data[0].length);
            String word = wordsToAdd.get(rand.nextInt(wordsToAdd.size()));
            int rInc = inc[rand.nextInt(3)];
            int cInc = inc[rand.nextInt(3)];
            addWord(row,col,word,rInc,cInc);
            for(int i = 0; i < data.length; i++){
                for(int p = 0; p<data[i].length;p++){
                    key[i][p] = data[i][p];
                }
            }
        }
        return false;
    }
    
    public int getRandomSeed(){
        return seed;
    }
    public String getKey(){
        String ans = "";
        for(int i = 0;i<key.length;i++){
            for(int p = 0;p<key[i].length;p++){
                if(p == key[i].length-1){
                    ans += "|"+key[i][p]+"\n";
                }
                else{
                    ans += "|"+key[i][p];
                }
            }
        }
        return ans;
    }
    
    public String getPuzzle(){
        String ans = "";
        for(int i = 0;i<data.length;i++){
            for(int p = 0;p<data[i].length;p++){
                if(p == data[i].length-1){
                    ans += "|"+data[i][p]+"\n";
                }
                else{
                    ans += "|"+data[i][p];
                }
            }
        }
        return ans;
    }
    

    private void fill(){
        for(int i = 0; i<data.length;i++){
            for(int c = 0;c<data[i].length;c++){
                if(data[i][c]=='_'){
                    String alph = "abcdefghijklmnopqrstuvwxyz";
                    char randletter = alph.charAt(rand.nextInt(26));
                    data[i][c] = randletter;
                }
            }
        }
        
    }

    public static void main(String[] args){
        WordSearch test = new WordSearch(20,20, "namestest.txt");
        System.out.println(test);
        System.out.println(test.getKey());
	System.out.println(test.getRandomSeed());
	System.out.println(test.addAllWords());
        int length = args.length;
        if(length == 0 || length == 1 || length == 2){
            System.out.println("ERROR!!!!!!!: \n Please specify number of rows, number of columns, filename of desired WordSearch puzzle, in that order. \n Optional: specify random Seed number and key if you want to display a specific seed puzzle and the answers to the puzzle. Otherwise a random seed will be generated for the puzzle and the solution will NOT be shown. \n Your options are: \n rows cols filename \n rows cols filename randomSeed \n rows cols filename randomSeed key \n You must type the word 'key' to view the solution. \n The name of the file must end in the extension 'txt' \n The row number, column number, and random seed must be POSITIVE INTEGER VALUES");
        }
        if(length == 3){
            int rows = Integer.parseInt(args[0]);
            int cols = Integer.parseInt(args[1]);
            String fileName = new String(args[2]);
            WordSearch create = new WordSearch(rows, cols, fileName);
            System.out.println(create);
	    System.out.println("Word Box: "+ create.wordsAdded);
                  
        }
        if(length == 4){
            int rows = Integer.parseInt(args[0]);
            int cols = Integer.parseInt(args[1]);
            String fileName = new String(args[2]);
            int randomSeed = Integer.parseInt(args[3]);
            WordSearch create = new WordSearch(rows, cols, fileName, randomSeed);
            System.out.println(create);
	    System.out.println("Word Box: "+ create.wordsAdded);
        }
        if(length == 5){
            int rows = Integer.parseInt(args[0]);
            int cols = Integer.parseInt(args[1]);
            String fileName = new String(args[2]);
            int randomSeed = Integer.parseInt(args[3]);
            WordSearch create = new WordSearch(rows, cols, fileName, randomSeed);
            System.out.println(create);
	    System.out.println("Word Box: "+ create.wordsAdded);
            if(args[4].equals("key")){
                System.out.println(create.getKey());
            }
            else{
                System.out.println("Error in printing the solution: \n If you want to print the solution, please write the word 'key' as the fifth element");    
            }
            
            
        }
    }


}

