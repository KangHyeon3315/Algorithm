package level02;

import java.util.HashSet;
import java.util.Set;

/**
 * 방문 길이
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/49994
 */
public class VisitLength49994 {
    /*
    입출력 예
    dirs	answer
    "ULURRDLLU"	7
    "LULLLLLLU"	7
     */
    public static void main(String[] args) {
        VisitLength49994 visitLength = new VisitLength49994();
        System.out.println(visitLength.solution("ULURRDLLU"));
        System.out.println(visitLength.solution("LULLLLLLU"));
    }

    public int solution(String dirs) {
        Set<String> moveSet = new HashSet<>();

        int x = 0;
        int y = 0;
        for(char command : dirs.toCharArray()) {
            String move = "";
            switch(command) {
                case 'U':
                    if(y + 1 > 5) break;
                    move = String.format("(%d,%d)-(%d,%d)", x, y + 1, x, y);
                    moveSet.add(move);
                    y++;
                    break;
                case 'D':
                    if(y - 1 < -5) break;
                    move = String.format("(%d,%d)-(%d,%d)", x, y, x, y - 1);
                    moveSet.add(move);
                    y--;
                    break;
                case 'L':
                    if(x - 1 < -5) break;
                    move = String.format("(%d,%d)-(%d,%d)", x - 1, y, x, y);
                    moveSet.add(move);
                    x--;
                    break;
                case 'R':
                    if(x + 1 > 5) break;
                    move = String.format("(%d,%d)-(%d,%d)", x, y, x + 1, y);
                    moveSet.add(move);
                    x++;
                    break;
            }
        }

        return moveSet.size();
    }
}
