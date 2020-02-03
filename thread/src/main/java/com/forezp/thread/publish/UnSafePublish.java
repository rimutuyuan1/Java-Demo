package com.forezp.thread.publish;

import com.forezp.thread.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@NotThreadSafe
public class UnSafePublish {

    private String[] params = {"a", "b", "c"};

    public String[] getParam() {
        return params;
    }

    public static void main(String[] args) {
        UnSafePublish unSafePublish = new UnSafePublish();
        log.info("params are {}", Arrays.toString(unSafePublish.getParam()));

        unSafePublish.getParam()[0] = "d";
        log.info("params are {}", Arrays.toString(unSafePublish.getParam()));
    }
}
