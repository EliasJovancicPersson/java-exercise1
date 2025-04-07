package task7;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

public class StackTest {
    @org.junit.Test
    public void testPush() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @org.junit.Test
    public void testPushMany(){
        Stack stack = new Stack();
        int[] input = new int[]{0, 2, 4, 3, 4, 2, 3, 4, 2, 3};
        stack.push(10, input);
        int[] Output = stack.pop(10);
        System.out.println(Arrays.toString(Output)); // Print the array contents
        assertArrayEquals(new int[]{3, 2, 4, 3, 2, 4, 3, 4, 2, 0}, Output);
    }
}
