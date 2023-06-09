package annotation;

import java.lang.annotation.*;

/**
 * @author liubin
 * @create 2019-02-22 10:22
 * @desc ${DESCRIPTION}
 **/
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Yts {
    public enum YtsType{util,entity,service,model};
    public YtsType classType() default YtsType.util;
}