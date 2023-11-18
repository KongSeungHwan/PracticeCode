package CodingTest;

import java.util.ArrayList;
import java.util.List;

public class CodingTest21 {
    public static void main(String[] args) {
        List<Integer> arr = List.of(293, 1000, 395, 678, 94);
        List<Integer> delete_list = List.of(94, 777, 104, 1000, 1, 12);
        List<Integer> answer = new ArrayList<>();
        for (int num : arr) {
            answer.add(num);
        }

        for(int del : delete_list){
            int index = answer.indexOf(del);

            if (index != -1) {
                answer.remove(index);
            }
        }
    }
}
