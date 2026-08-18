import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestCalculation {

    @Test
    public void testFindMax() {
        
        // 1. Arreglo con positivos y negativos
        assertEquals(4, Calculation.findMax(new int[]{1, -3, 4, -2}));
        
        // 2. Arreglo solo con negativos
        assertEquals(-1, Calculation.findMax(new int[]{-12, -1, -3, -4, -2}));
        
        // 3. arreglo mixto y cero
        assertEquals(15, Calculation.findMax(new int[]{-5, 0, 15, -20, 7}));
    }
}