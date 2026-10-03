package eji;

public class Client {
    public static void main(String[] args) {
        MyInterface myObject = new MyClass();
        System.out.println(myObject.getInt());
    }
}
