package engineeringConcepts.designPatternsAndPrinciples.FactoryMethodPatternExample;

public class FactoryMethodTest {
    public static void main(String[] args){
        System.out.println("=== Document Management System (Factory Method Pattern) ===\n");

        //1. Manage Word Documents using Word Factory
        DocumentFactory wordFactory = new WordDocumentFactory();
        System.out.println("--- Processing Word ---");
        wordFactory.processDocument();

        //2 Manage PDF Documetns using PDF Factory
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        System.out.println("\n--- Processing PDF ---");
        pdfFactory.processDocument();

        //3. Manage Excel Documents using Excel Factory
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        System.out.println("\n--- Processing Excel ---");
        excelFactory.processDocument();
    }
}
