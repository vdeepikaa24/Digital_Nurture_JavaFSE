package engineeringConcepts.designPatternsAndPrinciples.FactoryMethodPatternExample;

public class WordDocument implements Document{
    @Override
    public void open(){
        System.out.println("Opening Word Document... Loading margins and layout.");
    }
    @Override
    public void close(){
        System.out.println("Closing Word Document... Saving cahnges.");
    }
} 
