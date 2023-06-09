import java.util.*;

/**
 * @author liubin
 * @create 2019-03-11 13:44
 * @desc ${DESCRIPTION}
 **/
public class MapFor {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        java.util.Collections.addAll(list1, "a", "b", "c");
        java.util.Collections.addAll(list2, "o", "p", "q");
        java.util.Collections.addAll(list3, "x", "y", "z");
        HashMap<String, List<String>> map = new HashMap<>(16);
        for (Integer i = 0; i < 1000000; i++) {
            map.put(i.toString(), list1);
        }
        long t1 = System.currentTimeMillis();
        for (String key : map.keySet()) {
            System.out.println(key + "->" + map.get(key));
        }
        long t2 = System.currentTimeMillis();
        Iterator<Map.Entry<String, List<String>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, List<String>> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        long t3 = System.currentTimeMillis();
        for (List<String> list : map.values()) {
            System.out.println(list);
        }
        long t4 = System.currentTimeMillis();

        for (Map.Entry<String, List<String>> aa : map.entrySet()) {
            System.out.println(aa.getKey() + "->" + aa.getValue());
        }
        long t5 = System.currentTimeMillis();

        System.out.println("第一种方式耗时：" + (t2 - t1));
        System.out.println("第二种方式耗时：" + (t3 - t2));
        System.out.println("第三种方式耗时：" + (t4 - t3));
        System.out.println("第四种方式耗时：" + (t5 - t4));
        /*第一种方式耗时：4840
        第二种方式耗时：4299
        第三种方式耗时：3786
        第四种方式耗时：4243*/



//        map.forEach(e -> {
//            System.out.println(e);
//        });
    }

}