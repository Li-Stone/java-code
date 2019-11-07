package com.stone.threads;

/**
 * 手动死锁实现
 *
 * @author Li-Stone
 */
public class DeadLock {
    private static final Object RESOURCE_A = new Object();
    private static final Object RESOURCE_B = new Object();

    public static void main(String[] args) {
        try {
            deadLock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void deadLock() throws InterruptedException {
        ThreadA t1 = new ThreadA("A");
        ThreadB t2 = new ThreadB("B");
        t1.start();
        Thread.sleep(1000);
        t2.start();
    }


    /**
     * 线程A 先获取资源A  再获取资源B
     */
    static class ThreadA extends Thread {
        private String name;

        public ThreadA(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (RESOURCE_A) {
                System.out.println(this.getName() + ":already get resourceB!");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.getName() + ":waiting get resourceB!");
                synchronized (RESOURCE_B) {

                }

            }
        }
    }

    /**
     * 线程B 先获取资源B  再获取资源A
     */
    static class ThreadB extends Thread {

        private String name;

        public ThreadB(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (RESOURCE_B) {
                System.out.println(this.getName() + ":already get resourceB!");
                System.out.println(this.getName() + ":waiting get resourceA!");
                synchronized (RESOURCE_A) {

                }

            }
        }
    }

}
