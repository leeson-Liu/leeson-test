package tree;

/**
 * @author liubin
 * @create 2021-04-30 16:41
 * @desc
 **/
interface Fruit {
    void eat();
}

class Apple implements Fruit {
    @Override
    public void eat() {
        System.out.println("* 吃苹果 *");
    }
}

class Factory {
    public static Fruit getInstance(String className) {
        if ("apple" == className) {
            return new Apple();
        }
        return null;
    }
}

public class AAA {
    public static void main(String[] args) {
        Fruit f = Factory.getInstance("apple");
        f.eat();
    }
}
