package zjc.rxjava;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;

public class FlowableC {
    public void flowable() {
        Flowable<String> flowable = Flowable.create(emitter -> {
            emitter.onNext("Hello");
            emitter.onNext("World");
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER);
    }
}
