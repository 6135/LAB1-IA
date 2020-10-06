package app;
public class Board implements Ilayout, Cloneable{
    private static final int dim=3;
    private int board[][];
    
    public Board(){
        board = new int[dim][dim];
    }
    
    public Board (String str) throws IllegalStateException{
        if(str.length() != dim*dim) throw new IllegalStateException("Invalid arg in Board constructor");
        
        board = new int[dim][dim];

        int si=0;
        for(int i=0;i<dim;i++)
            for(int j=0;j<dim;j++) 
                board[i][j] = Character.getNumericValue(str.charAt(si++));

    }

    public String toString(){
        String s="";
        for(int i=0;i<dim;i++)
            for(int j=0;j<dim;j++)
                s += String.valueOf(board[i][j]);
        return s;
    }
}