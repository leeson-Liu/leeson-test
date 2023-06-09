import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liubin
 * @create 2018-10-25 14:00
 * @desc ${DESCRIPTION}
 **/
public class test2 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("1");
        list1.add("2");
        list1.add("3");

        //List<String> list2 = aaa(list1);
        List<String> list2 = filter(list1);
        System.out.println(list2);
    }


    /**
     * stream 的组装
     * @param list1
     * @return
     */
    private static List<String> aaa(List<String> list1) {
        List<String> list2 = list1.stream().map(string -> {return "stream().map()处理之后：" + string;}).collect(Collectors.toList());
        return list2;
    }


    private static List<String> filter(List<String> list1) {
        List<String> list2 = list1.stream().filter(s -> s != "1").collect(Collectors.toList());
        return list2;
    }


}
