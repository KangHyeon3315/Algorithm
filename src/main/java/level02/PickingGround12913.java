package level02;

/**
 * 땅따먹기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12913
 */
public class PickingGround12913 {

    /*
    입출력 예
    land	answer
    [[1,2,3,5],[5,6,7,8],[4,3,2,1]]	16
     */
    public static void main(String[] args) {
        System.out.println(new PickingGround12913().solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}}));
    }

    int solution(int[][] land) {

        int[][] d = new int[land.length][land[0].length];
        for (int i = 0; i < land[0].length; i++) {
            d[0][i] = land[0][i];
        }

        for(int i = 1 ; i < land.length; i++) {
            for(int j = 0; j < 4; j++) {
                for(int k = 0; k < 4; k++) {
                    if(k == j) continue;

                    // 이전 Max([i - 1][k]까지의 최대 + [i][j])
                    d[i][j] = Math.max(d[i][j], d[i - 1][k] + land[i][j]);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < land[0].length; i++) {
            answer = Math.max(answer, d[land.length - 1][i]);
        }

        return answer;
    }
}
