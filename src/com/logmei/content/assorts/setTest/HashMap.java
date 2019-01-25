package com.logmei.content.assorts.setTest;


public class HashMap<K,V>  {
    /**
     * 默认初始值在内存中存储一份即可，所以定义为static
     *
     * 为什么一定要是2的幂呢？
     * 取实际存储位置时是用key.hashCode()&（Length-1）;确保位置不会超出table的长度
     */
    //初始容量值 16
    static final int DEFAULT_INIT_CAPACITY=1<<4;
    //最大容量值2的30次幂
    static final int DEFAULT_MAX_CAPACITY=1<<30;

    /**
     * 因子越大，table利用率越高，冲突越大
     * 因子越小，table利用率越低空间利用率低，冲突越小
     * 为达到平衡选择根据泊松分布选择0.75
     */
    //负载因子
    static final float DEFAULT_LOAD_FACTOR=0.75f;


    /**
     * 为减小系统开销将高位降低
     * @param key
     * @return
     */
    static final int hash(Object key){
        int h;
        return key==null?0:(h=key.hashCode())^h>>>16;
    }

    final float loadFactor;//构造函数时赋值后不可修改
    int threshold;

    /**
     * 根据参数获取2的幂的最小值
     * @param capacity
     * @return
     */
    public int tableSizeFor (int capacity) {
        int n = capacity-1;//减1，因为要对n进行2次幂移位操作，保证低位为1
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        //正好移位31个
        return (n<0) ? n = 1 : (n >= DEFAULT_MAX_CAPACITY) ? n = DEFAULT_MAX_CAPACITY : n + 1;

    }

    /**
     * 初始化
     * @param initCapacity
     * @param loadFactor
     */
    public HashMap(int initCapacity,float loadFactor){
        if(initCapacity<0)
            throw new IllegalArgumentException("Illegal init capacity "+initCapacity);
        if(initCapacity>DEFAULT_MAX_CAPACITY)
            initCapacity=DEFAULT_MAX_CAPACITY;
        if(loadFactor<=0||Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal loadFactor "+loadFactor);
        this.loadFactor=loadFactor;
        this.threshold=tableSizeFor(initCapacity);

    }

    public HashMap(int initCapacity){
        this(initCapacity,DEFAULT_LOAD_FACTOR);
    }

    public HashMap(){
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }







}
