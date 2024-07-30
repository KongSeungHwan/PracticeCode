package javaPrac.student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamPrac {

    public static void main(String args[]){
        List<Student> list= IntStream.rangeClosed(0,15).boxed().map(i->
            new Student(
                    IntStream.rangeClosed(0,new Random().nextInt(10)+1)
                            .boxed()
                            .map(ch-> String.valueOf((char)(97+(new Random().nextInt(15)+1)) )).collect(Collectors.joining()),
                    new Random().nextInt(100)+1,
                    new Random().nextInt(4)+1,
                    new Random().nextInt(3)+1
            )
        ).toList();
        System.out.printf("전교생 %d명 출력: \n\n",list.size());
        Map<Integer, Map<Integer, Map<Integer, List<Student>>>> stuMap = list.stream().collect(Collectors.groupingBy(Student::getYear,Collectors.groupingBy(Student::getSubClass,Collectors.groupingBy(v->(v.getScore()/10)*10)
        )));
        IntStream.rangeClosed(1,4).boxed().forEach(y->{
            Map<Integer, Map<Integer, List<Student>>> subMap = stuMap.get(y);
            System.out.printf("%d학년 : \n",y);
            IntStream.rangeClosed(1,3).boxed().forEach(s->{
                Map<Integer, List<Student>> scoreMap = subMap.get(s);
                if(scoreMap != null){
                    System.out.printf("\t%d반 : \n",s);
                    scoreMap.keySet().stream().sorted().forEach(sc->{
                    System.out.printf("\t\t%s : \n",(sc!=0) ? (sc+"점대"):("10점 이하") );
                        scoreMap.get(sc).stream().sorted(Comparator.comparing(Student::getScore)).forEach(st->{
                            System.out.printf("\t\t\t이름: %s 점수:%d \n",st.getName(),st.getScore());
                        });
                    });
                }
            });
        });
    }
}
