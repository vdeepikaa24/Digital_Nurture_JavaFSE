package engineeringConcepts.designPatternsAndPrinciples.BuilderPatternExample;

public class BuilderTest {
    public static void main(String[] args){
        System.out.println("=== Computer Assembly System (Builder Patter) ===\n");

        //1. Build a basic server/office computer (Only required fields)
        Computer officePC = new Computer.Builder("Intel i3", "8GB", "256GB SSD").build();

        System.out.println("--- Office PC ---");
        System.out.println(officePC);

        //2. Build a high-performance Gaming Computer using Method Chaining
        Computer gamingPC = new Computer.Builder("AMD Ryzen 9", "32GB", "2TB NVMe SSD")
        .setGraphicsCard(true)
        .setWiFi(true)
        .setBluetooth(true)
        .build();

        System.out.println("--- Gaming PC ---");
        System.out.println(gamingPC);

        //3. Build a custom Budget Setup with just Wi-Fi added
        Computer budgetPC = new Computer.Builder("Intel i5", "16GN", "512GB SSD").setWiFi(true).build();
        System.out.println("--- Budget Custom PC ---");
        System.out.println(budgetPC);
    }
}
