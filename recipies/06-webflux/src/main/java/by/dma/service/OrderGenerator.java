package by.dma.service;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import by.dma.model.Order;

/**
 * @author : Dzmitry Marudau
 * @created at : 01:18
 * @since : 2020.06
 **/
public class OrderGenerator {

  public Order generate() {
    var amount = ThreadLocalRandom.current().nextDouble(1000.00);
    return new Order(UUID.randomUUID().toString(),
                     BigDecimal.valueOf(amount));
  }
}
