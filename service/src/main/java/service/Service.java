package service;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.eventbus.MessageConsumer;

public class Service extends AbstractVerticle {

  private MessageConsumer consumer;

  @Override
  public void start(Future<Void> fut)
  {
      consumer = vertx.eventBus().consumer("ping", message -> message.reply("pong"));
      fut.complete();
  }

  @Override
  public void stop(Future<Void> fut) {
      if (consumer == null) {
          fut.complete();
          return;
      }
      vertx.setTimer(1000, l -> consumer.unregister(fut.completer()));
  }
}
