package com.logmei.content.assorts.thread.waitnotify;

import java.util.LinkedList;

public class EventQueue {

    private final int max;
    static class Event{

    }

    private final LinkedList<Event> eventQueue = new LinkedList<Event>();

    private final static int DEFAULT_MAX_EVENT = 10;

    public EventQueue (){
        this(DEFAULT_MAX_EVENT);
    }
    public EventQueue (int max){
        this.max = max ;
    }
    public static int offerIndex = 0;
    public  void offer(Event event) {

        synchronized (eventQueue) {
            offerIndex++;
            while (eventQueue.size() >= max) {
                try {
                    console("offerIndex "+offerIndex+"eventQueue size :" + eventQueue.size() + ";is full");
                    event.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            eventQueue.addLast(event);
            console("offerIndex " + offerIndex +"the new event is submitted");
            eventQueue.notifyAll();
        }
    }
    public static int takeIndex = 0;
    public  Event take(){


        synchronized (eventQueue) {
            takeIndex++;
            while (eventQueue.isEmpty()) {
                try {
                    console("takeIndex "+takeIndex+" the queue is empty.");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Event event = eventQueue.removeFirst();
            console("takeIndex "+takeIndex+" the event " + event + " is handled. ");
            eventQueue.notifyAll();

            return event;
        }
    }

    private void console(String message){
        System.out.format("%s:%s\n",Thread.currentThread().getName(),message);
    }

}
