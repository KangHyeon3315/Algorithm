package level01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 다트 게임
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/17682
 */
public class DartGame17682 {

    /*
    입출력 예제
    예제	dartResult	answer	설명
    1	1S2D*3T	37	11 * 2 + 22 * 2 + 33
    2	1D2S#10S	9	12 + 21 * (-1) + 101
    3	1D2S0T	3	12 + 21 + 03
    4	1S*2T*3S	23	11 * 2 * 2 + 23 * 2 + 31
    5	1D#2S*3S	5	12 * (-1) * 2 + 21 * 2 + 31
    6	1T2D3D#	-4	13 + 22 + 32 * (-1)
    7	1D2S3T*	59	12 + 21 * 2 + 33 * 2
     */
    public static void main(String[] args) {
        String dartResult = "1S2D*3T";
        int result = solution(dartResult);
        System.out.println(result);

        dartResult = "1D2S#10S";
        result = solution(dartResult);
        System.out.println(result);

        dartResult = "1D2S0T";
        result = solution(dartResult);
        System.out.println(result);

        dartResult = "1S*2T*3S";
        result = solution(dartResult);
        System.out.println(result);

        dartResult = "1D#2S*3S";
        result = solution(dartResult);
        System.out.println(result);

        dartResult = "1T2D3D#";
        result = solution(dartResult);
        System.out.println(result);

        dartResult = "1D2S3T*";
        result = solution(dartResult);
        System.out.println(result);
    }

    public static int solution(String dartResult) {

        List<Integer> scoreResult = new ArrayList<>();
        int score = -1;
        char sdt = 'S'; // S : single, D : double, T: triple
        char option = '\0';
        for(int i = 0 ; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);

            if(ch >= '0' && ch <= '9') {
                if(i != 0) {
                    // 점수 계산
                    calc(score, sdt, option, scoreResult);

                    // 초기화
                    sdt = 'S';
                    option = '\0';
                }
                score = ch - '0';
                if(i + 1 < dartResult.length()
                        && score == 1
                        && dartResult.charAt(i + 1) == '0'
                ) {
                    // score가 10인 경우
                    score = 10;
                    i++;
                }
            } else if(ch == 'S' || ch == 'D' || ch == 'T') {
                sdt = ch;
            } else {
                option = ch;
            }
        }

        // 점수 계산
        calc(score, sdt, option, scoreResult);

        int answer = 0;
        for(int s : scoreResult) {
            answer += s;
        }

        return answer;
    }

    private static void calc(int score, char sdt, char option, List<Integer> scoreResult) {
        int s = score;
        if(sdt == 'D') {
            s *= score;
        } else if(sdt == 'T') {
            s *= score * score;
        }

        if(option == '*') {
            if(scoreResult.size() > 0) {
                int updatedPrevScore = scoreResult.get(scoreResult.size() - 1) * 2;
                scoreResult.set(scoreResult.size() - 1, updatedPrevScore);
            }
            s *= 2;
        } else if(option == '#') {
            s *= -1;
        }

        scoreResult.add(s);
    }
}
