package regex;

import com.google.common.base.CharMatcher;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liubin
 * @create 2020-12-09 0:03
 * @desc
 **/
public class RegexFindAndMatch {
    private static final Pattern NUMBER_REGEX = Pattern.compile("^[a-z]*$|^[0-9]*$|^[a-z]*$|");

    public static void main(String[] args) {


        List<String> sqlList = Lists.newArrayList("验证码是+++++：#code#, 请查收#haha#");

        String regexString = buildRegex(sqlList);
        System.out.println(regexString);
        Pattern p = Pattern.compile(regexString);

        System.out.println(p.matcher("验证码是+++++：123456, 请查收123456").find());
    }

    public static String buildRegex(List<String> sqlList) {
        String begin = "^";
        String end = "$";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < sqlList.size(); i++) {
            boolean isHaveCode = sqlList.get(i).matches(".*#[a-z]+#");
            String[] splitList = sqlList.get(i).split("#[a-z]+#");

            sb.append(begin);
            for (int j = 0; j < splitList.length; j++) {
                sb.append(Pattern.quote(splitList[j]));
                if (j < splitList.length - 1) {
                    sb.append(".+");
                } else if (isHaveCode) {
                    sb.append(".+").append(end);
                } else {
                    sb.append(end);
                }
            }
            if (i < sqlList.size() - 1) {
                sb.append("|");
            }
        }

        return sb.toString();
    }
}
