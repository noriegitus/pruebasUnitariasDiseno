public class Calculation {
    
    public static int findMax(int arr[]) {
        // Inicializar max con el primer elemento del arreglo
        int max = arr[0]; 
        
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
}