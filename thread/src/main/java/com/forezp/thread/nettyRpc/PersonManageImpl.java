package com.forezp.thread.nettyRpc;

import java.util.concurrent.CompletableFuture;

public class PersonManageImpl implements PersonManage {
    @Override
    public int save(Person p) {
        System.out.println("person data[" + p + "] has save!");
        return 0;
    }

    @Override
    public void query(Person p) {
        System.out.println("Person data[ " + p + " ] has query");
    }

    @Override
    public void check() {
        throw new RuntimeException("person check fail ");
    }

    @Override
    public boolean checkAge(Person p) {
        if (p.getAge() < 18) {
            throw new RuntimeException("person check age fail ");
        } else {
            System.out.println("person check age success ");
            return true;
        }
    }
}
