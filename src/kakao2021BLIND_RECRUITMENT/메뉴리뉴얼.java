package kakao2021BLIND_RECRUITMENT;

import java.util.*;

class 메뉴리뉴얼 {
    // 메뉴를 저장할 Map
    Map<String, Integer> map;
    // 최댓값
    int max = 0;

    // dfs 탐색 메서드
    public void dfs(String order, String key, int idx, int end, int depth) {
        // 코스의 길이와 동일할 때까지 탐색했을 경우
        if(depth == end) {
            // map에 key와 value를 넣어줌
            map.put(key, map.getOrDefault(key, 0) + 1);

            // max값 변경
            max = Math.max(max, map.get(key));
        }

        // dfs 메서드 재귀호출
        for(int i = idx; i < order.length(); i++) {
            dfs(order, key + order.charAt(i), i+1, end, depth + 1);
        }
    }

    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> ans = new ArrayList<>();

        // course 배열만큼 반복
        for(int c : course) {
            // HashMap, max 값 초기화
            map = new HashMap<>();
            max = 0;

            // 주문서만큼 반복
            for(String order: orders) {
                // 각 주문마다 알파벳 순서대로 정렬
                char[] strs = order.toCharArray();
                Arrays.sort(strs);
                order = new String(strs);
                // dfs 탐색 시작
                dfs(order, "", 0, c, 0);
            }

            // map에 저장된 key 개수만큼 반복
            for(String key : map.keySet()) {
                // key값으로 value를 불러옴
                int value = map.get(key);
                // value가 2 이상이면서 max랑 동일하다면
                if(value > 1 && max == value) {
                    // 배열에 키값을 저장
                    ans.add(key);
                }
            }
        }

        // 정렬을 진행
        Collections.sort(ans);

        // String[] 배열로 변환
        String[] answer = ans.toArray(new String[ans.size()]);

        return answer;
    }
}
