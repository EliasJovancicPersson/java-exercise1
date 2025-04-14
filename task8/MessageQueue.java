package task8;

/**
    A first-in, first-out bounded collection of messages.
*/
public class MessageQueue
{
   /**
       Constructs an empty message queue.
       @param capacity the maximum initiall capacity of the queue
       @precondition capacity > 0;
   */
   public MessageQueue(int capacity)
   {
      if (capacity <= 0) {
        throw new IllegalArgumentException("Capacity must be greater than 0");
      }
      elements = new Message[capacity];
      count = 0;
      head = 0;
      tail = 0;
   }

   /**
       Remove message at head.
       @return the message that has been removed from the queue
       @precondition size() > 0;
   */
   public Message removeFirst()
   {
      if (size() == 0) {
        throw new IllegalStateException("Queue is empty");
      }
      Message r = elements[head];
      head = (head + 1) % elements.length;
      count--;
      return r;
   }

   /**
       Append a message at tail.
       @param aMessage the message to be appended
       @precondition size() < getCapacity(); preconditon should in theory be removed now that we expand the queue
   */
   public void add(Message aMessage)
   {
      if(this.size() == this.getCapacity()){
        MessageQueue newMQ = new MessageQueue(this.getCapacity()+1);
        for (int i = 0; i < this.size(); i++) {
            int index = (head + i) % elements.length;
            newMQ.add(this.elements[index]);
        }
        elements = newMQ.elements;
        head = newMQ.head;
        tail = newMQ.tail;
        count = newMQ.count;
      }
      elements[tail] = aMessage;
      tail = (tail + 1) % elements.length;
      count++;
   }

   /**
       Get the total number of messages in the queue.
       @return the total number of messages in the queue
   */
   public int size()
   {
      return count;
   }

   /**
       Get the maximum number of messages in the queue.
       @return the capacity of the queue
   */
   public int getCapacity()
   {
      return elements.length;
   }


   /**
       Get message at head.
       @return the message that is at the head of the queue
       @precondition size() > 0
   */
   public Message getFirst()
   {
     if (size() <= 0) {
        throw new IllegalStateException("Queue is empty");
      } 
      return elements[head];
   }

   private Message[] elements;
   private int head;
   private int tail;
   private int count;
}
