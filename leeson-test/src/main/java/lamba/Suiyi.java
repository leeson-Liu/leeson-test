package lamba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * @author liubin
 * @create 2019-08-02 16:33
 * @desc ${DESCRIPTION}
 **/
public class Suiyi {
    public static void main(String[] args) {
        String[] ss = new String[]{"q", "w","e","r","t","y"};
        Arrays.stream(ss).map(v -> v + "a").collect(Collectors.toList());
        System.out.println(ss);


        List<String> sss = new ArrayList<>();
        sss.add("q");
        sss.add("w");
        sss.add("e");
        sss.add("r");
         sss.stream().map(v -> v + "a").collect(Collectors.toList());

        System.out.println(sss);

    }
}
