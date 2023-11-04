package zjc.examples.rxjava;

import org.junit.jupiter.api.Test;

public class ObservableClassTests {

    ObservableClass observableClass = new ObservableClass();

    @Test
    // Observable.just
    public void observable01() {
        observableClass.just01();
    }

    @Test
    // Observable.fromIterable
    public void fromIterable02() {
        observableClass.fromIterable02();
    }

    @Test
    // Observable.fromArray
    public void fromArray03() {
        observableClass.fromArray03();
    }

    @Test
    // Observable.fromCallable
    public void formCollable04() {
        observableClass.fromCallable04();
    }

    @Test
    // Observable.fromFuture
    public void fromFuture05() {
        observableClass.fromFuture05();
    }

    @Test
    // Observable.create
    public void create06() throws InterruptedException {
        observableClass.create06();
    }

    @Test
    // Observable.defer
    public void create07() throws InterruptedException {
        observableClass.create07();
    }

    @Test
    // Observable.range
    public void create08() {
        observableClass.create08();
    }

    @Test
    // Observable.interval
    public void create09() {
        observableClass.create09();
    }
}
