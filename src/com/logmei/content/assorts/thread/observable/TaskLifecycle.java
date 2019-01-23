package com.logmei.content.assorts.thread.observable;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 9:58 2019/1/22
 * @ Description：获取生命周期的状态
 * @ Modified By：
 * @Version: 1.0.0
 */
public interface TaskLifecycle<T> {
    //当任务开始执行时会被回调的方法
    void onStart(Thread thread);
    //任务运行时被回调的方法
    void onRunning(Thread thread);
    //任务正确执行结束后会被回调
    void onFinish(Thread thread,T result);
    //任务在运行过程中出现任何异常抛出时，onError方法都将被回调，并将异常信息一并传入
    void onError(Thread thread,Exception e);

    //生命周期接口的实现(Adapter)
    class EmptyLifecycle<T> implements TaskLifecycle<T>{
        @Override
        public void onStart(Thread thread) {
          System.out.println(thread.getName()+" onStart");
        }

        @Override
        public void onRunning(Thread thread) {
            System.out.println(thread.getName()+" onRunning");
        }

        @Override
        public void onFinish(Thread thread, T result) {
            System.out.println(thread.getName()+" onFinished");
            System.out.println(thread.getName()+" result:"+result);
        }

        @Override
        public void onError(Thread thread, Exception e) {
            e.printStackTrace();
            System.out.println(thread.getName()+" onError");
        }
    }
}
