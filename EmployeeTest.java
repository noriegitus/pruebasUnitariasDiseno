
import static org.junit.Assert.assertEquals;
import org.junit.Assume;
import org.junit.Test;
import java.time.LocalDate;

public class EmployeeTest {

    // ---------------------------------------------------------
    // ESCENARIO 1: Bono Anual de un Worker
    // ---------------------------------------------------------
    @Test
    public void testCalculateYearBonusWorker() {
        // Un Worker con 500 de salario en USD
        Employee emp = new Employee(500.0f, "USD", 0.0f, EmployeeType.Worker);
        
        // El código establece que el Worker solo recibe el RMU (386.0) como bono
        assertEquals(386.0f, emp.CalculateYearBonus(), 0.001);
    }

    // ---------------------------------------------------------
    // ESCENARIO 2: Bono Anual de un Manager en Moneda Extranjera
    // ---------------------------------------------------------
    @Test
    public void testCalculateYearBonusManagerNonUSD() {
        // Un Manager con 1000 de salario en EUR (Moneda distinta a USD)
        Employee emp = new Employee(1000.0f, "EUR", 10.0f, EmployeeType.Manager);
        
        // 1. Salario con 5% de descuento por no ser USD 
        assertEquals(1336.0f, emp.CalculateYearBonus(), 0.001);
    }

    // ---------------------------------------------------------
    // ESCENARIO 3: Salario Supervisor en mes PAR usando Assumptions
    // ---------------------------------------------------------
    @Test
    public void testCsSupervisorEvenMonth() {
        int currentMonth = LocalDate.now().getMonthValue();
        
        // ASSUMPTION: Esta prueba solo tiene validez y se ejecuta si estamos en un mes PAR.
        Assume.assumeTrue("La prueba solo corre en meses pares", currentMonth % 2 == 0);
        
        Employee emp = new Employee(1000.0f, "USD", 100.0f, EmployeeType.Supervisor);
        
        // Lógica mes par (sin décimo extra): salario + (bonusPercentage * 0.35)
        // 1000 + (100 * 0.35) = 1035.0
        assertEquals(1035.0f, emp.cs(), 0.001);
    }

    // ---------------------------------------------------------
    // ESCENARIO 4: Salario Supervisor en mes IMPAR usando Assumptions
    // ---------------------------------------------------------
    @Test
    public void testCsSupervisorOddMonth() {
        int currentMonth = LocalDate.now().getMonthValue();
        
        // ASSUMPTION: Esta prueba solo tiene validez y se ejecuta si estamos en un mes IMPAR.
        Assume.assumeTrue("La prueba solo corre en meses impares", currentMonth % 2 != 0);
        
        Employee emp = new Employee(1000.0f, "USD", 100.0f, EmployeeType.Supervisor);
        
        // Lógica mes impar: salario + (bonusPercentage * 0.35) + (rmu / 12 * 2)
        // Base = 1035.0. Décimo = (386.0 / 12 * 2) = 64.33333...
        float expected = 1035.0f + (386.0f / 12 * 2);
        assertEquals(expected, emp.cs(), 0.001);
    }
}