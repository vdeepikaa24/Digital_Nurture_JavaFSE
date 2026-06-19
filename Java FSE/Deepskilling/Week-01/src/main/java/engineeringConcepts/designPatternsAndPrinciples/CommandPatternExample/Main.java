// Main.java
package engineeringConcepts.designPatternsAndPrinciples.CommandPatternExample;

public class Main {
    public static void main(String[] args) {
        // 1. Create the Receiver (the actual device)
        Light livingRoomLight = new Light("Living Room");

        // 2. Create the Concrete Commands and pass them their Receiver
        Command turnLightOn = new LightOnCommand(livingRoomLight);
        Command turnLightOff = new LightOffCommand(livingRoomLight);

        // 3. Create the Invoker (the remote control)
        RemoteControl remote = new RemoteControl();

        System.out.println("=== Simulating Home Automation Smart Remote ===");

        // Load the ON command and press the button
        remote.setCommand(turnLightOn);
        remote.pressButton();

        System.out.println("\n--- Toggling Remote Button Configuration ---");

        // Load the OFF command and press the button
        remote.setCommand(turnLightOff);
        remote.pressButton();
    }
}