package com.forezp.thread.nettyRpc;

public interface PersonManage {

    int save(Person p);

    void query(Person p);

    void check();

    boolean checkAge(Person p);
}
