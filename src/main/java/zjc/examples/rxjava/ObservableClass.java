package zjc.examples.rxjava;


import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ObservableClass {

    // Observable.just
    public void just01() {
        Observable<String> observable = Observable.just("Hello, world");
        observable.subscribe(System.out::println);
    }

    // Observable.fromIterable
    public void fromIterable02() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

        Observable<Integer> observable = Observable.fromIterable(list);

        observable.subscribe(item -> System.out.println(item), error -> error.printStackTrace(),
                () -> System.out.println("Done"));
    }

    // Observable.fromArray
    public void fromArray03() {
        Integer[] array = new Integer[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        Observable<Integer> observable = Observable.fromArray(array);

        observable.subscribe(item -> System.out.println(item), error -> error.printStackTrace(),
                () -> System.out.println("Done"));
    }

    // Observable.fromCallable
    public void fromCallable04() {
        Callable<String> callable = () -> {
            System.out.println("Hello World!");
            return "Hello World!";
        };

        Observable<String> observable = Observable.fromCallable(callable);

        observable.subscribe(item -> System.out.println(item), error -> error.printStackTrace(),
                () -> System.out.println("Done"));
    }

    // Observable.fromFuture
    public void fromFuture05() {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        Future<String> future = executor.schedule(() -> "Hello world!", 1, TimeUnit.SECONDS);

        Observable<String> observable = Observable.fromFuture(future);

        observable.subscribe(
                item -> System.out.println(item),
                error -> error.printStackTrace(),
                () -> System.out.println("Done"));

        executor.shutdown();
    }

    // Observable.create
    public void create06() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        ObservableOnSubscribe<String> handler = emitter -> {

            Future<Object> future = executor.schedule(() -> {
                emitter.onNext("Hello");
                emitter.onNext("World");
                emitter.onComplete();
                return null;
            }, 1, TimeUnit.SECONDS);

            emitter.setCancellable(() -> future.cancel(false));
        };
        Observable<String> observable = Observable.create(handler);
        observable.subscribe(item -> System.out.println(item), error -> error.printStackTrace(),
                () -> System.out.println("Done"));
        Thread.sleep(2000);
        executor.shutdown();
    }

    // Observable.defer
    public void create07() throws InterruptedException {
        Observable<Long> observable = Observable.defer(() -> {
            long time = System.currentTimeMillis();
            return Observable.just(time);
        });
        observable.subscribe(time -> System.out.println(time));
        Thread.sleep(1000);
        observable.subscribe(time -> System.out.println(time));
    }

    // Observable.range
    public void create08() {
        String greeting = "Hello World!";

        Observable<Integer> indexes = Observable.range(0, greeting.length());

        Observable<Character> characters = indexes
                .map(index -> greeting.charAt(index));

        characters.subscribe(character -> System.out.print(character), error -> error.printStackTrace(),
                () -> System.out.println());
    }

    // Observable.interval
    public void create09() {
        Observable<Long> clock = Observable.interval(1, TimeUnit.SECONDS);

        clock.subscribe(time -> {
            if (time % 2 == 0) {
                System.out.println("Tick");
            } else {
                System.out.println("Tock");
            }
        });
    }
}
