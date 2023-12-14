package summer_winter_coding_2018;

import java.util.*;

public class 스킬트리 {



    public int solution2(String skill, String[] skill_trees) {
        int answer = -1;

        return (int) Arrays.stream(skill_trees)
                .map(s -> s.replaceAll("[^" + skill + "]", ""))
                .filter(skill::startsWith)
                .count();


    }


    public int solution(String skill, String[] skill_trees) {
        int answer = -1;



        List list = new ArrayList<>();

        for(String s : skill.split("")){
            list.add(s);
        }

        int total = 0;

        for(String skillTree : skill_trees){
            int idx = 0;
            boolean flag = true;

            for(String str : skillTree.split("")){
                if(list.contains(str)){
                    if(list.get(idx).equals(str)){
                        idx++;
                    }
                    else{
                        flag = false;
                        break;
                    }

                    if(idx == list.size()) break; //종료
                }
            }

            if(flag) total++;
        }



        return total;


    }





}
