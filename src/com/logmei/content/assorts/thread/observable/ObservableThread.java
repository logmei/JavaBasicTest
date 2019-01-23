package com.logmei.content.assorts.thread.observable;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 10:17 2019/1/22
 * @ Description：任务监控的实现
 * @ Modified By：
 * @Version: 1.0.0
 */
public class ObservableThread<T> extends Thread implements Observable{

    private final TaskLifecycle<T> lifecycle;
    private final Task<T> task;
    private Cycle cycle;

    //指定Task的实现，默认情况下使用EmptyLifecycle
    public ObservableThread(Task<T> task){
        this(new TaskLifecycle.EmptyLifecycle<>(),task);
    }
    //指定TaskLifecycle的同时指定Task
    public ObservableThread(TaskLifecycle<T> lifecycle,Task<T> task){
        super();

        if(task == null)
            throw  new IllegalArgumentException("The task is required");
        this.lifecycle = lifecycle;
        this.task = task;
    }

    @Override
    public final void run() {
        //在执行线程逻辑单元的时候，分别触发相应的事件
        this.update(Cycle.STARTED,null,null);
        try {
            this.update(Cycle.RUNNING,null,null);
            T result = this.task.call();
            this.update(Cycle.DONE,result,null);
        }catch (ObservableException e){
            this.update(Cycle.ERROR,null,e);
        }
    }

    private void update(Cycle cycle,T result,Exception e){
        this.cycle = cycle;
        if(lifecycle == null)return;
        try {
            switch (cycle){
                case STARTED:
                    this.lifecycle.onStart(currentThread());
                    break;
                case RUNNING:
                    this.lifecycle.onRunning(currentThread());
                    break;
                case DONE:
                    this.lifecycle.onFinish(currentThread(),result);
                    break;
                case ERROR:
                    this.lifecycle.onError(currentThread(),e);
                    break;

            }
        }catch (Exception ex){
            if(cycle == Cycle.ERROR){
                throw  ex;
            }
        }
    }
    @Override
    public Cycle getCycle() {
        return this.cycle;
    }
}
