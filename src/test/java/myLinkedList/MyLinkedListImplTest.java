package myLinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyLinkedListImplTest {
    MyLinkedList<String> myLinkedList;
    @Before
    public void setUp() throws Exception {
        myLinkedList = new MyLinkedListImpl<>();
        myLinkedList.add("11111");
        myLinkedList.add("22222");
        myLinkedList.add("33333");
        myLinkedList.add("44444");
    }

    @After
    public void tearDown() throws Exception {
        myLinkedList = null;
    }

    @Test
    public void reverse() throws Exception {
        assertNotEquals(myLinkedList.getFirstElement().getElement(),myLinkedList.get(4));
    }

    @Test
    public void add() {
        assertTrue(myLinkedList.add("55555"));
        assertEquals(5, myLinkedList.getSize());
    }

    @Test
    public void delElemByIndex() {
        assertTrue(myLinkedList.delElemByIndex(1));
        assertEquals(3, myLinkedList.getSize());
    }
    @Test
    public void get() throws Exception {
        assertEquals("22222",myLinkedList.get(2));
        assertEquals("11111",myLinkedList.get(1));
        assertEquals("44444",myLinkedList.get(4));
    }
}