package level01;

/**
 * 모의고사
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42840
 */
public class MockTest42840 {

    /*
    입출력 예
    answers	return
    [1,2,3,4,5]	[1]
    [1,3,2,4,2]	[1,2,3]
     */
    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};

        int[] result = solution(answers);
        for(int i : result) {
            System.out.println(i);
        }

        answers = new int[]{1, 3, 2, 4, 2};
        result = solution(answers);
        for(int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] answers) {
        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int maxScore = 0;
        int[] scores = {0, 0, 0};
        for(int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            for(int user = 0; user < scores.length; user++) {
                int idx = i % patterns[user].length;

                if(patterns[user][idx] == answer) {
                    scores[user] += 1;

                    maxScore = Math.max(maxScore, scores[user]);
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < scores.length; i++) {
            if(maxScore == scores[i]) cnt++;
        }

        int[] result = new int[cnt];
        int resultIdx = 0;
        for(int i = 0; i < scores.length; i++) {
            if(maxScore == scores[i]) result[resultIdx++] = i + 1;
        }

        return result;
    }
}
