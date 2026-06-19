package engineeringConcepts.designPatternsAndPrinciples.ProxyPatternExample;

public class ProxyImage implements Image{
    private RealImage realImage;
    private String fileName;
    
    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display(){
        if(realImage == null){
            System.out.println("[Proxy] Image not in cache. Fetching from server...");
            realImage = new RealImage(fileName);
        } else {
            System.out.println("[Proxy] Image found in cache! Skipping network call.");
        }

        //Delegate the actual presentation to the real object
        realImage.display();
    }
}
