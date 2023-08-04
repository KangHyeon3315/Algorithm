package level01;

/**
 * 비밀지도
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/17681
 */
public class SecretMap17681 {

    /*
    입출력 예제
    매개변수	값
    n	5
    arr1	[9, 20, 28, 18, 11]
    arr2	[30, 1, 21, 17, 28]
    출력	["#####","# # #", "### #", "# ##", "#####"]

    매개변수	값
    n	6
    arr1	[46, 33, 33 ,22, 31, 50]
    arr2	[27 ,56, 19, 14, 14, 10]
    출력	["######", "### #", "## ##", " #### ", " #####", "### # "]
     */
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9,20,28,18,11};
        int[] arr2 = {30,1,21,17,28};

        String[] result = solution(n, arr1, arr2);
        for(String row : result) {
            System.out.println(row);
        }

        n = 6;
        arr1 = new int[]{46, 33, 33 ,22, 31, 50};
        arr2 = new int[]{27 ,56, 19, 14, 14, 10};
        result = solution(n, arr1, arr2);
        for(String row : result) {
            System.out.println(row);
        }
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int rowIdx = 0; rowIdx < n; rowIdx++) {
            String row1 = String.format("%" + n + "s", Integer.toString(arr1[rowIdx], 2)).replaceAll(" ", "0");
            String row2 = String.format("%" + n + "s", Integer.toString(arr2[rowIdx], 2)).replaceAll(" ", "0");

            char[] row = new char[n];
            for(int columnIdx = 0; columnIdx < n; columnIdx++) {
                char ch1 = row1.charAt(columnIdx);
                char ch2 = row2.charAt(columnIdx);

                row[columnIdx] = ch1 == '1' || ch2 == '1' ? '#' : ' ';
            }

            answer[rowIdx] = String.valueOf(row);
        }

        return answer;
    }

}
