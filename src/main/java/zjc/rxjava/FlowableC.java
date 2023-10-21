package zjc.rxjava;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;

import java.util.Arrays;
import java.util.List;

public class FlowableC {
    public void flowable01() {
        Flowable<String> flowable = Flowable.create(emitter -> {
            emitter.onNext("Hello");
            emitter.onNext("World");
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER);
    }

    public void flowable02() {
        Flowable<Integer> flowable = Flowable.just(1, 2, 3, 4, 5);
    }

    public void flowable03() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        Flowable<String> flowable = Flowable.fromIterable(names);
    }

    public void flowable04() {

    }
}
