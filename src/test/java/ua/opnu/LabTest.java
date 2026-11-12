package ua.opnu;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LabTest {

    @Test
    void optionalEmpty() {
        MyOptional<String> o = new MyOptional<>();
        assertTrue(o.isEmpty());
        assertFalse(o.isPresent());
        assertEquals("guest", o.orElse("guest"));
        assertEquals("MyOptional[empty]", o.toString());
        assertThrows(IllegalStateException.class, o::get);
    }

    @Test
    void optionalWithValue() {
        MyOptional<String> o = new MyOptional<>("admin");
        assertTrue(o.isPresent());
        assertEquals("admin", o.get());
        assertEquals("MyOptional[value=admin]", o.toString());
        assertThrows(IllegalArgumentException.class, () -> new MyOptional<String>(null));
    }

    @Test
    void bookOrdering() {
        BookData high = new BookData("B", "x", 2, 10);
        BookData low = new BookData("A", "x", 2, 6);
        assertTrue(high.compareTo(low) < 0);
        assertTrue(low.compareTo(high) > 0);
    }

    @Test
    void filterAndContains() {
        GenericUtils u = new GenericUtils();
        assertArrayEquals(new Integer[] {2, 4}, u.filter(new Integer[] {1, 2, 3, 4}, n -> n % 2 == 0));
        assertTrue(u.contains(new String[] {"a", "b"}, "b"));
        assertFalse(u.contains(new String[] {"a", "b"}, "c"));
    }

    @Test
    void tuples() {
        assertEquals("(a,1,2.5)", new GenericThreeTuple<>("a", 1, 2.5).toString());
        assertEquals("(a,1)", new GenericTwoTuple<>("a", 1).toString());
    }
}
