package CodingTest;

import java.util.Arrays;

public class CodingTest48 {
    public static void main(String args[]){
        // 아메리카노 카페라떼 4500/5000 가격 각각
        String[] order = {"cafelatte", "americanoice", "hotcafelatte", "anything"};

        System.out.println(Arrays.stream(order).mapToInt(e->e.contains("cafelatte")? 5000:4500).sum());
    }
}
