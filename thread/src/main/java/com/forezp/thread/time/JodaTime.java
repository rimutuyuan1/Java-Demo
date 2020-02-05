package com.forezp.thread.time;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

@Slf4j
public class JodaTime {


    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime d3 = DateTime.parse("2016-10-10 11:12:55", formatter);
        log.info("{}", d3);
    }
}
