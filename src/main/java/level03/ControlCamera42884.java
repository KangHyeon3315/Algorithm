package level03;

import java.util.Arrays;

/**
 * 단속카메라
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42884
 */
public class ControlCamera42884 {

    /*
    입출력 예

    routes	return
    [[-20,-15], [-14,-5], [-18,-13], [-5,-3]]	2
     */
    public static void main(String[] args) {
        ControlCamera42884 controlCamera = new ControlCamera42884();
        int[][] routes = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
        System.out.println(controlCamera.solution(routes));
    }

    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> o1[0] - o2[0]);

        int answer = 1;
        int duplicateStart = routes[0][0];
        int duplicateEnd = routes[0][1];
        for(int i = 1; i < routes.length; i++) {
            if(duplicateEnd < routes[i][0]) {
                // 새로운 중복 측정 시작
                answer++;
                duplicateStart = routes[i][0];
                duplicateEnd = routes[i][1];
            } else {
                duplicateStart = Math.max(duplicateStart, routes[i][0]);
                duplicateEnd = Math.min(duplicateEnd, routes[i][1]);
            }
        }


        return answer;
    }
}
