package junit.Mockito_Exercises.Exercise_1_Mocking_And_Stubbing;

public class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api){
        this.api = api;
    }

    public String fetchData(){
        return api.getData();
    }
}
