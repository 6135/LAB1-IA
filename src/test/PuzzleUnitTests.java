
package test;

import org.junit.Test;
import app.*;
import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.ArrayList;

public class PuzzleUnitTests {
    private static final String List = null;

    @Test
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
    @Test
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

    @Test
    public void testChildren(){
        Board b = new Board("123405678");
        List<Ilayout> children = new ArrayList<Ilayout>();
        children.addAll(b.children());
        List<String> childrenString = new ArrayList<String>();
        for(Ilayout l : children)
            childrenString.add(l.toStringLong());
        assertTrue(childrenString.contains("103425678"));
        assertTrue(childrenString.contains("123045678"));
        assertTrue(childrenString.contains("123450678"));
        assertTrue(childrenString.contains("123475608"));   
        
    }
}
