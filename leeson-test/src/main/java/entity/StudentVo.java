package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liubin
 * @create 2019-01-17 11:19
 * @desc ${DESCRIPTION}
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentVo {

    private String name;
    private String className;
    private Integer age;
    private Integer sex;

}
