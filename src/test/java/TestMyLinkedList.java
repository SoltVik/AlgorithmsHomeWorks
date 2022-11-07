import LinkedList.MyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMyLinkedList {
    private MyLinkedList ls = new MyLinkedList();

    @BeforeEach
    public void init() {
        ls.pushToTail(1);
        ls.pushToTail(2);
        ls.pushToTail(3);
    }

    @Test
    public void testPushToHead() {
        Assertions.assertEquals(ls.size(), 3);
        Assertions.assertEquals(ls.get(0), 1);
        ls.pushToHead(5);
        Assertions.assertEquals(ls.size(), 4);
        Assertions.assertEquals(ls.get(0), 5);
    }

    @Test
    public void testPushToTail() {
        Assertions.assertEquals(ls.size(), 3);
        Assertions.assertEquals(ls.get(0), 1);
        ls.pushToTail(5);
        Assertions.assertEquals(ls.size(), 4);
        Assertions.assertEquals(ls.get(3), 5);
    }

    @Test
    public void testPushToIndex() {
        Assertions.assertEquals(ls.size(), 3);
        Assertions.assertEquals(ls.get(2), 3);
        ls.pushToIndex(2,5);
        Assertions.assertEquals(ls.size(), 4);
        Assertions.assertEquals(ls.get(2), 5);
    }

    @Test
    public void testRemoveFirst() {
        Assertions.assertEquals(ls.size(), 3);
        Assertions.assertEquals(ls.get(0), 1);
        ls.removeFirst();
        Assertions.assertEquals(ls.size(), 2);
        Assertions.assertEquals(ls.get(0), 2);
    }

    @Test
    public void testRemoveLast() {
        Assertions.assertEquals(ls.size(), 3);
        Assertions.assertEquals(ls.get(2), 3);
        ls.removeLast();
        Assertions.assertEquals(ls.size(), 2);
        Assertions.assertEquals(ls.get(1), 2);
    }

    @Test
    public void testRemove() {
        Assertions.assertEquals(ls.size(), 3);
        Assertions.assertEquals(ls.get(1), 2);
        ls.remove(1);
        Assertions.assertEquals(ls.size(), 2);
        Assertions.assertEquals(ls.get(1), 3);
    }
}
