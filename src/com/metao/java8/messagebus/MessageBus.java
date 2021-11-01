package com.metao.java8.messagebus;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class MessageBus {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        DataReader<Integer> intDataReader = new IntegerDataReader() {
            private Integer random = Integer.parseInt("0");

            @Override
            protected Integer readInteger() {
                return random++;
            }

            @Override
            String getName() {
                return Thread.currentThread().getName();
            }

            @Override
            public void onReadSource(Integer in) {
                System.out.println(getName() + ", ack read int:" + in);
            }
        };
        DataReader<Object> stringDataReader = new StringDataReader() {
            @Override
            String getName() {
                return Thread.currentThread().getName();
            }

            @Override
            public void onReadSource(Object in) {
                System.out.println(getName() + ", ack read string:" + in);
            }
        };

        DataHandler<String> dataHandler = new DataHandler<>();

        ProducerEventHandler<String, Integer> producer = new ProducerEventHandler<>(dataHandler) {
            @Override
            String convert(Integer data) {
                try {
                    return data.toString();
                } catch (ClassCastException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
        };

        ConsumerEventHandler<String> consumer = new ConsumerEventHandler<>(dataHandler) {

            @Override
            protected void onException(Exception ex) {
                System.out.println("exception while reading message, error:" + ex.getMessage());
            }
        };

        producer.addMessageReader(intDataReader);

        consumer.addConsumer(s -> System.out.println("read message:" + s));
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            producer.run();
            consumer.run();
        }

//        executorService.scheduleAtFixedRate(producer, 0, 0L, TimeUnit.MILLISECONDS);
//        executorService.scheduleAtFixedRate(consumer, 0, 0L, TimeUnit.MILLISECONDS);

        //executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(System.currentTimeMillis() - startTime);
        producer.cancel();
        executorService.shutdown();
    }

}