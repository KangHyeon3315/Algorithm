package level03;

/**
 * 네트워크
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/43162
 */
public class Networks43162 {

    /*
    입출력 예
    n	computers	return
    3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
    3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1
     */
    public static void main(String[] args) {
        System.out.println(new Networks43162().solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(new Networks43162().solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] passed = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(dfs(n, passed, computers, i)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean dfs(int num, boolean[] passed, int[][] networks, int i) {
        if(passed[i]) return false;

        passed[i] = true;
        for(int j = 0; j < num; j++) {
            if(i == j) continue;

            if(networks[i][j] == 1) {
                dfs(num, passed, networks, j);
            }
        }


        return true;
    }
}
