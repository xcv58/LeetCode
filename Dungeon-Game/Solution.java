public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        for (int i = dungeon.length - 1; i >= 0; i--) {
            for (int j = dungeon[i].length - 1; j >= 0; j--) {
                boolean rowEnd = i == dungeon.length - 1;
                boolean columnEnd = j == dungeon[i].length - 1;
                if (!rowEnd && !columnEnd) {
                    dungeon[i][j] -= Math.min(dungeon[i + 1][j], dungeon[i][j + 1]);
                } else if (rowEnd ^ columnEnd) {
                    dungeon[i][j] -= dungeon[i + (rowEnd ? 0 : 1)][j + (columnEnd ? 0 : 1)];
                }
                dungeon[i][j] = dungeon[i][j] > 0 ? 0 : -dungeon[i][j];
            }
        }
        return dungeon[0][0] + 1;
    }
}
