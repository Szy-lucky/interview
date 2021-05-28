package com;
/**
 * @PackageName: com
 * @ClassName: Product
 * @Description:
 * @author:
 * @date: 2021/4/24 16:15
 */
class Product {
    private String lock;

    public Product(String lock) {
        super();
        this.lock = lock;
    }
    public void setValue(){
        try {
            synchronized (lock) {
                if(!"".equals(StringObject.value)){
                    //有值，不生产
                    lock.wait();
                }
                String  value = System.currentTimeMillis()+""+System.nanoTime();
                System.out.println("set的值是："+value);
                StringObject.value = value;
                lock.notify();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer {
    private String lock;

    public Consumer(String lock) {
        super();
        this.lock = lock;
    }
    public void getValue(){
        try {
            synchronized (lock) {
                if("".equals(StringObject.value)){
                    //没值，不进行消费
                    lock.wait();
                }
                System.out.println("get的值是："+StringObject.value);
                StringObject.value = "";
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadProduct extends Thread{
    private Product product;

    public ThreadProduct(Product product) {
        super();
        this.product = product;
    }
    @Override
    public void run() {
        //死循环，不断的生产
        while(true){
            product.setValue();
        }
    }

}

class ThreadConsumer extends Thread{
    private Consumer consumer;

    public ThreadConsumer(Consumer consumer) {
        super();
        this.consumer = consumer;
    }
    @Override
    public void run() {
        //死循环，不断的消费
        while(true){
            consumer.getValue();
        }
    }

}
/**
 * @PackageName: com
 * @ClassName: Test2
 * @Description:
 * @author:
 * @date: 2021/4/24 16:15
 */
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        String lock = new String("");
        Product product = new Product(lock);
        Consumer consumer = new Consumer(lock);
        ThreadProduct pThread = new ThreadProduct(product);
        ThreadConsumer cThread = new ThreadConsumer(consumer);
        pThread.start();
        cThread.start();
    }

}

class StringObject{
    public static String value = "";
}