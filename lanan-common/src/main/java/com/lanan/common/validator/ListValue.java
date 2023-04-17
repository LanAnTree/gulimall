package com.lanan.common.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author LanAn
 * @date 2022/7/5-14:18
 */
@Documented
@Constraint(validatedBy = {})
@Target({
        ElementType.METHOD,
        ElementType.FIELD,
        ElementType.ANNOTATION_TYPE,
        ElementType.CONSTRUCTOR,
        ElementType.PARAMETER,
        ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ListValue {
    /**
     * TODO: 自定义注解，完成还缺两步：
     *      新建配置文件ValidationMessages.properties保存注解信息
     *      编写一个自定义校验器ListValueConstraintValidator
     **/
    String message() default "{com.lanan.common.validator.valid.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int[] vals() default {};
}
