package kakao2019개발자겨울인턴십;
import java.util.*;
public class 불량사용자 {

    public static void main(String[] args) {
        String[] userId = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
//        String[] banned_id = {"*rodo", "*rodo", "******"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};


        int solution = Solution.solution(userId, banned_id);
        System.out.println("solution = " + solution);
    }

    static class Solution {
        private static Set<Set<String>> result;

        public static int solution(String[] user_id, String[] banned_id) {

            result = new HashSet<>();
            dfs(user_id, banned_id, new LinkedHashSet<>());
            return result.size();
        }

        private static void dfs(String[] user_id, String[] banned_id, Set<String> set) {
            if (set.size() == banned_id.length) { // 세트가 다 차면 이제 검사
                if (isBannedUsers(set, banned_id)) {
                    result.add(new HashSet<>(set)); // 세트들 저장
                }

                return;
            }

            // 하나의 세트가 다 찰 때까지 저장
            for (String userId : user_id) {
                if (!set.contains(userId)) {
                    set.add(userId);
                    dfs(user_id, banned_id, set);
                    set.remove(userId); // 백트래킹!!! boolean[] T/F 대신 이런식으로도 할 수 있구나~
                }
            }
        }

        private static boolean isBannedUsers(Set<String> set, String[] banned_id) {
            int i = 0;

            for (String user : set) {
                if (!isSameString(user, banned_id[i++])) {
                    return false;
                }
            }

            return true;
        }

        private static boolean isSameString(String userId, String bannedId) {
            if (userId.length() != bannedId.length()) {
                return false;
            }

            for (int i = 0; i < userId.length(); i++) {
                if (bannedId.charAt(i) == '*') continue;

                if (userId.charAt(i) != bannedId.charAt(i)) return false;

            }

            return true;
        }
    }
}