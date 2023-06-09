package annotation;

/**
 * @author liubin
 * @create 2019-02-22 10:24
 * @desc ${DESCRIPTION}
 **/
@Yts(classType = Yts.YtsType.util)
public class SayHell {

    public static void main(String[] args){
        SayHell annotation = new SayHell();
        System.out.println(Yts.class.getAnnotations());
        System.out.println(Yts.class.getName());
        System.out.println(Yts.class.getMethods());

    }


    @HelloWorld(name = " 小明 ")
    @Yts
    public void sayHello(String name){
        if(name == null || name.equals("")){
            System.out.println("hello world!");
        }else{
            System.out.println(name + "say hello world!");
        }
    }
}