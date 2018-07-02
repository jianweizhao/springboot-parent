package com.springboot.base.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * <p>
 *     条件类
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/24 14:56
 */
public class MacCondition implements Condition{

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return context.getEnvironment().getProperty("os.name").contains("Mac");
    }
}
