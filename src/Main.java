import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Main {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);

        BestFirst s = new BestFirst();
        Iterator<BestFirst.State> it = s.solve(new Board(sc.next()),new Board(sc.next()));

        if(it==null) System.out.println("no solution was found");
        else{
            while(it.has.next()){
                BestFirst.State i = it.next();
                System.out.println(i);
                if(!it.hasNext()) System.out.println(i.getG());
            }
        }
    }

} 