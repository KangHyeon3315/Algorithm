package level02;

import java.util.*;

/**
 * 프렌즈4블록
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/17679
 */
public class Friends4Block17679 {

    /*
    입출력 예제
    m	n	board	answer
    4	5	["CCBDE", "AAADE", "AAABF", "CCBBF"]	14
    6	6	["TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"]	15
     */
    public static void main(String[] args) {
        Friends4Block17679 friends4Block17679 = new Friends4Block17679();
        String[] board = {
            "CCBDE",
            "AAADE",
            "AAABF",
            "CCBBF"
        };
        System.out.println(friends4Block17679.solution(4, 5, board));

        board = new String[] {
            "TTTANT",
            "RRFACC",
            "RRRFCC",
            "TRRRAA",
            "TTMMMF",
            "TMMTTJ"
        };
        System.out.println(friends4Block17679.solution(6, 6, board));
    }

    class Pos{
        public int x;
        public int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return String.format("%d-%d", x, y).hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Pos) {
                Pos p = (Pos)obj;
                return p.x == x && p.y == y;
            }

            return false;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", x, y);
        }
    }

    public int solution(int m, int n, String[] board) {
        List<List<Character>> map = new ArrayList<>();
        for(int i = 0; i < n; i++) map.add(new LinkedList<>());

        for(int i = m - 1; i >= 0; i--) {
            for(int j = 0; j < n; j++) {
                map.get(j).add(board[i].charAt(j));
            }
        }

        int answer = 0;
        Set<Pos> willRemove = new HashSet<>(); // (o1, o2) -> o2.y - o1.y
        while(true) {
            checkWillRemove(map, willRemove);

            if(willRemove.size() == 0) break;

            answer += remove(map, willRemove);
        }

        return answer;
    }

    private void checkWillRemove(List<List<Character>> map, Set<Pos> willRemove) {
        for(int x = 0; x < map.size() - 1; x++) {
            for(int y = 0; (y < map.get(x).size() - 1 && y < map.get(x + 1).size() - 1); y++) {
                int v1 = map.get(x).get(y);
                int v2 = map.get(x).get(y + 1);
                int v3 = map.get(x + 1).get(y);
                int v4 = map.get(x + 1).get(y + 1);

                if(v1 != v2 || v2 != v3 || v3 != v4) continue;

                Pos p1 = new Pos(x, y);
                Pos p2 = new Pos(x, y + 1);
                Pos p3 = new Pos(x + 1, y);
                Pos p4 = new Pos(x + 1, y + 1);

                willRemove.add(p1);
                willRemove.add(p2);
                willRemove.add(p3);
                willRemove.add(p4);
            }
        }
    }

    private int remove(List<List<Character>> map, Set<Pos> willRemove) {
        int count = 0;
        List<Pos> poses = new ArrayList<>(willRemove);
        poses.sort((o1, o2) -> o2.y - o1.y);
        for(Pos p : poses) {
            map.get(p.x).remove(p.y);
            count++;
        }
        willRemove.clear();
        return count;
    }

    private void printMap(List<List<Character>> map) {
        int height = 0;
        for(int i = 0; i < map.size(); i++) {
            height = Math.max(height, map.get(i).size());
        }

        for(int y = height - 1; y >= 0; y--) {
            for(int x = 0; x < map.size() - 1; x++) {
                if(y >= map.get(x).size()) {
                    System.out.print("  ");
                    continue;
                }
                System.out.print(map.get(x).get(y) + " ");
            }

            System.out.println();
        }

    }
}
