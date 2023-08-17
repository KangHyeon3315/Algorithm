package level02;

/**
 * k진수에서 소수 개수 구하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/92335
 */
public class BaseKPrimeCounter92335 {
    /*
    입출력 예
    n	k	result
    437674	3	3
    110011	10	2
     */
    public static void main(String[] args) {
        System.out.println(new BaseKPrimeCounter92335().solution(437674, 3));
        System.out.println(new BaseKPrimeCounter92335().solution(110011, 10));
    }

    public int solution(int n, int k) {
        String numStr = Integer.toString(n, k);
        String[] nums = numStr.split("0");

        int count = 0;
        for(String num : nums) {
            if(num.equals("") || num.equals("1")) continue;

            if(isPrime(Long.parseLong(num))) {
                count++;
            }
        }

        return count;
    }

    public boolean isPrime(long num) {
        for(long i = 2; i * i <= num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
