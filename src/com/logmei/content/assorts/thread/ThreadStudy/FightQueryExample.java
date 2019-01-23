package com.logmei.content.assorts.thread.ThreadStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FightQueryExample {
    private static List<String> fightCompany = Arrays.asList("CSA","CEA","HNA");

    public static void main(String[] args){
        List<String> results = search("SH","BJ");
        System.out.println("-----------------------------");
        results.forEach(System.out::println);
    }
    private static List<String> search (String original,String dest){
        final List<String> result = new ArrayList<>();
        //创建查询航班的线程列表
        List<FightQueryTask> tasks = fightCompany.stream().map(f -> (new FightQueryTask(f,original,dest))).collect(Collectors.toList());
        //分别启动线程
        tasks.forEach(Thread::start);
        //分别调用每一个线程的join方法，阻塞当前线程
        tasks.forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //
        tasks.stream().map(FightQuery::get).forEach(result::addAll);
        return result;

    }

    private static FightQueryTask createSearchTask(String company,String original,String dest){
        return new FightQueryTask(company,original,dest);
    }
}
