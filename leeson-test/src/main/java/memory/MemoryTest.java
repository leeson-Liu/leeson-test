package memory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.instrument.Instrumentation;

import static jdk.nashorn.internal.ir.debug.ObjectSizeCalculator.getObjectSize;

/**
 * @author liubin
 * @create 2020-09-07 10:06
 * @desc
 **/
public class MemoryTest {

    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i + "");
        }
       long a = getObjectSize(list);
        System.out.println(a);
    }

}
