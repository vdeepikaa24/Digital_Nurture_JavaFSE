package junit.JUnit_Spring_Test_Exercises.Exercise_1_Basic_Unit_Test_For_A_Service_Method;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class CalculatorServiceTest {
    private final CalculatorService service = new CalculatorService();

    @Test
    public void testAdd() {
        assertEquals(15, service.add(5, 10));
    }
}
