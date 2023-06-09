package annotation;

import entity.StudentVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liubin
 * @create 2019-02-20 21:39
 * @desc ${DESCRIPTION}
 **/
public class Annotation {

    public static void main(String[] args){
        Class a = StudentVo.class;
        System.out.println(a.getAnnotations());
        System.out.println(a.getMethods());
        System.out.println(a.getName());
        System.out.println(a.toString());
        Annotation annotation = new Annotation();
        annotation.doSome();
    }

    public void doSome(){
        List list = new ArrayList();
        list.add("some");
        System.out.println(list);
    }


}
