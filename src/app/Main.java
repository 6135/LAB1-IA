package app;
import java.util.Scanner;

<<<<<<< HEAD
=======
import java.util.Iterator;
>>>>>>> 00ee75bcca710729f87061c8bdcf08af83ac7631

public class Main {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);

        BestFirst s = new BestFirst();
        Iterator<BestFirst.State> it = s.solve(new Board(sc.next()),new Board(sc.next()));

        if(it==null) System.out.println("no solution was found");
        else{
            while(it.hasNext()){
                BestFirst.State i = it.next();
                System.out.println(i);
                if(!it.hasNext()) System.out.println(i.getG());
            }
        }
    }

} 