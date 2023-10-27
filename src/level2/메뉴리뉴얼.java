package level2;

import java.util.*;
import java.util.stream.Collectors;

public class 메뉴리뉴얼 {

    private static class Course{
        public final String course;
        public final int occurrences;

        public Course(String course, int occurrences){
            this.course = course;
            this.occurrences = occurrences;
        }
    }


    /**
     * 종료 조건
     * 10 >= x > 2
     *
     * 지금까지 코스 메뉴 : selectedMenus
     * 사이즈별 코스 메뉴 : courses
     */
    private void getCourses(char nextMenu, Set<String> selectedMenus, List<Set<String>> orderList, Map<Integer, List<Course>> courses){

        //orderList 요소들 안에 selectedMenus가 얼마나 포함되어 있는지
        int occurrences = (int) orderList.stream()
                .filter(order -> order.containsAll(selectedMenus))
                .count();

        //종료
        if(occurrences < 2) return;

        // 현재 코스에 포함된 메뉴 개수들
        int size = selectedMenus.size();

        // 사이즈 별 코스들 검사
        if(courses.containsKey(size)){
            List<Course> courseList = courses.get(size);

            // 새로운 코스
            Course course = new Course(selectedMenus.stream()
                    .sorted()
                    .collect(Collectors.joining()), occurrences);

            // 현재까지 모인 코스
            Course original = courseList.get(0);

            if(original.occurrences < occurrences){
                courseList.clear(); // 싹 다 지워버림
                courseList.add(course);
            }
            else if(original.occurrences == occurrences){
                courseList.add(course);
            }

        }

        //종료
        if(occurrences >= 10) return;

        for(char menuChar = nextMenu; menuChar <= 'Z'; menuChar++){
            String menu = String.valueOf(menuChar);
            selectedMenus.add(menu);
            getCourses((char)(menuChar+1), selectedMenus, orderList, courses);
            selectedMenus.remove(menu);
        }



    }
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        //orderList
        List<Set<String>> orderList = Arrays.stream(orders)
                .map(String::chars) //IntStream
                .map(charStream ->
                        charStream.mapToObj(menu -> String.valueOf(menu)) //char -> String
                                .collect(Collectors.toSet()) //Set<String>
                )
                .collect(Collectors.toList());//List<Set<String>>


        //사이즈별 코스들
        Map<Integer, List<Course>> courses = new HashMap<>();
        //초기화
        for(int length : course){
            List<Course> list = new ArrayList<>();
            list.add(new Course("", 0));
            courses.put(length, list);

        }

        //재귀
        getCourses('A', new HashSet<String>(), orderList, courses);





        return answer;
    }

}
