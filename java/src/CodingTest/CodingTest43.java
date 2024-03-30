package CodingTest;

import java.util.Arrays;

public class CodingTest43 {
    public static void main(String args[]){
        String myStr="baconlettucetomato";
        Arrays.stream(myStr.split("[a-c]")).filter(e->e.length()>0).toArray();
    }
}
