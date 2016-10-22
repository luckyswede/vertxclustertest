package service;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class Service extends AbstractVerticle {

  @Override
  public void start(Future<Void> fut)
  {
      vertx.eventBus().consumer("ping", message -> message.reply("pong"));
  }
}
