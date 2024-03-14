package level3;

import java.util.*;
import java.util.stream.*;
class 베스트앨범 {

    public static void main(String[] args) {
        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[]{500, 600, 150, 800, 2500};

        int[] solution = solution(genres, plays);

        for (int i :
                solution) {
            System.out.println(i);
        }
    }

    static class Song{
        private int idx;
        private int playNum;

        public Song(int idx, int playNum){
            this.idx = idx;
            this.playNum = playNum;
        }
    }

    static Map<String, List<Song>> storeMap= new HashMap<>();

    static Map<String, Integer> totalPlayMap = new HashMap<>();

    public static int[] solution(String[] genres, int[] plays) {


        for(int i = 0; i < genres.length; i++){

            if(storeMap.containsKey(genres[i])){ // 처음이 아니라면
                storeMap.get(genres[i]).add(new Song(i, plays[i]));

                Integer playNum = totalPlayMap.get(genres[i]);
                totalPlayMap.put(genres[i], playNum + plays[i]);
            }
            else{ // 처음이라면
                ArrayList<Song> songs = new ArrayList<>();
                songs.add(new Song(i, plays[i]));

                storeMap.put(genres[i], songs);

                totalPlayMap.put(genres[i], plays[i]);
            }

        }

        // 노래가 가장 많은 순으로 정렬
        List<String> totalPlayMapKeyList = totalPlayMap.keySet().stream().collect(Collectors.toList());

        Collections.sort(totalPlayMapKeyList, (o1, o2) -> totalPlayMap.get(o2) - totalPlayMap.get(o1));

        // 장르 내 재생 수가 많은 순으로 정렬, 같을 경우 고유번호가 낮은 것 부터
        for(int i = 0; i < genres.length; i++){

            storeMap.get(genres[i]).sort((o1, o2) -> {
                if(o2.playNum == o1.playNum){
                    return o1.idx - o2.idx;
                }
                return o2.playNum - o1.playNum;
            });

        }

        List<Integer> list = new ArrayList<>();
        // 최다 재생수가 있는 장르부터 2개씩 가져오기
        for(String genre : totalPlayMapKeyList){
            int maxSize = 0;
            for(Song song : storeMap.get(genre)){

                list.add(song.idx);
                maxSize++;
            }

        }

        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();




        return answer;
    }



}
