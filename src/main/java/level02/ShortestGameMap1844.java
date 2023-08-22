package level02;

import java.util.ArrayList;
import java.util.List;

/**
 * 게임 맵 최단거리
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
 */
public class ShortestGameMap1844 {

    /*
    입출력 예
    maps	answer
    [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]	11
    [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]	-1
     */
    public static void main(String[] args) {
        ShortestGameMap1844 shortestGameMap = new ShortestGameMap1844();
        int[][] maps = {
            {1,0,1,1,1},
            {1,0,1,0,1},
            {1,0,1,1,1},
            {1,1,1,0,1},
            {0,0,0,0,1}
        };
        System.out.println(shortestGameMap.solution(maps));

        maps = new int[][] {
            {1,0,1,1,1},
            {1,0,1,0,1},
            {1,0,1,1,1},
            {1,1,1,0,0},
            {0,0,0,0,1}
        };
        System.out.println(shortestGameMap.solution(maps));
    }

    class Pos {
        public int x;
        public int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int solution(int[][] maps) {
        int[][] dist = new int[maps.length][maps[0].length];
        dist[0][0] = 1;

        List<Pos> queue = new ArrayList<>();
        queue.add(new Pos(0, 0));

        while(queue.size() > 0) {
            Pos pos = queue.remove(0);

            if(pos.x == maps.length - 1 && pos.y == maps[0].length - 1) break;

            // 위로 이동
            int newX = pos.x;
            int newY = pos.y - 1;
            if(newY >= 0 && dist[newY][newX] == 0 && maps[newY][newX] == 1) {
                dist[newY][newX] = dist[pos.y][pos.x] + 1;
                queue.add(new Pos(newX, newY));
            }

            // 아래로 이동
            newY = pos.y + 1;
            if(newY < maps.length && dist[newY][newX] == 0 && maps[newY][newX] == 1) {
                dist[newY][newX] = dist[pos.y][pos.x] + 1;
                queue.add(new Pos(newX, newY));
            }

            // 왼쪽 이동
            newX = pos.x - 1;
            newY = pos.y;
            if(newX >= 0 && dist[newY][newX] == 0 && maps[newY][newX] == 1) {
                dist[newY][newX] = dist[pos.y][pos.x] + 1;
                queue.add(new Pos(newX, newY));
            }

            // 오른쪽 이동
            newX = pos.x + 1;
            if(newX < maps[0].length && dist[newY][newX] == 0 && maps[newY][newX] == 1) {
                dist[newY][newX] = dist[pos.y][pos.x] + 1;
                queue.add(new Pos(newX, newY));
            }
        }

        int answer = dist[maps.length - 1][maps[0].length - 1];
        if(answer == 0) return -1;
        return answer;
    }
}
