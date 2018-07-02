package com.springboot.base.condition;

/**
 * <p></p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/24 15:02
 */
public class LinuxListSerivce implements ListService{
    @Override
    public String showListCmd() {
        return "linux:ll";
    }
}
