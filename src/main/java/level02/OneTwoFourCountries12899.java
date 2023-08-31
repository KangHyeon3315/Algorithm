package level02;

/**
 * 124 나라의 숫자
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12899
 */
public class OneTwoFourCountries12899 {
    /*
    입출력 예
    n	result
    1	1
    2	2
    3	4
    4	11
     */
    public static void main(String[] args) {
        OneTwoFourCountries12899 oneTwoFourCountries12899 = new OneTwoFourCountries12899();

        System.out.println(oneTwoFourCountries12899.solution(1));
        System.out.println(oneTwoFourCountries12899.solution(2));
        System.out.println(oneTwoFourCountries12899.solution(3));
        System.out.println(oneTwoFourCountries12899.solution(4));
    }

    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            int rest = n % 3;
            if(rest != 0) {
                sb.insert(0, rest);
                n /= 3;
            } else {
                sb.insert(0, '4');
                n = (n - 1) / 3;
            }

        }

        return sb.toString();
    }
}
