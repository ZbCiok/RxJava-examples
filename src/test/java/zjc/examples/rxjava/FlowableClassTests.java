package zjc.examples.rxjava;

import org.junit.jupiter.api.Test;

public class FlowableClassTests {

    FlowableClass flowableClass = new FlowableClass();

    @Test
    public void flowable01() {
        flowableClass.create01();
    }

    @Test
    public void flowable02() {
        flowableClass.just02();
    }

    @Test
    public void flowable03() {
        flowableClass.fromIterable03();
    }

    @Test
    public void flowable04() {
        flowableClass.fromIterable04();
    }
}
