package task9;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

public class MessageStackTest {
    Message testMessage = new Message("Hello1");
    Message testMessage1 = new Message("Hello2");
    Message testMessage2 = new Message("Hello3");


     @org.junit.Test
    public void testPush() {
        MessageStack stack = new MessageStack();
        stack.push(testMessage);
        stack.push(testMessage1);
        stack.push(testMessage2);
        assertEquals(testMessage2, stack.pop());
        assertEquals(testMessage1, stack.pop());
        assertEquals(testMessage, stack.pop());
    }

    @org.junit.Test
    public void testPushMany(){
        MessageStack stack = new MessageStack();
        Message[] input = new Message[]{testMessage,testMessage1,testMessage2};
        stack.push(3, input);
        Message[] Output = stack.pop(3);
        System.out.println(Arrays.toString(Output)); // Print the array contents
        assertArrayEquals(new Message[]{testMessage2,testMessage1,testMessage}, Output);
    }

    @org.junit.Test
    public void testSize(){
        MessageStack stack = new MessageStack();
        Message[] input = new Message[]{testMessage,testMessage1,testMessage2};
        stack.push(3, input);
        assertEquals(3,stack.size()); 
        Message[] Output = stack.pop(3);
        System.out.println(Arrays.toString(Output)); // Print the array contents
        assertArrayEquals(new Message[]{testMessage2,testMessage1,testMessage}, Output);
    }
}
