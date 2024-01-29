import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    // Найминг!!!!

    private Stack<String> stack;

    @BeforeEach
    void setStack() {
        stack = new Stack<>();
    }


    @Test
    void testPush_ShouldAddElement_WhenEmptyStack() {
        stack.push("Alpha");
        stack.push("Beta");
        stack.push("Gamma");
        stack.push("Delta");

        assertEquals(4, stack.size());

        stack.pop();
        stack.pop();

        assertEquals(2, stack.size());
    }

    @Test
    void testPop_ShouldRemoveElement_WhenStackIsNull() {
        assertNull(stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    void testPeek_ShouldPeekElement_WhenStackHasElements() {
        stack.push("Alpha");
        stack.push("Beta");
        stack.push("Gamma");
        stack.push("Delta");

        assertEquals(4, stack.size());

        stack.peek();

        assertEquals(4, stack.size());
    }

    @Test
    void testPush_ShouldThrowEx_WhenArgsNull() {
        assertThrows(IllegalArgumentException.class,() -> stack.push(null));
    }

    @Test
    void testPush_ShouldThrowExTextMessage_WhenArgsNull() {
        try {
            stack.push(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Element can not be Null", e.getMessage());
        }
    }
}