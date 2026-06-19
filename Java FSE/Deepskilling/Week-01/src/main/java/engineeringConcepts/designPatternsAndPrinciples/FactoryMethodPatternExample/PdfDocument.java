package engineeringConcepts.designPatternsAndPrinciples.FactoryMethodPatternExample;

public class PdfDocument implements Document{
    @Override
    public void open(){
        System.out.println("Opening PDF Document... Rendering vector graphics and text layers.");
    }

    @Override
    public void close(){
        System.out.println("Closing PDF Document.");
    }
} 
