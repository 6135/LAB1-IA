
package test;

import org.junit.Test;
import app.Board;
import app.BestFirst;
import app.Ilayout;
import app.BestFirst.State;
import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class PuzzleUnitTests {
    private static final String List = null;

    @Test (timeout = 1000)
    public void testConstructor() {
        Board b = new Board("023145678");
        StringWriter writer = new StringWriter();
        PrintWriter pw = new PrintWriter ( writer ) ;
        pw.println(" 23");
        pw.println("145");
        pw.println("678");
        assertEquals(writer.toString(), b.toString());
        pw.close();
    }
    @Test (timeout = 1000)
    public void testConstructor2() {
        Board b = new Board("123485670");
        StringWriter writer = new StringWriter();
        PrintWriter pw = new PrintWriter (writer) ;
        pw.println("123");
        pw.println("485");
        pw.println("67 ");
        assertEquals(writer.toString(), b.toString());
        pw.close();
    }

    @Test (timeout = 10000)
    public void testChildren(){
        long startTime = System.nanoTime();
        Board b = new Board("123405678");
        List<Ilayout> children = new ArrayList<Ilayout>();
        children.addAll(b.children());
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println((double)totalTime/1_000_000_000.0);
        System.out.println(children);
        assertTrue(new Board("123450678").equals(children.get(0)));
        assertTrue(new Board("123475608").equals(children.get(1)));
        assertTrue(new Board("123045678").equals(children.get(2)));
        assertTrue(new Board("103425678").equals(children.get(3)));
        
    }

    @Test (timeout = 10000)
    public void testSolve(){
        //aplicar 1 exemplo do prof
        /**
         * 023145678
         * 123405678
         */
        long startTime = System.nanoTime();
        Board b = new Board("023145678");
        State last;
        BestFirst bf = new BestFirst();
        Iterator<State> itr = bf.solve(b, new Board("123405678"));
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println((double)totalTime/1_000_000_000.0);
        assertEquals(" 23\r\n145\r\n678\r\n",itr.next().toString());
        assertEquals("123\r\n 45\r\n678\r\n",itr.next().toString());
        assertEquals("123\r\n4 5\r\n678\r\n",(last=itr.next()).toString());
        assertTrue((int)2==(int)last.getG());

    }

    @Test (timeout = 1000)
    public void testSolve2(){
        //aplicar 2 exemplo do prof
        /*
        123456780
        436718520
        */
        long startTime = System.nanoTime();
        Board b = new Board("123456780");
        State last;
        BestFirst bf = new BestFirst();
        Iterator<State> itr = bf.solve(b, new Board("436718520"));
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println((double)totalTime/1_000_000_000.0);

        assertEquals("123\r\n456\r\n78 \r\n",itr.next().toString());
        assertEquals("123\r\n456\r\n7 8\r\n",itr.next().toString());
        assertEquals("123\r\n4 6\r\n758\r\n",(itr.next()).toString());
        assertEquals("1 3\r\n426\r\n758\r\n",itr.next().toString());
        assertEquals(" 13\r\n426\r\n758\r\n",itr.next().toString());
        assertEquals("413\r\n 26\r\n758\r\n",(itr.next()).toString());
        assertEquals("413\r\n726\r\n 58\r\n",itr.next().toString());
        assertEquals("413\r\n726\r\n5 8\r\n",itr.next().toString());
        assertEquals("413\r\n7 6\r\n528\r\n",(itr.next()).toString());
        assertEquals("4 3\r\n716\r\n528\r\n",itr.next().toString());
        assertEquals("43 \r\n716\r\n528\r\n",itr.next().toString());
        assertEquals("436\r\n71 \r\n528\r\n",itr.next().toString());
        assertEquals("436\r\n718\r\n52 \r\n",(last=itr.next()).toString());
        assertTrue((int)12==(int)last.getG());
    }
    @Test(timeout = 10000)
    public void testTime(){
        long startTime = System.nanoTime();
        Board b = new Board("123780456");
        State last = null;
        BestFirst bf = new BestFirst();
        Iterator<State> itr = bf.solve(b, new Board("123450786"));
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println((double)totalTime/1_000_000_000.0);
        while(itr.hasNext()) last=itr.next();
        assertEquals((int)18,(int)last.getG());
    }
}






 












