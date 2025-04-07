package task8;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class MessageQueueTest {

    @Test
    public void testAddAndRemove() {
        MessageQueue queue = new MessageQueue(3);
        Message message1 = new Message("Message 1");
        Message message2 = new Message("Message 2");

        queue.add(message1);
        queue.add(message2);

        assertEquals(2, queue.size());
        assertEquals(message1, queue.removeFirst());
        assertEquals(message2, queue.removeFirst());
        assertEquals(0, queue.size());
    }

    @Test
    public void testGetFirst() {
        MessageQueue queue = new MessageQueue(2);
        Message message1 = new Message("Message 1");
        Message message2 = new Message("Message 2");

        queue.add(message1);
        queue.add(message2);

        assertEquals(message1, queue.getFirst());
        queue.removeFirst();
        assertEquals(message2, queue.getFirst());
    }

    @Test
    public void testCapacityExpansion() {
        MessageQueue queue = new MessageQueue(2);
        Message message1 = new Message("Message 1");
        Message message2 = new Message("Message 2");
        Message message3 = new Message("Message 3");

        queue.add(message1);
        queue.add(message2);
        queue.add(message3); // Should trigger capacity expansion

        assertEquals(3, queue.size());
        assertEquals(message1, queue.removeFirst());
        assertEquals(message2, queue.removeFirst());
        assertEquals(message3, queue.removeFirst());
    }

    @Test
    public void testCircularBehavior() {
        MessageQueue queue = new MessageQueue(3);
        Message message1 = new Message("Message 1");
        Message message2 = new Message("Message 2");
        Message message3 = new Message("Message 3");

        queue.add(message1);
        queue.add(message2);
        queue.removeFirst();
        queue.add(message3);

        assertEquals(2, queue.size());
        assertEquals(message2, queue.getFirst());
        queue.removeFirst();
        assertEquals(message3, queue.getFirst());
    }
}
