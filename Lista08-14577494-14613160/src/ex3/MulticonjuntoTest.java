package ex3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MulticonjuntoTest {

    @Test
    public void testArrayList() {
    	System.out.println("testArrayList: ");
        Multiconjunto<String> m1 = new MulticonjuntoArrayList<>();
        Multiconjunto<String> m2 = new MulticonjuntoArrayList<>();
        m1.add("a");
        m1.add("b");
        m2.add("b");
        m2.add("c");
        m1.addAll(m2);
        
        System.out.println("Multiconjunto m1: " + m1);
        System.out.println("Multiconjunto m2: " + m2);

        assertEquals(4, m1.getSortedElements().size());
        assertTrue(m1.getSortedElements().contains("a"));
        assertTrue(m1.getSortedElements().contains("b"));
        assertTrue(m1.getSortedElements().contains("c"));

        Multiconjunto<String> m3 = new MulticonjuntoArrayList<>();
        m3.add("b");
        m3.add("a");
        m3.add("b");
        m3.add("c");

        System.out.println("Multiconjunto m3: " + m3);
        
        assertTrue(m1.equals(m3));

        Multiconjunto<String> m4 = new MulticonjuntoArrayList<>();
        m4.add("a");
        m4.add("b");
        m4.add("c");

        assertFalse(m1.equals(m4));
    }

    @Test
    public void testSet() {
    	System.out.println("testSet: ");
        Multiconjunto<String> m1 = new MulticonjuntoSet<>();
        Multiconjunto<String> m2 = new MulticonjuntoSet<>();
        m1.add("a");
        m1.add("b");
        m2.add("b");
        m2.add("c");
        m1.addAll(m2);
        
        System.out.println("Multiconjunto m1: " + m1);
        System.out.println("Multiconjunto m2: " + m2);

        assertEquals(4, m1.getSortedElements().size());
        assertTrue(m1.getSortedElements().contains("a"));
        assertTrue(m1.getSortedElements().contains("b"));
        assertTrue(m1.getSortedElements().contains("c"));

        Multiconjunto<String> m3 = new MulticonjuntoSet<>();
        m3.add("b");
        m3.add("a");
        m3.add("b");
        m3.add("c");

        System.out.println("Multiconjunto m3: " + m3);
        
        assertTrue(m1.equals(m3));

        Multiconjunto<String> m4 = new MulticonjuntoSet<>();
        m4.add("a");
        m4.add("b");
        m4.add("c");

        assertFalse(m1.equals(m4));
    }

    @Test
    public void testLinkedList() {
    	System.out.println("testLinkedList: ");
        Multiconjunto<String> m1 = new MulticonjuntoLinkedList<>();
        Multiconjunto<String> m2 = new MulticonjuntoLinkedList<>();
        m1.add("a");
        m1.add("b");
        m2.add("b");
        m2.add("c");
        m1.addAll(m2);
        
        System.out.println("Multiconjunto m1: " + m1);
        System.out.println("Multiconjunto m2: " + m2);

        assertEquals(4, m1.getSortedElements().size());
        assertTrue(m1.getSortedElements().contains("a"));
        assertTrue(m1.getSortedElements().contains("b"));
        assertTrue(m1.getSortedElements().contains("c"));

        Multiconjunto<String> m3 = new MulticonjuntoLinkedList<>();
        m3.add("b");
        m3.add("a");
        m3.add("b");
        m3.add("c");

        System.out.println("Multiconjunto m3: " + m3);
        
        assertTrue(m1.equals(m3));

        Multiconjunto<String> m4 = new MulticonjuntoLinkedList<>();
        m4.add("a");
        m4.add("b");
        m4.add("c");

        assertFalse(m1.equals(m4));
    }

    @Test
    public void testStack() {
    	System.out.println("testStack: ");
        Multiconjunto<String> m1 = new MulticonjuntoStack<>();
        Multiconjunto<String> m2 = new MulticonjuntoStack<>();
        m1.add("a");
        m1.add("b");
        m2.add("b");
        m2.add("c");
        m1.addAll(m2);
        
        System.out.println("Multiconjunto m1: " + m1);
        System.out.println("Multiconjunto m2: " + m2);

        assertEquals(4, m1.getSortedElements().size());
        assertTrue(m1.getSortedElements().contains("a"));
        assertTrue(m1.getSortedElements().contains("b"));
        assertTrue(m1.getSortedElements().contains("c"));

        Multiconjunto<String> m3 = new MulticonjuntoStack<>();
        m3.add("b");
        m3.add("a");
        m3.add("b");
        m3.add("c");

        System.out.println("Multiconjunto m3: " + m3);
        
        assertTrue(m1.equals(m3));

        Multiconjunto<String> m4 = new MulticonjuntoStack<>();
        m4.add("a");
        m4.add("b");
        m4.add("c");

        assertFalse(m1.equals(m4));
    }
    
    @Test
    public void testDifferentTypes() {
    	/**
    	 *  Foi considerado que um multiconjunto é igual a outro se tiver os mesmos elementos em mesma
    	 *  quantidade, mesmo se forem multiconjunto implementados com estruturas de dados diferentes.
    	 *  Isso é testado aqui.
    	 */

    	System.out.println("testStack2: ");
        Multiconjunto<String> m1 = new MulticonjuntoArrayList<>();
        Multiconjunto<String> m2 = new MulticonjuntoSet<>();
        Multiconjunto<String> m3 = new MulticonjuntoLinkedList<>();
        Multiconjunto<String> m4 = new MulticonjuntoStack<>();
        m1.add("heitor");
        m1.add("S2");
        m1.add("ana");
        m2.add("heitor");
        m2.add("S2");
        m2.add("ana");
        m3.add("heitor");
        m3.add("S2");
        m3.add("ana");
        m4.add("heitor");
        m4.add("S2");
        m4.add("ana");
        
        System.out.println("MulticonjuntoArraylist m1: " + m1);
        System.out.println("MulticonjuntoSet m2: " + m2);
        System.out.println("MulticonjuntoLinkedList m3: " + m3);
        System.out.println("MulticonjuntoStack m4: " + m4);

        assertTrue(m1.equals(m2));
        assertTrue(m2.equals(m3));
        assertTrue(m3.equals(m4));
        assertTrue(m4.equals(m1));
    }
}
