package level03;

/**
 * 스티커 모으기(2)
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12971
 */
public class CollectSticker12971 {

    /*
    입출력 예
    sticker	answer
    [14, 6, 5, 11, 3, 9, 2, 10]	36
    [1, 3, 2, 5, 4]	8
     */
    public static void main(String[] args) {
        CollectSticker12971 collectSticker12971 = new CollectSticker12971();

        System.out.println(collectSticker12971.solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10}));

        System.out.println(collectSticker12971.solution(new int[]{1, 3, 2, 5, 4}));
    }

    public int solution(int[] sticker) {
        int n = sticker.length;

        if(n == 1) return sticker[0];
        if(n == 2) return Math.max(sticker[0], sticker[1]);

        int[] sticker1 = new int[n];
        int[] sticker2 = new int[n];
        for(int i=0;i<n;i++ ) sticker1[i] = sticker[i];
        sticker1[n-1] = 0;

        for(int i=0;i<n-1;i++) sticker2[i] = sticker[i+1];
        sticker2[n-1] = 0;


        int[] dp1 = new int[n];
        dp1[0] = sticker1[0];
        dp1[1] = Math.max(dp1[0], sticker1[1]);

        for(int i=0;i<n-2;i++){
            dp1[i+2] = Math.max(dp1[i] + sticker1[i+2], dp1[i+1]);
        }

        int[] dp2 = new int[n];
        dp2[0] = sticker2[0];
        dp2[1] = Math.max(dp2[0], sticker2[1]);

        for(int i=0;i<n-2;i++){
            dp2[i+2] = Math.max(dp2[i] + sticker2[i+2], dp2[i+1]);
        }

        return Math.max(dp1[n - 1], dp2[n - 1]);
    }
}
