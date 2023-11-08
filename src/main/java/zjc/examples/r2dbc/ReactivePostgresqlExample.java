package zjc.examples.r2dbc;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import io.reactivex.rxjava3.core.Single;

public class ReactivePostgresqlExample {
    public static void main(String[] args) {

        ConnectionFactory connectionFactory = new PostgresqlConnectionFactory(PostgresqlConnectionConfiguration.builder()
                .host("localhost")
                .port(5432)
                .username("postgres")
                .password("postgres")
                .database("reactivedb")
                .build());

        Single.fromPublisher(connectionFactory.create()).toFlowable()
                .flatMap(connection -> connection.createStatement("SELECT name FROM organization").execute())
                .flatMap(result -> result.map((row, rowMetadata) -> row.get("name", String.class)))
                .doOnNext(System.out::println)
                .doOnError(Throwable::printStackTrace)
                .doOnComplete(() -> System.out.println("Query completed"))
                .subscribe();

        // Prevent the program from exiting immediately
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
