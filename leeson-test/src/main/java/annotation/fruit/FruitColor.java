package annotation.fruit;

import java.lang.annotation.*;

/**
 * @author liubin
 * @create 2019-02-22 17:43
 * @desc ${DESCRIPTION}
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
    /**
     * 颜色枚举
     * @author peida
     *
     */
    public enum Color{ BULE,RED,GREEN};

    /**
     * 颜色属性
     * @return
     */
    Color fruitColor() default Color.GREEN;

}