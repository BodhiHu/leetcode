public class Solution2 {
  /*
   * [
   *  [ 10, 20, 5 ],
   *  [ 8,  20, 5 ],
   *  [ 10, 9,  5 ],
   * ]
   */
  public int minCost(int[][] costs) {
    int sum = 0;
    for (int i = 0; i < costs.length; i++) {
      int min = costs[i][0];
      for (int j = 1; j < costs[i].length; j++) {
        if (costs[i][j] > min) {
          min = costs[i][j];
        }
      }
      sum += min;
    }
    return sum;
  }

}
