public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("We are in thread " + Thread.currentThread().getName());
            throw new RuntimeException("Intentional Exception");
        });

        // setting thread name
        thread.setName("New Worker thread");

        // setting thread priority
        thread.setPriority(Thread.MAX_PRIORITY);

        // catching exception on the thread
        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("A critical error has been occured " + e.getMessage() + "thread name -> " + t.getName());
        });

        // start the thread
        System.out.println("We are in thread " + Thread.currentThread().getName() + "before start");
        thread.start();
        System.out.println("We are in thread " + Thread.currentThread().getName() + "after start");
    }
}