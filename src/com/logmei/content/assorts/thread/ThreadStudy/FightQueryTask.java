package com.logmei.content.assorts.thread.ThreadStudy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class FightQueryTask extends Thread implements FightQuery {

    private final String origin;
    private final String destination;
    private final List<String> flightList = new ArrayList<String>();

    public FightQueryTask(String airLine, String origin, String destination) {
        super("【"+airLine+"】");
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public List<String> get() {
        return this.flightList;
    }

    @Override
    public void run() {

        System.out.format("%s-query from %s to %s \n",this.currentThread().getName(),origin,destination);
        int randomVal = ThreadLocalRandom.current().nextInt(10);

        try {
            TimeUnit.SECONDS.sleep(randomVal);
            this.flightList.add(getName()+ "-" +randomVal);
            System.out.format("The fight:$s list query successful\n",this.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
