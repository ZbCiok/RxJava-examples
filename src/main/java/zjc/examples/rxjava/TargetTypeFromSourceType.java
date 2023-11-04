package zjc.examples.rxjava;

import io.reactivex.rxjava3.core.Observable;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class TargetTypeFromSourceType {

    // Mono
    public void FromReactiveType01() {
        Mono<Integer> reactorMono = Mono.fromCompletionStage(CompletableFuture.<Integer>completedFuture(1));

        Observable<Integer> observable = Observable.fromPublisher(reactorMono);

        observable.subscribe(
                item -> System.out.println(item),
                error -> error.printStackTrace(),
                () -> System.out.println("Done"));
    }
}
