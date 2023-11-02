package zjc.examples.rxjava;


import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ObservableClass {

    public void just01() {
        Observable<String> observable = Observable.just("Hello, world");
        observable.subscribe(System.out::println);
    }

    public void fromIterable02() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

        Observable<Integer> observable = Observable.fromIterable(list);

        observable.subscribe(item -> System.out.println(item), error -> error.printStackTrace(),
                () -> System.out.println("Done"));
    }

    public void fromArray03() {
        Integer[] array = new Integer[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        Observable<Integer> observable = Observable.fromArray(array);

        observable.subscribe(item -> System.out.println(item), error -> error.printStackTrace(),
                () -> System.out.println("Done"));
    }

    public void fromCallable04() {
        Callable<String> callable = () -> {
            System.out.println("Hello World!");
            return "Hello World!";
        };

        Observable<String> observable = Observable.fromCallable(callable);

        observable.subscribe(item -> System.out.println(item), error -> error.printStackTrace(),
                () -> System.out.println("Done"));
    }

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
}
