## Java Multithreading :tada: :rocket:

### Thread
A thread is the smallest unit of execution, it represents the sequence of instructions that can be run independently within a program
, threads can share same memory space of the process , they belong to , but can execute different part of the program concurrently.



### State of threads
- NEW
- RUNNABLE
- BLOCKED
- WAITING
- TIME_WAITING
- TERMINATED

### Thread creation
There are basically two ways of thread creation , both of them are mentioned below

```java
Thread thread = new Thread(()-> {
    System.out.println("Hello from " + Thread.currentThread().getName());
});
```


```java
public class ThreadCreationTypeTwo {
    public static void main(String[] args) {
        Thread thread = new NewThread();
        thread.start();
    }


    private static class NewThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello from " + this.getName());
        }
    }
}
```