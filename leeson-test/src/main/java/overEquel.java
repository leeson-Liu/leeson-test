import com.google.common.collect.Lists;
import entity.StudentVo;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author liubin
 * @create 2020-01-09 23:11
 * @desc
 **/
public class overEquel {

    public static void main(String[] args) {
        List<String> longMsgIds = Lists.newArrayList("1","2");
        longMsgIds = longMsgIds.stream().map(e -> "abc" + e).collect(Collectors.toList());
        System.out.println(longMsgIds);
    }
}
