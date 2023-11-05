package zjc.examples.rxjava.basicGuide;

import rx.Observable;
import rx.observables.BlockingObservable;

import java.util.Arrays;
import java.util.List;

public class Example2 {

    private static Integer[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static String[] titles = {"title"};
    private static List<String> titleList = Arrays.asList(titles);
    static Observable<String> getTitle() {
        return Observable.from(titleList);
    }

    public void example2Just() {
        Observable<String> observable = Observable.just("Hello");
        observable.subscribe(
                System.out::println, //onNext
                Throwable::printStackTrace, //onError
                () -> System.out.println("onCompleted")  //onCompleted
        );
    }

    public void example2Map() {
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        Observable.from(letters)
                .map(String::toUpperCase)
                .subscribe(System.out::print);
    }

    public void example2FlatMap() {
        Observable.just("book1", "book2")
                .flatMap(s -> getTitle())
                .subscribe(System.out::print);
    }

    public void example2Scan() {
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        Observable.from(letters)
                .scan(new StringBuilder(), StringBuilder::append)
                .subscribe(System.out::println);
    }

    public void example2GroupBy() {
        Observable.from(numbers)
                .groupBy(i -> 0 == (i % 2) ? "EVEN" : "ODD")
                .subscribe((group) -> group.subscribe((number) -> {
                    System.out.println(group.getKey() + " : " + number);
                }));
    }

    public void example2Filter() {
        Observable.from(numbers)
                .filter(i -> (i % 2 == 1))
                .subscribe(System.out::println);
    }

    public void example2DefaultIfEmpty() {
        Observable.empty()
                .defaultIfEmpty("Observable is empty")
                .subscribe(System.out::println);
    }

    public void example2TakeWhile() {
        Observable.from(numbers)
                .takeWhile(i -> i < 5)
                .subscribe(System.out::println);
    }
}
