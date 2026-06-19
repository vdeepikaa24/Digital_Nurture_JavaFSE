package engineeringConcepts.designPatternsAndPrinciples.BuilderPatternExample;

public class Computer {
    // Required Attributes
    private final String CPU;
    private final String RAM;
    private final String storage;
    
    // Optional Attributes
    private final boolean hasGraphicsCard;
    private final boolean hasBluetooth;
    private final boolean hasWiFi;

    // Private constructor
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.hasGraphicsCard = builder.hasGraphicsCard;
        this.hasBluetooth = builder.hasBluetooth;
        this.hasWiFi = builder.hasWiFi;
    }

    // Getters
    public String getCPU() { return CPU; }
    public String getRAM() { return RAM; }
    public String getStorage() { return storage; }
    public boolean isHasGraphicsCard() { return hasGraphicsCard; }
    public boolean isHasBluetooth() { return hasBluetooth; }
    public boolean isHasWiFi() { return hasWiFi; }

    @Override
    public String toString() {
        return "Computer Configuration:\n" +
               " - CPU: " + CPU + "\n" +
               " - RAM: " + RAM + "\n" +
               " - Storage: " + storage + "\n" +
               " - Graphics Card: " + (hasGraphicsCard ? "Enabled" : "None") + "\n" +
               " - Bluetooth: " + (hasBluetooth ? "Enabled" : "None") + "\n" +
               " - Wi-Fi: " + (hasWiFi ? "Enabled" : "None") + "\n";
    }

    // Static Nested Builder Class
    public static class Builder {
        private final String CPU;
        private final String RAM;
        private final String storage;
        
        private boolean hasGraphicsCard = false;
        private boolean hasBluetooth = false;
        private boolean hasWiFi = false;

        // Constructor for required fields
        public Builder(String CPU, String RAM, String storage) {
            this.CPU = CPU;
            this.RAM = RAM;
            this.storage = storage;
        }

        // Fluent methods for optional fields
        public Builder setGraphicsCard(boolean hasGraphicsCard) {
            this.hasGraphicsCard = hasGraphicsCard;
            return this;
        }

        public Builder setBluetooth(boolean hasBluetooth) {
            this.hasBluetooth = hasBluetooth;
            return this;
        }

        public Builder setWiFi(boolean hasWiFi) {
            this.hasWiFi = hasWiFi;
            return this;
        }

        // Build method
        public Computer build() {
            return new Computer(this);
        }
    }
}