package com.springboot.base.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationEvent;

/**
 * <p>
 *     自定义事件，继承ApplicationEvent
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/23 23:35
 */
@Data
public class DemoEvent extends ApplicationEvent {

    private String msg;

    public DemoEvent(Object source,String msg){
        super(source);
        this.source = source;
        this.msg = msg;
    }
}
