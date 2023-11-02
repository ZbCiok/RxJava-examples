package zjc.examples.rxjava;

import org.junit.jupiter.api.Test;

public class ObservableClassTests {

    ObservableClass observableClass = new ObservableClass();

    @Test
    public void observable01() {
        observableClass.just01();
    }

    @Test
    public void fromIterable02() {
        observableClass.fromIterable02();
    }

    @Test
    public void fromArray03() {
        observableClass.fromArray03();
    }

    @Test
    public void formCollable04() {
        observableClass.fromCallable04();
    }

    @Test
    public void fromFuture05() {
        observableClass.fromFuture05();
    }
}
