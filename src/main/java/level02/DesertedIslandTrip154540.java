package level02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 무인도 여행
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/154540
 */
public class DesertedIslandTrip154540 {

    /*
    입출력 예
    maps	result
    ["X591X","X1X5X","X231X", "1XXX1"]	[1, 1, 27]
    ["XXX","XXX","XXX"]	[-1]
     */
    public static void main(String[] args) {
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        System.out.println(Arrays.toString(new DesertedIslandTrip154540().solution(maps)));

        maps = new String[]{"XXX","XXX","XXX"};
        System.out.println(Arrays.toString(new DesertedIslandTrip154540().solution(maps)));
    }

    public int[] solution(String[] maps) {
        boolean[][] checked = new boolean[maps.length][maps[0].length()];

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[i].length(); j++) {
                if(maps[i].charAt(j) == 'X' || checked[i][j]) continue;

                result.add(dfs(maps, checked, i, j));
            }
        }

        int[] answer = result.stream().sorted().mapToInt(i -> i).toArray();
        if(answer.length == 0) return new int[]{-1};
        return answer;
    }

    private int dfs(String[] maps, boolean[][] checked, int y, int x) {
        if(checked[y][x]) return 0;
        checked[y][x] = true;

        int answer = maps[y].charAt(x) - '0';
        if(x - 1 >= 0 && maps[y].charAt(x - 1) != 'X') {
            answer += dfs(maps, checked, y, x - 1);
        }
        if(x + 1 < maps[y].length() && maps[y].charAt(x + 1) != 'X') {
            answer += dfs(maps, checked, y, x + 1);
        }
        if(y - 1 >= 0 && maps[y - 1].charAt(x) != 'X') {
            answer += dfs(maps, checked, y - 1, x);
        }
        if(y + 1 < maps.length && maps[y + 1].charAt(x) != 'X') {
            answer += dfs(maps, checked, y + 1, x);
        }

        return answer;
    }
}
