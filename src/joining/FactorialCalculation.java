package joining;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FactorialCalculation {
    public static void main(String[] args) throws InterruptedException {
        List<Long> inputNumbers = Arrays.asList(0L,3435L,35435L,2324L,23L);
        List<FactorialThread> threads = new ArrayList<>();

        for(long inputNumber: inputNumbers) {
            threads.add(new FactorialThread(inputNumber));
        }

        for (Thread thread: threads) {
            thread.start();
        }

        for(Thread thread: threads) {
            thread.join();
        }

        for(int i=0; i<inputNumbers.size(); i++) {
            FactorialThread factorialThread = threads.get(i);
            if(factorialThread.isFinished()) {
                System.out.println("Factorial of "+ inputNumbers.get(i)+" is "+ factorialThread.getResult());
            } else {
                System.out.println("The calculation for "+ inputNumbers.get(i)+" is still in progress");
            }
        }
    }

    public static class FactorialThread extends Thread {
        private long input;
        private BigInteger result = BigInteger.ZERO;
        private boolean isFinished = false;

        public FactorialThread(long inputNumber) {
            this.input = inputNumber;
        }

        @Override
        public void run() {
            this.result = factorial(input);
            this.isFinished = true;
        }

        public BigInteger factorial(long number) {
            BigInteger tempResult = BigInteger.ONE;

            for(long i = number; i > 0; i--) {
                tempResult = tempResult.multiply(BigInteger.valueOf(i));
            }

            return tempResult;
        }

        public boolean isFinished() {
            return isFinished;
        }

        public BigInteger getResult() {
            return result;
        }
    }
}
