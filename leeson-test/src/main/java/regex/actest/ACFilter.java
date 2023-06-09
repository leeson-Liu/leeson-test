package regex.actest;

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
    public boolean filter(String word) {
        if (StringUtils.isEmpty(word)) {
            return false;
        }
        char[] words = word.toLowerCase().toCharArray();
        Node curNode = tree.getRootNode();
        Node subNode;
        Character c;
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
                return true;
            }
        }
        return false;
    }

}