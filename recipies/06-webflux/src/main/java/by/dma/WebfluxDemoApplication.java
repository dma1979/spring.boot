package by.dma;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.WebSocketService;
import org.springframework.web.reactive.socket.server.support.HandshakeWebSocketService;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import org.springframework.web.reactive.socket.server.upgrade.ReactorNettyRequestUpgradeStrategy;

import by.dma.echo.EchoHandler;

/**
 * @author : Dzmitry Marudau
 * @created at : 00:24
 * @since : 2020.05
 **/
@SpringBootApplication
public class WebfluxDemoApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext context =
            SpringApplication.run(WebfluxDemoApplication.class, args);
  }


  @Bean
  public EchoHandler echoHandler() {
    return new EchoHandler();
  }

  @Bean
  public HandlerMapping handlerMapping() {
    Map<String, WebSocketHandler> map = new HashMap<>();
    map.put("/echo", echoHandler());
    var mapping = new SimpleUrlHandlerMapping();
    mapping.setUrlMap(map);
    mapping.setOrder(Ordered.HIGHEST_PRECEDENCE);
    return mapping;
  }

  @Bean
  public WebSocketHandlerAdapter handlerAdapter() {
    return new WebSocketHandlerAdapter(webSocketService());
  }

  @Bean
  public WebSocketService webSocketService() {
    var strategy = new ReactorNettyRequestUpgradeStrategy();
    return new HandshakeWebSocketService(strategy);
  }
}
