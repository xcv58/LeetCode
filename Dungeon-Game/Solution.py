class Solution:
    # @param dungeon, a list of lists of integers
    # @return a integer
    def calculateMinimumHP(self, dungeon):
        for i in list(reversed(range(len(dungeon)))):
            for j in list(reversed(range(len(dungeon[i])))):
                rowEnd = i == len(dungeon) - 1
                columnEnd = j == len(dungeon[i]) - 1
                if not rowEnd and not columnEnd:
                    dungeon[i][j] -= min(dungeon[i + 1][j], dungeon[i][j + 1])
                elif rowEnd ^ columnEnd:
                    dungeon[i][j] -= dungeon[i + (0 if rowEnd else 1)][j + (0 if columnEnd else 1)];
                dungeon[i][j] = 0 if dungeon[i][j] > 0 else -dungeon[i][j]
        return dungeon[0][0] + 1
