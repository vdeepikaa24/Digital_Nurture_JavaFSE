package junit.Mockito_Exercises.Exercise_1_Mocking_And_Stubbing;

public interface ExternalApi {
    String getData();
    String getData(String input);
    void logAction(String message);
    void authenticate();
    void fetchData();
}
