package _demo.st;

public class Service {
    public void start() {
        System.out.println("Service gestartet.");
        Logic logic = new Logic();
        logic.process();
    }
}