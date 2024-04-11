package CodingTest;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CodingTest49 {
    public static void main(String args[]){
        int q = 3;
        int r = 1;
        String code = 	"qjnwezgrpirldywt";

        IntStream.rangeClosed(0,code.split("").length-1).boxed().filter(e->e%q==r).map(e->code.split("")[e])
                .collect(Collectors.joining());
    }
}
