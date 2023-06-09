package regex.ac;

/**
 * @author liubin
 * @create 2020-08-27 14:44
 * @desc
 **/
public class WordFilterTest {

    public static void main(String[] args) {
        String[] keyWords = new String[] { "he", "hers", "his", "erase" };
        ACTree tree = new ACTree(keyWords);
        ACFilter filter = new ACFilter(tree);
        String str = "aaaaaaaaahebbc";
        str = filter.filter(str);
        System.out.println(str);
    }
}