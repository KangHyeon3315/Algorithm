package level03;

/**
 * 정수 삼각형
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/43105
 */
public class IntegerTriangle43105 {

    /*
    입출력 예
    triangle	result
    [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]	30
     */
    public static void main(String[] args) {
        int result = new IntegerTriangle43105().solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
        System.out.println(result);
    }

    public int solution(int[][] triangle) {

        for(int layer = triangle.length - 2; layer >= 0; layer--) {
            int[] l = triangle[layer];
            int[] prevL = triangle[layer + 1];
            for(int i = 0; i < l.length; i++) {
                int left = i;
                int right = i + 1;

                l[i] = Math.max(l[i] + prevL[left], l[i] + prevL[right]);
            }
        }

        return triangle[0][0];
    }
}
