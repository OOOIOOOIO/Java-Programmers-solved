package kakao2018BLIND_RECRUITMENT;

import java.util.*;

public class 파일명정렬_3차 {


    class FileInfo{
        String head;
        Integer number;
        String tail;

        public FileInfo(String head, Integer number, String tail){
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

    }


    public String[] solution(String[] files) {

        ArrayList<FileInfo> fileList = new ArrayList<>();

        for(String file : files){
            System.out.println(file);
            String[] frontAndBack = file.split("[.]");
            System.out.println(frontAndBack[0]);
            String head = frontAndBack[0].split("[0-9]")[0];
            Integer tail = Integer.parseInt(frontAndBack[0].substring(head.length()));


            fileList.add(new FileInfo(head, tail, frontAndBack[1]));

        }

        Collections.sort(fileList, new Comparator<>(){

            public int compare(FileInfo o1, FileInfo o2){
                if(o1.head.compareTo(o2.head) == 0){ // 같으면
                    return o1.number - o2.number;
                }
                else{ //다르면
                    return o1.head.compareTo(o2.head);
                }

            }
        });

        String[] answer = new String[fileList.size()];

        for(int i = 0; i < fileList.size(); i++){
            FileInfo file = fileList.get(i);
            answer[i] = file.head + String.valueOf(file.number) + file.tail;
        }



        return answer;
    }


    public static void main(String[] args) {

        파일명정렬_3차 test = new 파일명정렬_3차();
//        String[] files = new String[] {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] files = new String[] {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        String[] solution = test.solution(files);

        for (String s : solution) {
            System.out.println("s = " + s);
        }
    }

}
