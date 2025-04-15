package programmers.week5.prob10;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        // 테스트 케이스
        String[] strings = {
                "mv.song.mp3 11b",
                "greatSong.flac 1000b",
                "not3.txt 5b",
                "video.mp4 200b",
                "game.exe 100b",
                "movie1.mkv 10000b"
        };

        // 여기 아래부터 복사

        int[] answer = new int[4]; // {music, image, movie, other}


        String[] music = {"mp3", "aac", "flac"};
        String[] image = {"jpg", "bmp", "gif"};
        String[] movie = {"mp4", "avi", "mkv"};

        for(String st : strings) {

            String[] split = st.split(" "); // 공백으로 구분
            String ext = split[0].substring(split[0].lastIndexOf(".") + 1); // 확장자
            int volume = Integer.parseInt(split[1].substring(0, split[1].length() - 1)); // 파일 용량(00)

            if(ext.equals(music[0]) || ext.equals(music[1]) || ext.equals(music[2])) {
                answer[0] += volume;
            } else if(ext.equals(image[0]) || ext.equals(image[1]) || ext.equals(image[2])) {
                answer[1] += volume;
            } else if(ext.equals(movie[0]) || ext.equals(movie[1]) || ext.equals(movie[2])) {
                answer[2] += volume;
            } else {
                answer[3] += volume;
            }
        }

        System.out.println(Arrays.toString(answer));

    }

}
