package level03;

/**
 * 기지국 설치
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12979
 */
public class BaseStationInstallation12979 {

    /*
    입출력 예
    N	stations	W	answer
    11	[4, 11]	1	3
    16	[9]	2	3
     */
    public static void main(String[] args) {
        BaseStationInstallation12979 baseStationInstallation12979 = new BaseStationInstallation12979();

        int n = 11;
        int[] stations = {4, 11};
        int w = 1;

        int answer = baseStationInstallation12979.solution(n, stations, w);

        System.out.println(answer);
    }

    public int solution(int n, int[] stations, int w) {
        int width = w * 2 + 1;

        int answer = 0;

        int lastCovered = 0;
        for(int station : stations) {
            int blank = station - w - lastCovered - 1;

            answer += (int)Math.ceil((double)blank / width);

            lastCovered = station + w;
        }

        int blank = n - lastCovered;
        if(blank > 0)
            answer += (int)Math.ceil((double)blank / width);

        return answer;
    }
}
