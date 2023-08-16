package level02;

/**
 * 피로도
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/87946
 */
public class Fatigue87946 {

    /*
    입출력 예
    k	dungeons	result
    80	[[80,20],[50,40],[30,10]]	3
     */
    public static void main(String[] args) {
        System.out.println(new Fatigue87946().solution(80, new int[][]{{80,20},{50,40},{30,10}}));
    }

    public int solution(int k, int[][] dungeons) {
        boolean[] passed = new boolean[dungeons.length];

        return dfs(k, dungeons, passed);
    }

    private int dfs(int k, int[][] dungeons, boolean[] passed) {
        int maxNum = 0;
        boolean pass = false;
        for(int i = 0; i < dungeons.length; i++) {
            // 이미 던전을 돌았거나 최소 필요 피로도보다 피로도가 부족한 경우
            if(passed[i] || dungeons[i][0] > k) continue;

            passed[i] = true;
            pass = true;

            int num = dfs(k - dungeons[i][1], dungeons, passed);
            maxNum = Math.max(num, maxNum);

            passed[i] = false;
        }
        return pass ? maxNum + 1 : 0; // 자기 자신까지 합

    }
}
