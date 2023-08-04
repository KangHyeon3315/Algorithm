package level01;

/**
 * 소수 만들기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12977
 */
public class PrimeMake12977 {

    /*
    입출력 예
    nums	result
    [1,2,3,4]	1
    [1,2,7,6,4]	4
     */
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int result = solution(nums);
        System.out.println(result);

        nums = new int[]{1,2,7,6,4};
        result = solution(nums);
        System.out.println(result);
    }

    public static int solution(int[] nums) {
        int n = nums.length;

        int answer = 0;
        for(int i = 0 ; i < n - 2; i++) {
            int a = nums[i];
            for(int j = i + 1; j < n - 1; j++) {
                int b = nums[j];
                for(int k = j + 1; k < n; k++) {
                    int c = nums[k];

                    int num = a + b + c;

                    if(isPrime(num)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    private static boolean isPrime(int num) {
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
