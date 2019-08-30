/**
 * Created by tinab on 17-Mar-17.
 */
public class ThreadDemo extends Thread {

    public static void main(String[] args){
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();
    }

    public void run(){
        System.out.println("Thread is running");
    }

    //Hvorfor er det en dårlig løsning ? - Fordi den extender Thread, og kan ikke extende andre.
}
