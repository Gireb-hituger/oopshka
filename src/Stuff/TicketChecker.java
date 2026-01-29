package Stuff;

public class TicketChecker implements Workers {
    @Override
    public void at_work(boolean a) {
        if (a) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}