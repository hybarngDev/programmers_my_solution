import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collections;


class Solution {
    //Collections.reverseOrder()
    class Info {
        public int i;
        public int play;
        public String genre;
        public Info(int i, int play, String genre) {
            this.i = i;
            this.play = play;
            this.genre = genre;
        }
    }
    class BestSongs {
        public Info i1 = null;
        public Info i2 = null;
        public BestSongs (Info info) {
            i1 = info;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        //unsorted : <Genre name, Total play>
        Map<String, Integer> genresMap = new HashMap<String, Integer>();
        
        //sorted : <Total play, Genre name>
        Map<Integer, String> sortedGenre = new TreeMap<Integer, String>(Collections.reverseOrder());
        
        //sorted : <New index, Info> 
        Map<Integer, Info> songs = new TreeMap<Integer, Info>(Collections.reverseOrder());
        
        //unsorted : <Genre, BestSongs> 
        Map<String, BestSongs> album = new HashMap<String, BestSongs>();
            
        int sum;
        for(int i = 0; i < genres.length; i++) {
            if(genresMap.containsKey(genres[i])) {
                genresMap.replace(genres[i], genresMap.get(genres[i]) + plays[i]);
            } else {
                genresMap.put(genres[i], plays[i]);
            }
            
            songs.put(getNewKey(i, plays[i]), new Info(i, plays[i], genres[i]));
        }
        
        for(Map.Entry en : genresMap.entrySet()) {
            sortedGenre.put((Integer)en.getValue(), (String)en.getKey());
        }
        
        int totalCount = 0;
        for(Map.Entry en : songs.entrySet()) {
            Info curInfo = (Info)en.getValue();
            if(album.containsKey(curInfo.genre)) {
                BestSongs bs = album.get(curInfo.genre);
                if(bs.i1 == null) {
                    bs.i1 = curInfo;
                    album.replace(curInfo.genre, bs);
                    totalCount++;
                    continue;
                }
                else if(bs.i2 == null) {
                    bs.i2 = curInfo;
                    album.replace(curInfo.genre, bs);
                    totalCount++;
                    continue;
                }
            }
            else {
                album.put(curInfo.genre, new BestSongs(curInfo));  
                totalCount++;
            }
            
        }
        
        answer = new int[totalCount];
        int index = 0;
        for(Map.Entry en : sortedGenre.entrySet()) {
            String curGenre = (String)en.getValue();
            BestSongs bs = album.get(curGenre);
            if(bs.i1 != null) {
                 answer[index++] = bs.i1.i;
            }
            
            
            if(bs.i2 != null) {
                 answer[index++] = bs.i2.i;
            }
        }
        return answer;
    }
    
    private int getNewKey(int i, int play) {
        return play * 10000 + 10000 - i;
    }
}
