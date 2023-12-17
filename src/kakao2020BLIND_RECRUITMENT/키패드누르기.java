package kakao2020BLIND_RECRUITMENT;
import java.util.*;
import java.util.stream.Collectors;

public class 키패드누르기 {

    static class Thumb{
        int y;
        int x;

        public Thumb(int y, int x){
            this.y = y;
            this.x = x;
        }
        public void setThumb(int x, int y){
            this.x = x;
            this.y = y;
        }


        public int getY(){
            return this.y;
        }

        public int getX(){
            return this.x;
        }


    }

    static StringBuilder sb = new StringBuilder();
    static Thumb right = new Thumb(3, 2);
    static Thumb left = new Thumb(3, 0);
    public static String solution(int[] numbers, String hand) {



        for(int number : numbers){
            if(number == 1 || number == 4 || number == 7){
                printThumb(number, getY(number), getX(number));
                left.setThumb(getX(number), getY(number));

                sb.append("L");
            }
            else if(number == 3 || number == 6 || number == 9){
                printThumb(number, getY(number), getX(number));
                right.setThumb(getX(number), getY(number));

                sb.append("R");
            }
            else{
                compareHand(hand, number);

            }

        }

        return sb.toString();
    }

    private static int getX(int num){
        if(num == 0) return 1;

        return (num - 1) % 3;
    }

    private static int getY(int num){
        if(num == 0) return 3;

        // if(num == 1) return 0;

        return (num - 1) / 3;
    }

    private static void compareHand(String hand, int number){

        int y = getY(number);
        int x = getX(number);

        System.out.println("number : " + number + " / y : " + y + " / x : " + x);
        System.out.println("right thumb | y : " + right.y + " / x : " + right.x);
        System.out.println("left thumb | y : " + left.y + " / x : " + left.x);

        int rightDist = Math.abs(right.getY() - y) + Math.abs(right.getX() - x);
        int leftDist = Math.abs(left.getY() - y) + Math.abs(left.getX() - x);

        System.out.println("right : " + rightDist + " / left : " + leftDist);
        System.out.println();

        if(rightDist > leftDist){
            left.setThumb(x, y);

            sb.append("L");
        }
        else if(rightDist < leftDist){
            right.setThumb(x, y);

            sb.append("R");
        }
        else{
            if(hand.equals("right")){
                right.setThumb(x, y);

                sb.append("R");
            }
            else{
                left.setThumb(x, y);

                sb.append("L");
            }
        }

    }

    private static void printThumb(int number, int y, int x){
        System.out.println("number : " + number + " / y : " + y + " / x : " + x);
        System.out.println("right thumb | y : " + right.y + " / x : " + right.x);
        System.out.println("left thumb | y : " + left.y + " / x : " + left.x);
        System.out.println();
    }

    /**
     * ============
     */

    private static class Hand {
        private final int baseX;
        public final String hand;
        public final float preference;
        private int x;
        private int y;

        public Hand(String hand, boolean isPreferred, int x) {
            this.hand = hand;
            this.baseX = x;
            this.preference = isPreferred ? 0.5f : 0;
            this.x = x;
            this.y = 3;
        }

        public float distance(int x, int y) {
            if (x == baseX) return 0;
            int distance = Math.abs(x - this.x) + Math.abs(y - this.y);
            return distance - preference;
        }

        public void move(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    private Hand press(int number, Hand right, Hand left) {
        int x = getX(number);
        int y = getY(number);

        float rDistance = right.distance(x, y);
        float lDistance = left.distance(x, y);

        Hand hand = right;
        if (lDistance < rDistance) {
            hand = left;
        }
        hand.move(x, y);
        return hand;
    }

    public String solution2(int[] numbers, String hand) {
        Hand right = new Hand("R", hand.equals("right"), 2);
        Hand left = new Hand("L", hand.equals("left"), 0);

        return Arrays.stream(numbers)
                .mapToObj(n -> press(n, right, left).hand)
                .collect(Collectors.joining());
    }

    /**
     * ================
     */
    public static void main(String[] args) {
        String right1 = solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
        System.out.println(right1);

    }


}
