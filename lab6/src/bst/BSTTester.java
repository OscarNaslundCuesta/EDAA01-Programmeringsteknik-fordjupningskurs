package bst;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Comparator;

public class BSTTester {
    
    private BinarySearchTree<Integer> tree;
    private BinarySearchTree<String> treeWithComp;

    @Before
    public void setUp() {
        tree = new BinarySearchTree<>();

        Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);
        treeWithComp = new BinarySearchTree<>(comparator);
    }

    @Test
    public void testEmpty() {
        assertEquals(0, tree.size());
        assertEquals(0, tree.height());
        
        assertEquals(0, treeWithComp.size());
        assertEquals(0, treeWithComp.height());
    }

    @Test
    public void testAddAndSize() {
        assertTrue(tree.add(5));
        assertEquals(1, tree.size());

        assertTrue(tree.add(3));
        assertEquals(2, tree.size());
        
        
        assertTrue(treeWithComp.add("A"));
        assertEquals(1, treeWithComp.size());

        assertTrue(treeWithComp.add("B"));
        assertEquals(2, treeWithComp.size());
    }

    @Test
    public void testRejectDuplicates() {
        assertTrue(tree.add(5));
        assertFalse(tree.add(5));
        
        assertTrue(treeWithComp.add("Dupe_string"));
        assertFalse(treeWithComp.add("Dupe_string"));
    }

    @Test
    public void testHeight() {
        tree.add(2);
        assertEquals(1, tree.height());
        
        tree.add(4);
        assertEquals(2, tree.height());
        
        tree.add(5);
        assertEquals(3, tree.height());
        
        tree.add(1);
        assertEquals(3, tree.height());
        
        tree.add(3);
        assertEquals(3, tree.height());
        
        tree.add(3);					//duplicate test
        assertEquals(3, tree.height());
        
        //String tree
        treeWithComp.add("A");
        assertEquals(1, treeWithComp.height());
        
        treeWithComp.add("A");			//duplicate test
        assertEquals(1, treeWithComp.height());
        
        treeWithComp.add("B");
        assertEquals(2, treeWithComp.height());
    }

    @Test
    public void testClear() {
        tree.add(5);
        tree.add(3);
        tree.clear();
        assertEquals(0, tree.size());
        assertEquals(0, tree.height()); 
        
        treeWithComp.add("A");
        treeWithComp.add("B");
        treeWithComp.clear();
        assertEquals(0, treeWithComp.size());
        assertEquals(0, treeWithComp.height()); 
    }
    

    @Test
    public void testCustomComparator() {
    	treeWithComp.add("ABC");
    	treeWithComp.add("ABC");
        assertEquals(1, treeWithComp.size());
    }

}
