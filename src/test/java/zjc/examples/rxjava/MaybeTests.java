package zjc.examples.rxjava;

import org.junit.jupiter.api.Test;

public class MaybeTests {
    MaybeClass maybeClass = new MaybeClass();

    @Test
    public void just01() throws InterruptedException {
        maybeClass.just01();
    }
}
