package entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author liubin
 * @create 2019-01-17 11:26
 * @desc ${DESCRIPTION}
 **/
@Data
@Builder
public class ClassVo {

    private String className;
    private List<StudentVo> studentVos;

}
