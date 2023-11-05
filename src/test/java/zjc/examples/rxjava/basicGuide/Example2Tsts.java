package zjc.examples.rxjava.basicGuide;

import org.junit.jupiter.api.Test;

public class Example2Tsts {

    Example2 example2 = new Example2();

    @Test
    public void example2Just() {
        example2.example2Just();
    }

    @Test
    public void example2Map() {
        example2.example2Map();
    }

    @Test
    public void example2FlatMap() {
        example2.example2FlatMap();
    }

    @Test
    public void example2Scan() {
        example2.example2Scan();
    }

    @Test
    public void example2GroupBy() {
        example2.example2GroupBy();
    }

    @Test
    public void example2Filter() {
        example2.example2Filter();
    }

    @Test
    public void example2DefaultIfEmpty() {
        example2.example2DefaultIfEmpty();
    }

    @Test
    public void example2TakeWhile() {
        example2.example2TakeWhile();
    }
}
