package task7;
import java.util.ArrayList;
public class Stack {

    ArrayList<Integer> elements ;

    public Stack(){
        elements = new ArrayList<Integer>();
    }
    
    public void push(int val){
        this.elements.addLast(val);
    }

    public int pop(){
        try {
            return this.elements.removeLast();
        } catch (Exception e) {
            System.out.println("Stack is empty");
            return -1;
        }
        
    }

    public void push(int n,int[] arr){
        for(int i = 0;i<n;i++){
            this.push(arr[i]);
        }
    }

    public int[] pop(int n){
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = this.pop();
        }
        return arr;
    }
}
