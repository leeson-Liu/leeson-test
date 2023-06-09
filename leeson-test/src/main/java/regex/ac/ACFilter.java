package regex.ac;

/**
 * @author liubin
 * @create 2020-08-27 14:44
 * @desc
 **/

import org.springframework.util.StringUtils;


public class ACFilter {
    public static final Character REPLACE_CHAR = '*';

    private ACTree tree;

    public ACFilter(ACTree tree) {
        this.tree = tree;
    }

    /**
     * 过滤
     *
     * @param word
     * @return
     */
    public String filter(String word) {
        if (StringUtils.isEmpty(word)) {
            return "";
        }
        char[] words = word.toLowerCase().toCharArray();
        char[] result = null;
        Node curNode = tree.getRootNode();
        Node subNode;
        Character c;
        int fromPos = 0;
        for (int i = 0; i < words.length; i++) {
            c = words[i];
            subNode = curNode.getSubNode(c);
            while (subNode == null && curNode != tree.getRootNode()) {
                curNode = curNode.getFailNode();
                subNode = curNode.getSubNode(c);
            }
            if (subNode != null) {
                curNode = subNode;
            }
            if (curNode.isTerminal()) {
                int pos = i - curNode.getLevel() + 1;
                if (pos < fromPos) {
                    pos = fromPos;
                }
                if (result == null) {
                    result = word.toLowerCase().toCharArray();
                }
                for (; pos <= i; pos++) {
                    result[pos] = REPLACE_CHAR;
                }
                fromPos = i + 1;
            }
        }
        if (result == null) {
            return word;
        }
        return String.valueOf(result);
    }

}