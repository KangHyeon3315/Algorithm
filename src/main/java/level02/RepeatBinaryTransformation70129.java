package level02;

import java.util.Arrays;

/**
 * 이진 변환 반복하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/70129
 */
public class RepeatBinaryTransformation70129 {

    /*
    입출력 예
    s	result
    "110010101001"	[3,8]
    "01110"	[3,3]
    "1111111"	[4,1]
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("110010101001")));
        System.out.println(Arrays.toString(solution("01110")));
        System.out.println(Arrays.toString(solution("1111111")));

    }

    public static int[] solution(String s) {
        String x = s;
        int count = 0;
        int zeroCount = 0;
        while(!x.equals("1")) {
            for(char ch : x.toCharArray())
                if(ch == '0') zeroCount++; // 개선사항 : replaceAll 이전, 이후 길이 차이 -> 0의 개수
            x = x.replaceAll("0", "");
            x = Integer.toString(x.length(), 2);
            count++;
        }

        return new int[]{count, zeroCount};
    }
}
