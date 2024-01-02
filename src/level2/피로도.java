package level2;

public class 피로도 {
    int max = -1;

    boolean isVisited[];

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        isVisited = new boolean[dungeons.length];

        goDungeon(dungeons, k, 0, 0);

        return max;
    }

    public void goDungeon(int[][] dungeons, int currTired, int cnt, int nextIdx){

        max = Math.max(max, cnt);

        for(int i = 0; i < dungeons.length; i++){

            if(!isVisited[i]){ // 처음
                if(currTired >= dungeons[i][0]){ // 최소 필요 피로도 <= 현재 피로도
                    isVisited[i] = true;
                    goDungeon(dungeons, currTired - dungeons[i][1], cnt+1, i+1);
                    isVisited[i] = false;
                }
            }

        }

    }
}
