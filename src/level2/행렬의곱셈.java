package level2;

public class 행렬의곱셈 {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] arr = new int[arr1.length][arr2[0].length];

        // arr1은 행으로
        // arr2는 열로
        // 결과는 arr1의 행(행) + arr2의 열(열)

        // 전체 루프는 arr1의 행 * 열 * arr2의 열
        int loopSize = arr1.length + arr1[0].length + arr[0].length;

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                arr[i][j] = 0;

                for(int k = 0; k < arr1[i].length; k++){ // arr1의 열, arr2의 행이 곱해지기 때문에 arr1을 기준으로 계산
                    arr[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }


        return arr;
    }
}
