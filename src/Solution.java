import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {
    public static boolean isValidSudoku(char[][] board) {
        //Solution using HashMap
        //faster than 8.83% of Java online submissions
        Map<String, Integer> map = new HashMap();
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (board[x][y] != '.') {
                    char current = board[x][y];
                    if (map.containsKey(current + " in line " + x)) {
                        return false;
                    } else map.putIfAbsent(current + " in line " + x, 0);
                    if (map.containsKey(current + " in column " + y)) {
                        return false;
                    } else map.putIfAbsent(current + " in column " + y, 0);
                    if (map.containsKey(current + " in box " + x / 3 + " " + y / 3)) {
                        return false;
                    } else map.putIfAbsent(current + " in box " + x / 3 + " " + y / 3, 0);
                }
            }
        }
        return true;
    }

    public static boolean isValidSudokuFast(char[][] board) {
        //Solution using HashSet
        //faster than 29.28% of Java online submissions
        HashSet<String> valuesPos = new HashSet<>();
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (board[x][y] != '.') {
                    char current = board[x][y];
                    if (!valuesPos.add(current + " in line " + x) ||
                            !valuesPos.add(current + " in column " + y) ||
                            !valuesPos.add(current + " in box " + x / 3 + " " + y / 3)
                    ) return false;
                }
            }
        }
        return true;
    }
}
