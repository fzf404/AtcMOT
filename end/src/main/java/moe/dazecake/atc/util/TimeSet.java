package moe.dazecake.atc.util;

import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

@Repository
public class TimeSet {

    public HashMap getTimeSet() {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");//设置日期格式
        Date date = new Date();
        Random rand = new Random();
        HashMap<String, Integer> time = new HashMap<>();

        time.put(df.format(date), rand.nextInt(25) + 5);
        date.setTime(date.getTime() - 60000);
        time.put(df.format(date), rand.nextInt(25) + 5);
        date.setTime(date.getTime() - 60000);
        time.put(df.format(date), rand.nextInt(25) + 5);
        date.setTime(date.getTime() - 60000);
        time.put(df.format(date), rand.nextInt(25) + 5);
        date.setTime(date.getTime() - 60000);
        time.put(df.format(date), rand.nextInt(25) + 5);
        date.setTime(date.getTime() - 60000);
        time.put(df.format(date), rand.nextInt(25) + 5);

        return time;
    }
}
