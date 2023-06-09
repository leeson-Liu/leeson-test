package lamba;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author liubin
 * @create 2018-10-25 15:38
 * @desc ${DESCRIPTION}
 **/
public class listTest {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList();
        list1.add("1111");
        list1.add("2222");
        list1.add("3333");

        List<String> list2 = new ArrayList();
        list2.add("3333");
        list2.add("4444");
        list2.add("5555");
//        list1.retainAll(list2); //∩
        list1.removeAll(list2);
        System.out.println(list1);
//        List<String> result = distinct(list1,list2);
//        System.out.println(result);
    }
    //交集 ∩
    private static List<String> intersection(List<String> list1,List<String> list2) {
        List<String> intersection = list1.stream().filter(item -> list2.contains(item)).collect(Collectors.toList());
        return intersection;
    }

    //差集 (list1 - list2)
    private static List<String> reduce1(List<String> list1,List<String> list2) {
        List<String> reduce1 = list1.stream().filter(item -> !list2.contains(item)).collect(Collectors.toList());
        return reduce1;
    }
    //去重
    private static List<String> distinct(List<String> list1,List<String> list2) {
        list1.addAll(list2);
        System.out.println(list1);
        System.out.println(list1.addAll(list2));
        List<String> listAllDistinct = list1.stream().distinct().collect(Collectors.toList());
        return listAllDistinct;
    }

}
