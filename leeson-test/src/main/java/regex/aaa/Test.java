//package regex.aaa;
//
//import com.google.common.collect.Lists;
//import com.google.common.io.Files;
//import com.hankcs.algorithm.AhoCorasickDoubleArrayTrie;
//import org.springframework.util.CollectionUtils;
//import org.springframework.util.StringUtils;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.util.*;
//import java.util.concurrent.atomic.AtomicReference;
//
///**
// * @author liubin
// * @create 2020-08-27 16:19
// * @desc
// **/
//
//public class Test {
//
//
//    public static void main(String[] args) throws IOException {
//
//
//        List<String> msgList = readMsgTxt();
//        long t = System.currentTimeMillis();
//        for (String msg : msgList) {
//            if (filter(msg)) {
//                System.out.println(msg);
//            }
//        }
//        long t2 = System.currentTimeMillis();
//        System.out.println("filter cost time :" + (t2 - t));
//    }
//
//    public static AhoCorasickDoubleArrayTrie<String> buildTree() throws IOException {
//        List<String> sqlStringList = readTxt();
//        long t1 = System.currentTimeMillis();
//        TreeMap<String, String> treeMap = new TreeMap<>();
//        int id = 1;
//        for (String sqlString : sqlStringList) {
//            String[] splitList = sqlString.split("#[a-z]+#");
//            for (int i = 0; i < splitList.length; i++) {
//                if (StringUtils.isEmpty(treeMap.get(splitList[i]))) {
//                    treeMap.put(splitList[i], (i + 1) + "," + splitList.length + "," + id);
//                } else {
//                    treeMap.put(splitList[i], treeMap.get(splitList[i]) + "|" + (i + 1) + "," + splitList.length + "," + id);
//                }
//            }
//            id++;
//        }
//        long t2 = System.currentTimeMillis();
//        System.out.println("filter cost time :" + (t2 - t1));
//        AhoCorasickDoubleArrayTrie<String> acTree = new AhoCorasickDoubleArrayTrie<>();
//        acTree.build(treeMap);
//        long t3 = System.currentTimeMillis();
//        System.out.println("add tree :" + (t3 - t2));
//        return acTree;
//    }
//
//
//    public static boolean filter(String msg) throws IOException {
//        boolean result = false;
//        AhoCorasickDoubleArrayTrie<String> acTree = buildTree();
//        final List<String> keyResult = new ArrayList<>();
//        acTree.parseText(msg, (begin, end, value) -> {
//            //(1,1,*)直接跳出   value: 1,3,id|2,3,id|3,3,id
//            String[] splitList = value.split("|");
//            keyResult.addAll(Arrays.asList(splitList));
//            return true;
//        });
//
//
//        if (!CollectionUtils.isEmpty(keyResult)) {
//            result = true;
//        } else {
//            Map<Integer, List<RegexPro>> map = new HashMap<>();
//            for (String s : keyResult) {
//                String[] aa = s.split(",");
//                RegexPro r = new RegexPro();
//                r.setNow(Integer.valueOf(aa[0]));
//                r.setMax(Integer.valueOf(aa[1]));
//                r.setId(Long.valueOf(aa[2]));
//                if (CollectionUtils.isEmpty(map.get(r.getNow()))) {
//                    map.put(r.getNow(), Lists.newArrayList(r));
//                } else {
//                    List<RegexPro> list = map.get(r.getNow());
//                    list.add(r);
//                    map.put(r.getNow(), list);
//                }
//            }
//            //寻找最小的map value
////            Integer minMap =
////            for(map){
////
////            }
//
//
//        }
//        return result;
//    }
//
//
//    public static List<String> readTxt() throws IOException {
//        File file = new File("C:\\aaa\\sqlStringList.txt");
//        return Files.readLines(file, StandardCharsets.UTF_8);
//    }
//
//    public static List<String> readMsgTxt() throws IOException {
//        File file = new File("C:\\aaa\\msg.txt");
//        return Files.readLines(file, StandardCharsets.UTF_8);
//    }
//
//}
