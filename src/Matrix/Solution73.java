package Matrix;

/**
 * 73. 矩阵置零
 * @Author Hao Chen
 * @Create 2022/7/28 18:48
 */
public class Solution73 {
    /**
     * O(m+n)空间复杂度
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(row[i] || col[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
    /**
     * O(1)空间复杂度
     */
//    public void setZeroes(int[][] matrix) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//        boolean flagRow0 = false;
//        boolean flagCol0 = false;
//        for(int i = 0; i < m; ++i){
//            if(matrix[i][0] == 0){
//                flagCol0 = true;
//            }
//        }
//        for(int i = 0; i < n; ++i){
//            if(matrix[0][i] == 0){
//                flagRow0 = true;
//            }
//        }
        //已经判断完第0行和第0列了，所以要从第1行和第1列遍历
//        for(int i = 1; i < m; ++i){
//            for(int j = 1; j < n; ++j){
//                if(matrix[i][j] == 0){
//                    matrix[i][0] = 0;
//                    matrix[0][j] = 0;
//                }
//            }
//        }
       //同上，已经判断完第0行和第0列了，所以要从第1行和第1列遍历
//        for(int i = 1; i < m; ++i){
//            for(int j = 1; j < n;++j){
//                if(matrix[i][0] == 0 || matrix[0][j] == 0){
//                    matrix[i][j] = 0;
//                }
//            }
//        }
       //单独处理第0行
//        if(flagRow0){
//            for(int i = 0; i < n; ++i){
//                matrix[0][i] = 0;
//            }
//        }
      //单独处理第0列
//        if(flagCol0){
//            for(int i = 0; i < m; ++i){
//                matrix[i][0] = 0;
//            }
//        }
//    }
}
