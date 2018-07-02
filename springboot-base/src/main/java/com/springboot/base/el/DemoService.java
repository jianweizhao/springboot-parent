package com.springboot.base.el;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/23 16:02
 */
@Service
@Data
public class DemoService {
    @Value("其他类的属性")
    private String other;
}
