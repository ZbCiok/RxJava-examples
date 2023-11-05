package zjc.examples.rxjava.basicGuide;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;

public class Example1 {
    public static void main(String[] args) {
        //producer
        Observable<String> observable = Observable.just("Welcome", "to", "RxJava", "example1");

        // consumer
        Consumer<? super String> consumer = System.out::println;

        //attaching producer to consumer
        observable.subscribe(consumer);
    }
}
