package zjc.examples.rxjava;

import io.reactivex.rxjava3.core.Observable;
//import rx.Observable;
// import rx.Single;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subscribers.TestSubscriber;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class SingleClass {

    public void just01() throws InterruptedException {
        Disposable d = Single.just("Hello World")
                .delay(10, TimeUnit.SECONDS, Schedulers.io())
                .subscribeWith(new DisposableSingleObserver<String>() {
                    @Override
                    public void onStart() {
                        System.out.println("Started");
                    }

                    @Override
                    public void onSuccess(String value) {
                        System.out.println("Success: " + value);
                    }

                    @Override
                    public void onError(Throwable error) {
                        error.printStackTrace();
                    }
                });

        Thread.sleep(5000);

        d.dispose();
    }

// see tests
//    public void just02() {
//        TestSubscriber<String> ts = new TestSubscriber<String>();
//        Single.just("A")
//                .map(new Function<String, String>() {
//                    @Override
//                    public String apply(String s) {
//                        return s + "B";
//                    }
//                })
//                .toFlowable().subscribe(ts);
//        //ts.assertValueSequence(Arrays.asList("AB"));
//    }
}
