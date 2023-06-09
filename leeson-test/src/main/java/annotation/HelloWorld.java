package annotation;

import java.lang.annotation.*;

/**
 * @author liubin
 * @create 2019-02-22 10:23
 * @desc ${DESCRIPTION}
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface HelloWorld {
    public String name()default "";
}