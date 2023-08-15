package level02;

/**
 * 행렬의 곱셈
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12949
 */
public class MultipleMatrix12949 {

    /*
    입출력 예
    arr1	arr2	return
    [[1, 4], [3, 2], [4, 1]]	[[3, 3], [3, 3]]	[[15, 15], [15, 15], [15, 15]]
    [[2, 3, 2], [4, 2, 4], [3, 1, 4]]	[[5, 4, 3], [2, 4, 1], [3, 1, 1]]	[[22, 22, 11], [36, 28, 18], [29, 20, 14]]
     */
    public static void main(String[] args) {
        int[][] result = new MultipleMatrix12949().solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}});
        for(int[] row : result) {
            for(int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }

        result = new MultipleMatrix12949().solution(new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}, new int[][]{{5, 4, 3}, {2, 4, 1}, {3, 1, 1}});
        for(int[] row : result) {
            for(int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row1 = arr1.length;
        int col1 = arr1[0].length; // == row2
        int col2 = arr2[0].length;

        int[][] answer = new int[row1][col2];

        for(int i = 0; i < row1; i++) {
            for(int j = 0; j < col2; j++) {
                for(int k = 0; k < col1; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }



        return answer;
    }
}
