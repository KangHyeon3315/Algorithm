package level02;

import java.util.HashSet;
import java.util.Set;

/**
 * 소수 찾기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42839
 */
public class FindPrime42839 {

    /*
    입출력 예
    numbers	return
    "17"	3
    "011"	2
     */
    public static void main(String[] args) {
        FindPrime42839 findPrime = new FindPrime42839();
        String numbers = "17";
        System.out.println(findPrime.solution(numbers));

        numbers = "011";
        System.out.println(findPrime.solution(numbers));
    }

    public int solution(String numbers) {
        Set<Integer> primes = new HashSet<>();
        char[] nums = numbers.toCharArray();
        boolean[] picked = new boolean[nums.length];

        search(primes, nums, picked, 0);

        return primes.size();
    }

    private void search(Set<Integer> primes, char[] nums, boolean[] picked, int num) {
        for(int i = 0 ; i < nums.length; i++) {
            if(picked[i]) continue;

            picked[i] = true;

            int newNum =  num * 10 + (nums[i] - '0');

            if(isPrime(newNum)) primes.add(newNum);

            search(primes, nums, picked, newNum);

            picked[i] = false;
        }
    }

    private boolean isPrime(int num) {
        if(num <= 1) return false;
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
