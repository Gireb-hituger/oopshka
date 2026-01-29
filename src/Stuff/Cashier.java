package Stuff;

public class Cashier implements Workers {
    @Override
    public void at_work(boolean a){
        if (a) {
            System.out.println("yes, at work");
        } else {
            System.out.println("no, absent");
        }
    }
}