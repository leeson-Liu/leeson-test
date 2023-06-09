package regex;

import com.google.common.io.Files;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author liubin
 * @create 2020-08-26 9:13
 * @desc
 **/
public class BigNumStringRegex {

    public static void main(String[] args) throws IOException {
//        writeTxt();
//        writeMsgTxt();
        List<String> sqlString = readTxt();
        List<String> regexList = buildRegexList(sqlString);
        List<String> msgList = readMsgTxt();
//        way1(regexList, msgList);

        Long t1 = System.currentTimeMillis();
        way2(regexList, msgList);
        Long t2 = System.currentTimeMillis();
        System.out.println("way2 cost time:" + (t2 - t1));

    }

    //传统双层for循环
    public static void way1(List<String> regexList, List<String> msgList) {
        Long t1 = System.currentTimeMillis();
        search(regexList, msgList);
        Long t2 = System.currentTimeMillis();
        System.out.println("way1 cost time:" + (t2 - t1));
    }

    //超长正则
    public static boolean way2(List<String> regexList, List<String> msgList) {
        boolean result = false;
        StringBuffer regexLong = new StringBuffer();
        for (String regex : regexList) {
            regexLong.append(regex).append("|");
        }
        String re = regexLong.toString();
        re = re.substring(0, re.length() - 1);
        Pattern pattern = Pattern.compile(re);
        int time = 0;
        for (String msg : msgList) {
            Matcher matcher = pattern.matcher(msg);
            if (matcher.find()) {
                result = true;
                System.out.println(msg + "次数：" + time);
                break;
            }
            time++;
        }
        return result;
    }


    public static void search(List<String> regexList, List<String> msgList) {

        for (String msg : msgList) {
            int time = 0;
            boolean result = false;
            for (String regex : regexList) {
                time++;
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(msg);
                if (matcher.find()) {
                    result = true;
                    break;
                }
            }
            if (result) {
                System.out.println("成功的：" + msg + "，次数：" + time);
            }
        }

    }


    public static List<String> buildRegexList(List<String> sqlList) {
        List<String> result = new ArrayList<>();
        String qian = "^";
        String hou = "$";
        for (String s : sqlList) {
            StringBuffer sb = new StringBuffer(qian);
            String[] splitList = s.split("#[a-z]+#");
            if (splitList.length > 1) {
                for (int i = 0; i < splitList.length; i++) {
                    sb.append(splitList[i]);
                    if (i < splitList.length - 1) {
                        sb.append(".+");
                    } else {
                        sb.append(hou);
                    }
                }
                result.add(sb.toString());
            } else {
                result.add(s);
            }
        }
        return result;
    }

    //-----------------数据准备---------------------------------
    public static List<String> readTxt() throws IOException {
        File file = new File("C:\\aaa\\sqlStringList.txt");
        return Files.readLines(file, StandardCharsets.UTF_8);
    }

    public static List<String> readMsgTxt() throws IOException {
        File file = new File("C:\\aaa\\msg.txt");
        return Files.readLines(file, StandardCharsets.UTF_8);
    }

    public static void writeMsgTxt() {
        List<String> list = buildMsgList();
        File targetFile = new File("C:\\aaa\\msg.txt");
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(targetFile, true))) {
            for (String line : list) {
                line = line.substring(0, line.length() - 1);
                byte[] content = line.getBytes(StandardCharsets.UTF_8);
                outputStream.write(content);
                outputStream.write((byte) 0x0A);
            }
        } catch (IOException e) {
            throw new RuntimeException("write txt failed," + e.getMessage());
        }

    }

    public static void writeTxt() {
        List<String> list = buildList();
        File targetFile = new File("C:\\aaa\\sqlStringList.txt");
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(targetFile, true))) {
            for (String line : list) {
                line = line.substring(0, line.length() - 1);
                byte[] content = line.getBytes(StandardCharsets.UTF_8);
                outputStream.write(content);
                outputStream.write((byte) 0x0A);
            }
        } catch (IOException e) {
            throw new RuntimeException("write txt failed," + e.getMessage());
        }
    }

    public static List<String> buildList() {
        List<String> result = new ArrayList<>();
        StringBuilder content;
        result.add("您的验证码为:#code#, 请在五分钟之内使用");
        for (int j = 0; j < 10000; j++) {
            content = new StringBuilder(getRandomChar() + "您的验证码");
            for (int i = 0; i < 10; i++) {
                content.append(getRandomChar());
            }
            content.append("#code#, 请尽快使用");
            result.add(content.toString());
        }
        //hash排序
        return result.stream().sorted().collect(Collectors.toList());
    }

    public static List<String> buildMsgList() {
        List<String> result = new ArrayList<>();
        StringBuilder content;
        result.add("您的验证码为:#code#, 请在五分钟之内使用");
        for (int j = 0; j < 10000; j++) {
            content = new StringBuilder(getRandomChar() + "您的验证码");
            for (int i = 0; i < 20; i++) {
                content.append(getRandomChar());
            }
            result.add(content.toString());
        }
        //hash排序
        return result.stream().sorted().collect(Collectors.toList());
    }


    private static char getRandomChar() {
        String str = "";
        int highPos;
        int lowPos;
        Random random = new Random();
        highPos = (176 + Math.abs(random.nextInt(39)));
        lowPos = (161 + Math.abs(random.nextInt(93)));
        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(highPos)).byteValue();
        b[1] = (Integer.valueOf(lowPos)).byteValue();
        try {
            str = new String(b, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("错误");
        }
        return str.charAt(0);
    }
}
