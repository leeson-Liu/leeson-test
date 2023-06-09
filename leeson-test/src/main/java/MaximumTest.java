import java.util.ArrayList;
import java.util.List;

/**
 * @author liubin
 * @create 2019-02-12 15:41
 * @desc ${DESCRIPTION}
 **/
public class MaximumTest {
    public static void main(String[] args) {

        Box<String> name = new Box<String>("corn");
        System.out.println("name:" + name.getData());
    }

}

class Box<T> {

    private T data;

    public Box() {

    }

    public Box(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}