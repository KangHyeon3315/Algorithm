package level02;

/**
 * 타겟 넘버
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 */
public class TargerNum43165 {

    /*
    입출력 예
    numbers	target	return
    [1, 1, 1, 1, 1]	3	5
    [4, 1, 2, 1]	4	2
     */
    public static void main(String[] args) {
        int result = new TargerNum43165().solution(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(result);

        result = new TargerNum43165().solution(new int[]{4, 1, 2, 1}, 4);
        System.out.println(result);
    }

    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    /**
     * @return 숫자를 만들 수 있는 경우의 수
     */
    public int dfs(int[] numbers, int target, int idx, int sum) {
        if (idx == numbers.length) {
            return sum == target ? 1 : 0;
        }

        int result = 0;
        // 더하는 경우
        result += dfs(numbers, target, idx + 1, sum + numbers[idx]);

        // 빼는 경우
        result += dfs(numbers, target, idx + 1, sum - numbers[idx]);

        return result;
    }
}
