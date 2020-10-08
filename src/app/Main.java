package app;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main (String [] args) {
       /* Scanner sc = new Scanner(System.in);

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
        sc.close();*/
        Board test = new Board("023145678");
        test.children();
        /*List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("12");
        list.add("123");
        list.add("1234");
        list.add("12345");
        Iterator<String> itr = list.iterator();
        while(itr.hasNext())
            System.out.println(itr.next());*/

        
    }

} 