public class CodingTest34{
    public static void main(String args[]){
        int[][] array ={{0, 1, 2},{1, 2, 3},{2, 3, 4},{3, 4, 5}};
        int k = 3;
        System.out.println(IntStream.rangeClosed(0,array.length-1)
                .boxed()
                .mapToInt(i-> IntStream.rangeClosed(0,array[i].length-1).boxed().filter(j-> (i+j)<=k).map(j->array[i][j]).collect(Collectors.summingInt(t->t)))
                .sum());
        //i+j <=k 인 원소들의 합
        System.out.println(IntStream.rangeClosed(0,array.length-1).boxed()
                .mapToInt(p->
                        IntStream.rangeClosed(0,array[p].length-1).boxed().filter(r->r==(k-1))
                                .map(t->array[p][t]).findFirst().get())
                .sum());
        //각 배열 k번째 원소 합

        int[] arr = {0, 1, 2, 3, 4};
        int[][] queries ={{0, 1},{1, 2},{2, 3}};

        Arrays.stream(queries).forEach(e-> IntStream.rangeClosed(e[0],e[1]).forEach(f->arr[f]++));
        System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(",")));

        //이차원 배열 쿼리 처리
    }
}