package week12.lesson_12_12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class CustomDynamicArrayTest {
    CustomDynamicArray customDynamicArray;

    @BeforeEach
    void setUp() {
        customDynamicArray = new CustomDynamicArray();

    }

    @Test
    void add() {
        customDynamicArray.add(1);
        assertEquals(1, customDynamicArray.get(0));
        customDynamicArray.add(2);
        assertEquals(2, customDynamicArray.get(1));
        customDynamicArray.add(6);
        assertEquals(6, customDynamicArray.get(2));
        customDynamicArray.add(0);
        assertEquals(0, customDynamicArray.get(3));

    }

    @Test
    void addInArrayWithDefinedSize() {
        customDynamicArray = new CustomDynamicArray(5);
        customDynamicArray.add(1);
        customDynamicArray.add(2);
        customDynamicArray.add(6);
        customDynamicArray.add(4);
        customDynamicArray.add(5);
        customDynamicArray.add(8);
        assertEquals(8, customDynamicArray.get(5));

    }

    @Test
    void addAt() {
        customDynamicArray.add(1);
        customDynamicArray.add(2);
        customDynamicArray.add(3);
        customDynamicArray.add(4);
        customDynamicArray.add(5);
        customDynamicArray.add(6);
        assertThrows(RuntimeException.class, () -> customDynamicArray.addAt(6, 3));
        customDynamicArray.addAt(0, 7);
        assertEquals(7, customDynamicArray.get(0));
        assertEquals(1, customDynamicArray.get(1));
        customDynamicArray.addAt(6, 8);
        assertEquals(8, customDynamicArray.get(6));
        assertEquals(6, customDynamicArray.get(7));

        assertThrows(RuntimeException.class, () -> customDynamicArray.addAt(-1, 3));

    }

    @Test
    void addAtInArrayWithDefinedSize() {
        customDynamicArray = new CustomDynamicArray(5);
        customDynamicArray.add(1);
        customDynamicArray.add(2);
        customDynamicArray.add(6);
        customDynamicArray.add(4);
        customDynamicArray.add(5);
        customDynamicArray.addAt(4, 8);
        assertEquals(8, customDynamicArray.get(4));

    }

    @Test
    void shrinkSize() {
        customDynamicArray.add(1);
        customDynamicArray.add(2);
        customDynamicArray.add(6);
        customDynamicArray.remove();
        customDynamicArray.shrinkSize();
        assertEquals(2, customDynamicArray.get(1));
        assertThrows(RuntimeException.class, () -> customDynamicArray.get(2));
    }

    @Test
    void remove() {
//        assertThrows(ArrayIndexOutOfBoundsException.class, () -> customDynamicArray.remove());   // check count???
        customDynamicArray.add(1);
        customDynamicArray.add(2);
        customDynamicArray.remove();
        customDynamicArray.add(6);
        assertEquals(6, customDynamicArray.get(1));
    }

    @Test
    void removeAt() {
        assertThrows(RuntimeException.class, () -> customDynamicArray.removeAt(-6));
        assertThrows(RuntimeException.class, () -> customDynamicArray.removeAt(6));

        customDynamicArray.add(1);
        customDynamicArray.add(2);
        customDynamicArray.add(6);
        customDynamicArray.removeAt(0);
        assertEquals(2, customDynamicArray.get(0));
        assertEquals(6, customDynamicArray.get(1));
    }

    @Test
    void set() {
        assertThrows(RuntimeException.class, () -> customDynamicArray.set(-6, 4));
        assertThrows(RuntimeException.class, () -> customDynamicArray.set(0, 1));

        customDynamicArray.add(1);
        customDynamicArray.add(2);
        customDynamicArray.set(0, 6);
        assertEquals(6, customDynamicArray.get(0));
        assertThrows(RuntimeException.class, () -> customDynamicArray.set(2, 4));
        customDynamicArray.set(1, 5);
        assertEquals(5, customDynamicArray.get(1));
    }

    @Test
    void get() {
        assertThrows(RuntimeException.class, () -> customDynamicArray.get(-3));
        assertThrows(RuntimeException.class, () -> customDynamicArray.get(3));

        customDynamicArray.add(1);
        assertEquals(1, customDynamicArray.get(0));
        customDynamicArray.add(2);
        customDynamicArray.add(6);
        assertEquals(2, customDynamicArray.get(1));
        assertEquals(6, customDynamicArray.get(2));
    }

    @Test
    void clear() {
        customDynamicArray.add(1);
        customDynamicArray.add(2);
        customDynamicArray.add(6);
        assertFalse(customDynamicArray.isEmpty());
        customDynamicArray.clear();
        assertTrue(customDynamicArray.isEmpty());
    }

    @Test
    void contains() {
        customDynamicArray.add(1);
        customDynamicArray.add(2);
        customDynamicArray.add(6);
        assertEquals(1, customDynamicArray.contains(2));
        assertEquals(-1, customDynamicArray.contains(8));
        customDynamicArray.add(-1);
        assertEquals(3, customDynamicArray.contains(-1));
    }

    @Test
    void isEmpty() {
        assertTrue(customDynamicArray.isEmpty());
        customDynamicArray.add(1);
        assertFalse(customDynamicArray.isEmpty());
    }

    @Test
    void iterator() {
        customDynamicArray.add(1);
        customDynamicArray.add(2);
        customDynamicArray.add(6);
        Iterator<Integer> iterator = customDynamicArray.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(6, iterator.next());
        assertFalse(iterator.hasNext());
        assertThrows(RuntimeException.class, () -> iterator.next());
    }
}