package zjc.examples.rxjava;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.subscribers.TestSubscriber;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class SingleClassTests {
    SingleClass singleClass = new SingleClass();

    @Test
    public void just01() throws InterruptedException {
        singleClass.just01();
    }

    @Test
    public void just02() {
        TestSubscriber<String> ts = new TestSubscriber<String>();
        Single.just("Welcome")
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s + "B";
                    }
                })
                .toFlowable().subscribe(ts);
        ts.assertValueSequence(Arrays.asList("WelcomeB"));
    }
}
