package kakao2018BLIND_RECURITMENT;

import java.util.*;

public class 방금그곡_3차 {


    class Music{
        int time;
        String title;

        public Music(int time, String title){
            this.time = time;
            this.title = title;
        }
    }

    String changeMelody(String oldMelody) {
        oldMelody = oldMelody.replaceAll("C#", "H");
        oldMelody = oldMelody.replaceAll("D#", "I");
        oldMelody = oldMelody.replaceAll("F#", "J");
        oldMelody = oldMelody.replaceAll("G#", "K");
        String newMelody = oldMelody.replaceAll("A#", "L");

        return newMelody;
    }

    public String solution(String m, String[] musicinfos) {

        m = changeMelody(m);
        int maxPlayTime = -1;
        String answer = "";

        for(String music : musicinfos){
            String[] info = music.split(",");

            int startTime = Integer.parseInt(info[0].substring(0, 2)) * 60 + Integer.parseInt(info[0].substring(3));
            int endTime = Integer.parseInt(info[1].substring(0, 2)) * 60 + Integer.parseInt(info[1].substring(3));

            int playTime = endTime - startTime;
            String title = info[2];
            String rt = changeMelody(info[3]);
            int rtLength = rt.length();
            String newRt = "";


            if(playTime > rtLength){
                StringBuilder sb = new StringBuilder();
                sb.append(rt);

                for(int i = 0; i < playTime / rtLength; i++){
                    sb.append(rt);
                }

                sb.append(rt.substring(0, playTime % rtLength));
                newRt = sb.toString();

            }
            else{
                newRt = rt.substring(0, playTime);
            }

            if (newRt.contains(m) && playTime > maxPlayTime) {
                answer = title;
                maxPlayTime = playTime;
            }

        }



        return maxPlayTime != -1 ? answer : "(None)";
    }

    public static void main(String[] args) {

    }
}
