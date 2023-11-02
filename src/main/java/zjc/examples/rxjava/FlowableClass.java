package zjc.examples.rxjava;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Arrays;
import java.util.List;

public class FlowableClass {
    public void create01() {
        Flowable<String> flowable = Flowable.create(emitter -> {
            emitter.onNext("Hello");
            emitter.onNext("World");
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER);
    }

    public void just02() {
        Flowable<Integer> flowable = Flowable.just(1, 2, 3, 4, 5);
    }

    public void fromIterable03() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        Flowable<String> flowable = Flowable.fromIterable(names);
    }

    public void fromIterable04() {
        Flowable<String> flowable = Flowable.fromIterable(Arrays.asList("one", "three", "two"));
        flowable.subscribe(new Subscriber<String>() {

            @Override
            public void onNext(String item) {
                // Handle the emitted item
                System.out.println(item);
            }

            @Override
            public void onError(Throwable error) {
                // Handle errors
                error.printStackTrace();
            }

            @Override
            public void onComplete() {
                // Handle completion
                System.out.println("Flowable completed");
            }

            @Override
            public void onSubscribe(Subscription subscription) {
                subscription.request(Long.MAX_VALUE); // Request all items
            }

        });
    }
}
