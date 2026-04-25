import java.util.ArrayList;
import java.util.List;

public class pascal_Triangle_2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long val = 1; 
        row.add((int) val);
        
        for (int i = 1; i <= rowIndex; i++) {
            val = val * (rowIndex - i + 1) / i;
            row.add((int) val);
        }
         
        return row;
    }
    
}
