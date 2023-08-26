package level02;

import java.util.Arrays;

/**
 * 2개 이하로 다른 비트
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/77885
 */
public class DiffBits2Under77885 {

    /*
    입출력 예
    numbers	result
    [2,7]	[3,11]
     */
    public static void main(String[] args) {
        DiffBits2Under77885 diffBits2Under77885 = new DiffBits2Under77885();
        long[] numbers = {2, 7};
        long[] answer = diffBits2Under77885.solution(numbers);
        System.out.println(Arrays.toString(answer));
    }

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            answer[i] = f(numbers[i]);
        }
        return answer;
    }

    private long f(long number) {
        char[] bits = ("0" + Long.toString(number, 2)).toCharArray();

        if(bits[bits.length - 1] == '0') {
            return number + 1;
        }

        for(int i = bits.length - 2; i >= 0; i--) {
            if(bits[i] == '0' && bits[i + 1] == '1') {
                bits[i] = '1';
                bits[i + 1] = '0';
                break;
            }
        }

        return Long.parseLong(new StringBuilder().append(bits).toString(), 2);
    }
}
