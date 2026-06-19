package engineeringConcepts.designPatternsAndPrinciples.FactoryMethodPatternExample;

public abstract class DocumentFactory {
    // This is the actual Factory Method
    public abstract Document createDocument();

    // Factories can also have built-in operational logic!
    public void processDocument() {
        Document doc = createDocument();
        doc.open();
        // Document operations happen here
        doc.close();
    }
}