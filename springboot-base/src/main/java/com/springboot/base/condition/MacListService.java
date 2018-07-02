package com.springboot.base.condition;

/**
 * <p></p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/24 15:01
 */
public class MacListService implements ListService{
    @Override
    public String showListCmd() {
        return "mac:ll";
    }
}
