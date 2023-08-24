package level02;

import java.util.Arrays;

/**
 * [3차] 파일명 정렬
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/17686
 */
public class FileNameSort17686 {

    /*
    입출력 예제
    입력: ["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]
    출력: ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]

    입력: ["F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"]
    출력: ["A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"]
     */
    public static void main(String[] args) {
        FileNameSort17686 fileNameSort = new FileNameSort17686();
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(Arrays.toString(fileNameSort.solution(files)));

        files = new String[] {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        System.out.println(Arrays.toString(fileNameSort.solution(files)));
    }

    class File {
        public String fileName;
        public String head;
        public int number;

        public File(String fileName) {
            this.fileName = fileName;

            int headSize = parseHeadSize(fileName);
            this.head = fileName.substring(0, headSize).toLowerCase();
            this.number = parseNumber(fileName, headSize);
        }

        private int parseHeadSize(String fileName) {
            for(int i = 0; i < fileName.length(); i++) {
                char ch = fileName.charAt(i);
                if(ch >= '0' && ch <= '9') {
                    return i;
                }
            }
            return 0;
        }

        private int parseNumber(String fileName, int startIdx) {
            int num = 0;
            for(int i = startIdx; i < fileName.length(); i++) {
                char ch = fileName.charAt(i);
                if(ch < '0' || ch > '9') {
                    break;
                }
                num = num * 10 + (ch - '0');
            }

            return num;
        }
    }

    public String[] solution(String[] files) {
        return Arrays.stream(files)
                .map(File::new)
                .sorted((o1, o2) -> {
                    if(o1.head.equals(o2.head)) {
                        return o1.number - o2.number;
                    } else {
                        return o1.head.compareTo(o2.head);
                    }
                })
                .map(f -> f.fileName)
                .toArray(String[]::new);
    }
}
