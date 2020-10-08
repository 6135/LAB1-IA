package app;

import java.util.ArrayList;
import java.util.List;

public class Board implements Ilayout, Cloneable {
    private static final int dim=3;
    private int board[][];
    String s="";
    String boardFormat="";
    int empty;
    
    public Board(){
        board = new int[dim][dim];
    }
    
    public Board (String str) throws IllegalStateException{
        if(str.length() != dim*dim) throw new IllegalStateException("Invalid arg in Board constructor");
        
        board = new int[dim][dim];

        int si=0;
        for(int i=0;i<dim;i++)
            for(int j=0;j<dim;j++){
                if(str.charAt(si)==0)
                    empty=si;
                board[i][j] = Character.getNumericValue(str.charAt(si++));
            }

    }
    @Override
    public String toString() {
        if(boardFormat.equals("")){
            String s = toStringLong();
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(s.charAt(i) == '0')
                    boardFormat+=" ";
                else boardFormat+=c;
                if((i+1)%dim == 0 && (i+1)/dim != dim)
                    boardFormat+="\n";
            }
        }
        return boardFormat;
    }
    
    public String toStringLong(){
        if(s.equals(""))
            for(int i=0;i<dim;i++)
                for(int j=0;j<dim;j++)
                    s += String.valueOf(board[i][j]);
        return s;
    }

    @Override
    public List<Ilayout> children() {
        List<Ilayout> children = new ArrayList<>(); 
        int row = empty%dim;
        int col = ;
        return children;
    }

    @Override
    public boolean isGoal(Ilayout I) {
        if(toString().equals(I.toString())) return true;
        else return false;
    }

    @Override
    public double getG() {
        return 1;
    }

}
