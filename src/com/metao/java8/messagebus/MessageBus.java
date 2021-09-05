package com.metao.java8.messagebus;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MessageBus {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        DataReader<Object> intDataReader = new IntegerDataReader() {
            @Override
            String getName() {
                return Thread.currentThread().getName();
            }

            @Override
            public void onReadSource(Object in) {
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

        ProducerEventHandler<String, Object> producer = new ProducerEventHandler<>(dataHandler) {
            @Override
            String convert(Object data) {
                try {
                    if (data instanceof String) {
                        String s = (String) data;
                        return s;
                    } else if (data instanceof Integer) {
                        return data.toString();
                    } else {
                        throw new ClassCastException("can't find class to deserialize");
                    }
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
        producer.addMessageReader(stringDataReader);

        consumer.addConsumer(s -> System.out.println("read message:" + s));

        executorService.scheduleAtFixedRate(producer, 0, 1L, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(consumer, 0, 1L, TimeUnit.SECONDS);

        executorService.awaitTermination(10, TimeUnit.SECONDS);
        producer.cancel();
        executorService.shutdown();
    }

}