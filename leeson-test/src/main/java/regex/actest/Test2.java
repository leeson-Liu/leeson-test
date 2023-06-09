//package regex.actest;
//
//import com.google.common.collect.Lists;
//import com.google.common.io.Files;
//import com.hankcs.algorithm.AhoCorasickDoubleArrayTrie;
//import org.springframework.util.CollectionUtils;
//import org.springframework.util.StringUtils;
//import regex.aaa.RegexPro;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.util.*;
//import java.util.concurrent.atomic.AtomicReference;
//import java.util.regex.Pattern;
//
///**
// * @author liubin
// * @create 2020-08-27 16:19
// * @desc
// **/
//
//public class Test2 {
//
//    public static final Pattern pattern = Pattern.compile("[0-9]+");
//
//    public static void main(String[] args) throws IOException {
//
//
////        List<String> msgList = readMsgTxt();
//        List<String> msgList = Lists.newArrayList("您的验证码为123456，请尽快使用");
//        for (String msg : msgList) {
//            if (filter(msg)) {
//                System.out.println(msg);
//            }
//        }
//
//    }
//
//    public static AhoCorasickDoubleArrayTrie<String> buildTree() throws IOException {
//        List<String> sqlStringList = Lists.newArrayList("您的验证码为#code#，请尽快使用");
//
//        TreeMap<String, String> treeMap = new TreeMap<>();
//        int id = 1;
//        for (String sqlString : sqlStringList) {
//            String[] splitList = sqlString.split("#[a-z]+#");
//            for (int i = 0; i < splitList.length; i++) {
//                treeMap.put((i + 1) + "," + splitList.length + "|" + id, splitList[i]);
//            }
//            id++;
//        }
//
//        AhoCorasickDoubleArrayTrie<String> acTree = new AhoCorasickDoubleArrayTrie<>();
//        acTree.build(treeMap);
//        return acTree;
//    }
//
//
//    public static boolean filter(String msg) throws IOException {
//        AtomicReference<Integer> sum = new AtomicReference<>(-1);
//        AtomicReference<Long> id = new AtomicReference<>(-1L);
//        boolean result = false;
//        AhoCorasickDoubleArrayTrie<String> acTree = buildTree();
//        final List<String> keyResult = new ArrayList<>();
//        acTree.parseText(msg, (begin, end,key, value) -> {
//            boolean proceed = true;
//            String[] a = value.split(",|\\|");
//            if (sum.get() == -1) {
//                sum.set(Integer.valueOf(a[1]));
//                id.set(Long.valueOf(a[2]));
//            }
//            Integer subNow = Integer.valueOf(a[0]);
//            Long idNow = Long.valueOf(a[2]);
//            if ((subNow == keyResult.size() + 1) && idNow.equals(id.get())) {
//                keyResult.add(value);
//            } else {
//                keyResult.clear();
//                sum.set(-1);
//            }
//            System.out.println(keyResult.size());
//            if (keyResult.size() == sum.get()) {
//                proceed = false;
//                System.out.println("id:" + a[2]);
//            }
//            return proceed;
//        });
//        if (!CollectionUtils.isEmpty(keyResult) && (keyResult.size() == sum.get())) {
//            result = true;
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