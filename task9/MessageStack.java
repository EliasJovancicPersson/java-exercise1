package task9;

import java.util.ArrayList;

public class MessageStack {

    ArrayList<Message> elements;

    public MessageStack() {
        elements = new ArrayList<Message>();
    }

    public void push(Message message) {
        this.elements.add(message);
    }

    public Message pop() {
        try {
            return this.elements.remove(this.elements.size() - 1);
        } catch (Exception e) {
            System.out.println("Stack is empty");
            return null;
        }
    }

    public void push(int n, Message[] messages) {
        for (int i = 0; i < n; i++) {
            this.push(messages[i]);
        }
    }

    public Message[] pop(int n) {
        Message[] messages = new Message[n];
        for (int i = 0; i < n; i++) {
            messages[i] = this.pop();
        }
        return messages;
    }

    public int size(){
        return this.elements.size();
    }
}
