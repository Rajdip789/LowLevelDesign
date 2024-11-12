package DesignPatterns.StatePattern.PhoneState;

public class Main {
    public static void main(String[] args) {
        Phone phone = new Phone();

        System.out.println(phone.state.onHome());
        System.out.println(phone.state.onHome());
        System.out.println(phone.state.onPower());
    }
}
