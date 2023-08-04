package level01;

/**
 * 행렬의 덧셈
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12950
 */
public class MatrixSum12950 {

    /*
    입출력 예
    arr1	arr2	return
    [[1,2],[2,3]]	[[3,4],[5,6]]	[[4,6],[7,9]]
    [[1],[2]]	[[3],[4]]	[[4],[6]]
     */
    public static void main(String[] args) {
        int[][] arr1 = {{1,2},{2,3}};
        int[][] arr2 = {{3,4},{5,6}};

        int[][] result = solution(arr1, arr2);
        for(int[] i : result) {
            for(int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        arr1 = new int[][]{{1},{2}};
        arr2 = new int[][]{{3},{4}};
        result = solution(arr1, arr2);
        for(int[] i : result) {
            for(int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];

        for(int i = 0 ; i < arr1.length; i++) {
            for(int j = 0; j < arr1[i].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
}
