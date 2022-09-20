package level3;

public class 단어변환 {

	public static void main(String[] args) {
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		String begin = "hit";
		String target = "cog";
		
		solution(begin, target, words);
		
	}
	
	static boolean[] visited;
	static int answer = 0;
	
    public static int solution(String begin, String target, String[] words) {
    	visited = new boolean[words.length];
    	
        dfs(begin, target, words, 0);
        
        return answer;
    }
    
    public static void dfs(String begin, String target, String[] words, int cnt) {
    	
    	if(begin.equals(target)) {
    		answer = cnt;
    		return;
    	}
    	
    	for(int i = 0; i < words.length; i++) {
    		
    		// 아직 방문하지 않았다면
            if(!visited[i]) {
            	
            	int k = 0;    
            	
            	// 같은 스펠링 몇개인지 세기
                for (int j = 0; j < begin.length(); j++) {
                    if (begin.charAt(j) == words[i].charAt(j)) {
                        k++;
                    }
                }

                // 한글자 빼고 모두 같은 경우
                if (k == begin.length() - 1) {  
                    visited[i] = true;
                    dfs(words[i], target, words, cnt + 1);
                    visited[i] = false;
                }
            }
    	}
    	
    }
}

/*
 * hit - dot 비교
 * 비교해서 다른 자리가 cog와 같은지 비교 / 비교하고 같은 자리수 2개인 경우에만 dfs 돌리기 --> 이게 틀렸음
 * 만약 같다면 바꾸기
 * 이거 반복
 *  
 */


