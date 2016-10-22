package proxy;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.eventbus.DeliveryOptions;

public class Proxy extends AbstractVerticle {

  @Override
  public void start(Future<Void> fut) {
    vertx
        .createHttpServer()
        .requestHandler(
                request ->
                    vertx.eventBus().send("ping", null, new DeliveryOptions().setSendTimeout(1000),
                        response ->
                        {
                            if (response.succeeded())
                                request.response().end("<h1>Got pong</h1>");
                            else
                                request.response().setStatusCode(500).end("<h1>Got error</h1>");
                        }))
        .listen(8080, result -> {
          if (result.succeeded()) {
            fut.complete();
          } else {
            fut.fail(result.cause());
          }
        });
  }
}
