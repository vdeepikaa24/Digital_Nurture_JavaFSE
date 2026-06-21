package junit.JUnit_Spring_Test_Exercises.Exercise_1_Basic_Unit_Test_For_A_Service_Method;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int add(int a, int b) {
        return a + b;
    }
}
