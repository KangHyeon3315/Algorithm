package level01;

/**
 * 제일 작은 수 제거하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12935
 */
public class RemoveMinNum12935 {

    /*
    입출력 예
    arr	return
    [4,3,2,1]	[4,3,2]
    [10]	[-1]
     */
    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        int[] result = solution(arr);
        for(int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        arr = new int[]{10};
        result = solution(arr);
        for(int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] solution(int[] arr) {
        if (arr.length == 1) return new int[]{-1};

        int[] answer = new int[arr.length - 1];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) min = Math.min(min, arr[i]);

        int answerIdx = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] != min) answer[answerIdx++] = arr[i];

        return answer;
    }
}
