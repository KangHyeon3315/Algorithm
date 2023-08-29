package level03;

import java.util.*;

/**
 * 베스트앨범
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42579
 */
public class BestAlbum42579 {

    /*
    입출력 예
    genres	plays	return
    ["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
     */
    public static void main(String[] args) {
        BestAlbum42579 bestAlbum42579 = new BestAlbum42579();

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        int[] answer = bestAlbum42579.solution(genres, plays);

        System.out.println(Arrays.toString(answer));
    }

    class Album {
        public final int id;
        public final String genre;
        public final int play;

        public Album(int id, String genre, int play) {
            this.id = id;
            this.genre = genre;
            this.play = play;
        }

        public String toString() {
            return String.format("%s - %s - %s", id, genre, play);
        }

    }
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlays = new HashMap<>();
        Map<String, Queue<Album>> genreAlbums = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            genrePlays.put(genre, genrePlays.getOrDefault(genre, 0) + play);
            if(!genreAlbums.containsKey(genre)) {
                Queue<Album> q = new PriorityQueue<>((o1, o2) -> o2.play - o1.play);
                genreAlbums.put(genre, q);
            }
            genreAlbums.get(genre).add(new Album(i, genre, play));
        }

        List<Integer> answer = new ArrayList<>();
        genrePlays.entrySet()
                .stream()
                .sorted(((o1, o2) -> o2.getValue() - o1.getValue()))
                .map(entry -> entry.getKey())
                .forEach(genre -> {
                    for(int i = 0; i < Math.min(2, genreAlbums.get(genre).size() + 1); i++) {
                        answer.add(genreAlbums.get(genre).poll().id);
                    }
                });

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
