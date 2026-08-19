import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Map row number -> bitmask representing reserved seats (2 to 9)
        Map<Integer, Integer> rowMasks = new HashMap<>();
        
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            
            // We only care about seats 2 through 9
            if (col >= 2 && col <= 9) {
                int bitIndex = col - 2; // Map col 2..9 to bit indices 0..7
                rowMasks.put(row, rowMasks.getOrDefault(row, 0) | (1 << bitIndex));
            }
        }
        
        // Start with rows that have NO reservations (2 groups per row)
        int totalGroups = (n - rowMasks.size()) * 2;
        
        // Check occupied rows
        for (int mask : rowMasks.values()) {
            boolean leftAvailable   = (mask & 0b00001111) == 0; // seats 2, 3, 4, 5
            boolean middleAvailable = (mask & 0b00111100) == 0; // seats 4, 5, 6, 7
            boolean rightAvailable  = (mask & 0b11110000) == 0; // seats 6, 7, 8, 9
            
            if (leftAvailable && rightAvailable) {
                totalGroups += 2;
            } else if (leftAvailable || middleAvailable || rightAvailable) {
                totalGroups += 1;
            }
        }
        
        return totalGroups;
    }
}