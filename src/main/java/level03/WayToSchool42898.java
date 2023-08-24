package level03;

/**
 * 등굣길
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42898
 */
public class WayToSchool42898 {
    /*
    입출력 예
    m	n	puddles	return
    4	3	[[2, 2]]	4
     */
    public static void main(String[] args) {
        WayToSchool42898 wayToSchool = new WayToSchool42898();
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};
        System.out.println(wayToSchool.solution(m, n, puddles));
    }

    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        map[0][0] = 1;
        for(int[] puddle : puddles) {
            if(puddle.length == 2) {
                map[puddle[1] - 1][puddle[0] - 1] = -1;
            }
        }

        for(int x = 0; x < n; x++) {
            for(int y = 0; y < m; y++) {
                if((x == 0 && y == 0) || map[x][y] == -1) continue;
                int up = y > 0 && map[x][y - 1] != -1 ? map[x][y - 1] : 0;
                int left = x > 0 && map[x - 1][y] != -1 ? map[x - 1][y] : 0;

                map[x][y] = (up + left) % 1_000_000_007;
            }
        }

        return map[n - 1][m - 1];
    }
}
