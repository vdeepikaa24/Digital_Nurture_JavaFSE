package engineeringConcepts.designPatternsAndPrinciples.CommandPatternExample;

public class RemoteControl {
    private Command commandSlot;

    // Sets the command to be executed (like programming a smart remote button)
    public void setCommand(Command command) {
        this.commandSlot = command;
    }

    // Pressing the button executes the loaded command
    public void pressButton() {
        if (commandSlot == null) {
            System.out.println("No command assigned to this button!");
            return;
        }
        commandSlot.execute();
    }
}