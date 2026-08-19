
import static org.junit.Assert.assertEquals;
import org.junit.Assume;
import org.junit.Test;
import java.time.LocalDate;

public class EmployeeTest {

    @Test
    public void testCalculateYearBonusWorker() {
        Employee emp = new Employee(500.0f, "USD", 0.0f, EmployeeType.Worker);
        
        assertEquals(386.0f, emp.CalculateYearBonus(), 0.001);
    }

    @Test
    public void testCalculateYearBonusManagerNonUSD() {
        Employee emp = new Employee(1000.0f, "EUR", 10.0f, EmployeeType.Manager);
        assertEquals(1336.0f, emp.CalculateYearBonus(), 0.001);
    }

    @Test
    public void testCsSupervisorEvenMonth() {
        int currentMonth = LocalDate.now().getMonthValue();
        Assume.assumeTrue("La prueba solo corre en meses pares", currentMonth % 2 == 0);
        Employee emp = new Employee(1000.0f, "USD", 100.0f, EmployeeType.Supervisor);
        assertEquals(1035.0f, emp.cs(), 0.001);
    }

    @Test
    public void testCsSupervisorOddMonth() {
        int currentMonth = LocalDate.now().getMonthValue();
        
        Assume.assumeTrue("La prueba solo corre en meses impares", currentMonth % 2 != 0);
        
        Employee emp = new Employee(1000.0f, "USD", 100.0f, EmployeeType.
        float expected = 1035.0f + (386.0f / 12 * 2);
        assertEquals(expected, emp.cs(), 0.001);
    }

    @Test
    public void testCalculateYearBonusSupervisor() {
        Employee emp = new Employee(1000.0f, "USD", 50.0f, EmployeeType.Supervisor);
        
        assertEquals(1193.0f, emp.CalculateYearBonus(), 0.001);
    }

    @Test
    public void testCsManagerNonUSD() {
        int currentMonth = LocalDate.now().getMonthValue();
        Employee emp = new Employee(2000.0f, "EUR", 500.0f, EmployeeType.Manager);
        
        float salario = 2000.0f * 0.95f;
        float valueM = salario + (500.0f * 0.7f);
        float expected;
        
        if (currentMonth % 2 == 0) {
            expected = valueM; 
        } else {
            expected = valueM + (386.0f / 12.0f * 2.0f); 
        }
        
        assertEquals(expected, emp.cs(), 0.001);
    }
}
