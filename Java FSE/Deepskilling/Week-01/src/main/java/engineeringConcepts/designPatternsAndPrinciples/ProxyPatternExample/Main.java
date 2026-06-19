package engineeringConcepts.designPatternsAndPrinciples.ProxyPatternExample;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 1. Instantiating Proxy Images ===");
        // Creating the objects is instant; no network calls are made yet!
        Image highResPhoto = new ProxyImage("ultra_hd_space_photo.jpg");
        System.out.println("Proxy objects created successfully.\n");

        System.out.println("=== 2. Displaying Image for the FIRST time ===");
        // This will trigger the proxy to download and cache the image.
        highResPhoto.display();
        System.out.println();

        System.out.println("=== 3. Displaying Image for the SECOND time ===");
        // This will fetch instantly from the proxy's local reference cache.
        highResPhoto.display();
    }
}