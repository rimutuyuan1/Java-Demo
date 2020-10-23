package com.forezp.thread.aop;

/**
 * @Author 王鑫涛
 * @Description
 * @Date 2020/9/3 11:27 下午
 **/
public interface IUserInterface {

    @ParamLog
    String query();
}
