public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("We are in thread" + Thread.currentThread().getName());
        });

        // start the thread
        System.out.println("We are in thread " + Thread.currentThread().getName() + "before start");
        thread.start();
        System.out.println("We are in thread " + Thread.currentThread().getName() + "after start");
    }
}