package week11.lesson_05_12.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @Test
    public void checkLoginAndPasswordTest() {
        assertTrue(Task3.checkLoginAndPassword("john", "1234a", "1234a"));
        assertTrue(Task3.checkLoginAndPassword("johjqazwsxedcvfrtgbn", "1234a", "1234a"));
        assertTrue(Task3.checkLoginAndPassword("joh", "1234a", "1234a"));
        assertFalse(Task3.checkLoginAndPassword("john", "12345", "123456"));
        assertFalse(Task3.checkLoginAndPassword("john", "12345@", "12345@"));
        assertFalse(Task3.checkLoginAndPassword("john1", "12345", "12345"));

        assertFalse(Task3.checkLoginAndPassword(null, "1234a", "1234a"));
        assertFalse(Task3.checkLoginAndPassword("", "1234a", "1234a"));
        assertFalse(Task3.checkLoginAndPassword("jh", "1234a", "1234a"));
        assertFalse(Task3.checkLoginAndPassword("jqazwsxedcvfrtgbnhyujmh", "1234a", "1234a"));

        assertFalse(Task3.checkLoginAndPassword("john", null, "1234a"));
        assertFalse(Task3.checkLoginAndPassword("john", "", "1234a"));
        assertFalse(Task3.checkLoginAndPassword("john", "1234a", null));

        assertDoesNotThrow(() -> Task3.checkLoginAndPassword("john", "1234a", null));
    }

}