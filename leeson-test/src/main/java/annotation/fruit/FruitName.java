package annotation.fruit;

import java.lang.annotation.*;

/**
 * @author liubin
 * @create 2019-02-22 17:42
 * @desc ${DESCRIPTION}
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}
