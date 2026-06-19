package engineeringConcepts.designPatternsAndPrinciples.ProxyPatternExample;

public class RealImage implements Image{
    private String fileName;
    
    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer(){
        System.out.println("--> Connecting to remote server...");
        System.out.println("--> Downloading and loading image: " + fileName);
        try{
            //Simulating network delay 
            Thread.sleep(1500);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void display(){
        System.out.println("Rendering and displaying: " + fileName);
    }
}
