package oving0;

public class HelloWorld {

    public String getHelloWorld() {
        return "Hello World!";
    }

    public int getHelloWorldLength() {
        return this.getHelloWorld().length();
    }

    public static void main(String[] args) {
        System.out.println(new HelloWorld().getHelloWorld());
    }
}
