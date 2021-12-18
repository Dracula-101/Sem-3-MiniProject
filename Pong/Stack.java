package Pong;

public class Stack {
    public int totalLen = 6;
    public int stack[] = new int[totalLen];
    public int pointer;

    public Stack() {
        pointer = 0;
        for (int i = 0; i < totalLen; i++)
            push(totalLen - i - 1);
    }

    public void push(int data) {
        if (pointer >= totalLen - 1 || pointer < 0)
            stack[totalLen - 1] = data;
        else {
            stack[pointer] = data;
            pointer++;
        }
    }

    public int pop() {

        if (!isEmpty()) {
            int temp = stack[pointer];
            stack[pointer] = 0;
            --pointer;
            return temp;
        } else if (pointer == 0) {

            return stack[pointer];
        } else
            return -1;
    }

    public boolean isEmpty() {
        if (pointer == 0)
            return true;
        else
            return false;
    }

    public void display() {
        for (int score : stack)
            System.out.print(score + " ");
    }

    public int peek() {
        return stack[pointer];
    }
}
