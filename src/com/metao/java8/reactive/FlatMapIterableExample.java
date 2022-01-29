package com.metao.java8.reactive;


import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;

public class FlatMapIterableExample {

    public static void main(String[] args) {

        String s = "string=12&temp=213".chars()
                .flatMap(ch -> ch == '&' ? "&amp".chars() : IntStream.of(ch))
                .collect(StringBuffer::new, StringBuffer::appendCodePoint, StringBuffer::append)
                .toString();
        String s1 = new String(new char[]{'1', '2', '3'});
        System.out.println(s1);
        Checker collect = "String".chars()
                .collect(Checker::new, Checker::appendCodePoint, Checker::check);


        new FlatMapIterableExample()
                .decode(Mono.just(new DataBufferProcessor()))
                .transform(new MessageToStringTransformer())
                .subscribe(System.out::println, new StringMessageErrorConsumer(), new StringMessageConsumerHandler());
    }

    static class Checker {

        void appendCodePoint(int i) {

        }

        public StringBuffer check(Checker sd) {
            return new StringBuffer(sd.toString());
        }

        void check(Checker checker, Checker checker1) {

        }
    }

    interface TestInterface<T, U> {
    }


    private static class StringMessageConsumerHandler implements Runnable {

        @Override
        public void run() {
            System.out.println("finished consuming all messages.");
        }
    }

    private static class StringMessageErrorConsumer implements Consumer<Throwable> {

        @Override
        public void accept(Throwable throwable) {
            System.err.println(throwable.getMessage());
        }
    }

    private static class StringMessageConsumer implements Consumer<String> {

        @Override
        public void accept(String s) {
            System.out.println(s);
        }
    }

    private static class MessageToStringTransformer implements Function<Flux<Message>, Publisher<String>> {

        private Publisher<String> transformToString(Message<String> message) {
            String payload = message.getPayload();
            return Flux.just(payload);
        }


        @Override
        public Publisher<String> apply(Flux<Message> messages) {
            return transformToString(null);
        }
    }

    private static class MessageDecoderFunction implements Function<DataBuffer, Iterable<? extends Message>> {

        @Override
        public Iterable<? extends Message> apply(DataBuffer input) {
            List<Message> messages = new ArrayList<>();
            if (input.isAvailable()) {
                input.readFromQueue().drainTo(messages);
            }

            return messages;
        }

        void terminate() {

        }
    }

    public Flux<Message> decode(Publisher<DataBuffer> inputStream) {
        MessageDecoderFunction decoderFunction = new MessageDecoderFunction();
        return Flux.from(inputStream)
                .flatMapIterable(decoderFunction)
                .doOnTerminate(decoderFunction::terminate);
    }
}