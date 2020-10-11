package app;
import java.util.ArrayList;
import java.util.List;

public class Board implements Ilayout, Cloneable {
	private int zeroR;
	private int zeroC;
	private static final int dim = 3;
	int board[][];

	public Board() {
		board = new int[dim][dim];
	}

	public Board(String str) throws IllegalStateException {

		if (str.length() != dim * dim)
			throw new IllegalStateException("Invalid arg in Board constructor");
		board = new int[dim][dim];
		int si = 0;

		for (int i = 0; i < dim; i++)
			for (int j = 0; j < dim; j++){
				board[i][j] = Character.getNumericValue(str.charAt(si++));
			
				if(board[i][j] == 0){
					zeroR = i;
					zeroC = j;
				}
			}
	}

	public Board(int[][] b, int zr, int zc) {
		zeroR = zr;
		zeroC = zc;
		board = new int[dim][dim];
		for (int r = 0; r < dim; r++) {
			for (int c = 0; c < dim; c++) {
				board[r][c] = b[r][c];
			}
		}
	}

    /**
     * Implemented for good measure
     * @return the hash code of the given board
     */
    @Override
    public int hashCode() {
		int decimalPlace=1;
		int hc = 0;
		for(int r = 0; r < dim; r++)
			for(int c = 0; c < dim; c++) {
				if(board[r][c] != 0)
					hc += board[r][c]*decimalPlace;
				decimalPlace*=10;

			}
		return hc;
	}
    /**
     * @return comparison function so that contains works properly
     */
	@Override
	public boolean equals(Ilayout I) {
		return isGoal(I);
	}
    /**
     * @return true if the receiver equals the argument 'I'; return false otherwise
     */	
	public boolean isGoal(Ilayout l) {
		if(l instanceof Board) {
			int b[][] = ((Board) l).board;
			for(int r = 0 ; r < dim; r++)
				for(int c = 0; c < dim; c++)
					if(board[r][c] != b[r][c])
						return false;
			return true;
		} else return false;
	}

	@Override
	public double getG() {
		return 1.0;					
	}

	@Override
	public List<Ilayout> children() {
																	
        List<Ilayout> list = new ArrayList<>();
		if(zeroC < dim-1) list.add(new Board(movCopy(board,zeroR,zeroC+1),zeroR,zeroC+1));
		if(zeroR < dim-1) list.add(new Board(movCopy(board,zeroR+1,zeroC),zeroR+1,zeroC));
		if(zeroC > 0) list.add(new Board(movCopy(board,zeroR,zeroC-1),zeroR,zeroC-1));
		if(zeroR > 0) list.add(new Board(movCopy(board,zeroR-1,zeroC),zeroR-1,zeroC));
		return list;
	}

	@Override
	public String toString() {
		String string = "";
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++)
				if (board[i][j] == 0)
					string += " ";
				else
					string += board[i][j];
			string += "\r\n";
		}
		return string;
	}

    private int[][] movCopy(int[][] old, int newZeroR, int newZeroC){
        int[][] temp = new int[dim][dim];
        for(int r = 0; r < dim; r++)
            for(int c = 0; c < dim; c++){
                if(r == newZeroR && c == newZeroC){
                    temp[r][c] = 0;
				} else if(old[r][c] == 0) {
					temp[r][c] = old[newZeroR][newZeroC];
				}
                else temp[r][c] = old[r][c];
            }
        return temp;
    }


}