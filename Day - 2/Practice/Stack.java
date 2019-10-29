public class Stack{
    int top = -1; 
    char items[] = new char[100]; 

    public void push(char x){
        if(top == 99){
            System.out.println("Stack Full");
        }else{
            items[++top] = x ;
        }
    }

    public char pop(){
        if(top == -1){
            System.out.println("No Element");
            return '\0';
        }else{
            char element = items[top--];
            return element;
        }
    }

    public boolean isEmpty(){
        return (top == -1);
    }
}