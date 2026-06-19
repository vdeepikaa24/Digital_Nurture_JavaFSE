package engineeringConcepts.designPatternsAndPrinciples.FactoryMethodPatternExample;

public class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel Document... Initializing sheets and grid lines.");
    }

    @Override
    public void close() {
        System.out.println("Closing Excel Document... Calculating formulas.");
    }
}