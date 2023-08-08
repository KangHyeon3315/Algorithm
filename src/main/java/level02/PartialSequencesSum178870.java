package level02;

/**
 * 연속된 부분 수열의 합
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/178870
 */
public class PartialSequencesSum178870 {

    public static void main(String[] args) {
        int[] sequence = {1, 2, 3, 4, 5};
        int k = 7;
        int[] result = solution(sequence, k);
        System.out.println("Case 1 : " + result[0] + ", " + result[1]);

        sequence = new int[]{1, 1, 1, 2, 3, 4, 5};
        k = 5;
        result = solution(sequence, k);
        System.out.println("Case 2 : " + result[0] + ", " + result[1]);

        sequence = new int[]{2, 2, 2, 2, 2};
        k = 6;
        result = solution(sequence, k);
        System.out.println("Case 3 : " + result[0] + ", " + result[1]);
    }

    public static int[] solution(int[] sequence, int k) {
        int startIdx = 0;
        int endIdx = 0;
        int sum = sequence[0];

        int[] answer = {0, sequence.length};

        while (startIdx <= endIdx) {
            if(sum <= k) {
                if(sum == k && answer[1] - answer[0] > endIdx - startIdx) {
                    answer[0] = startIdx;
                    answer[1] = endIdx;
                }

                if(endIdx + 1 >= sequence.length) break;

                endIdx++;
                sum += sequence[endIdx];
            } else {
                sum -= sequence[startIdx];
                startIdx++;
            }
        }

        return answer;
    }
}
