package interruoption;

public class ThreadInteruption {
    public static void main(String[] args) {
        Thread thread = new Thread(new BlockingTask());
        thread.start();
        thread.interrupt();
    }

    private static class BlockingTask implements Runnable {
        @Override
        public void run() {
          try {
              Thread.sleep(5000000);
          } catch (InterruptedException e) {
              System.out.println("Exiting the blocking thread");
          }
        }
    }
}
