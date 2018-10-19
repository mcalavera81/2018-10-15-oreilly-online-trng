package com.mattstine.dddworkshop.pizzashop.kitchen.domain.repository;

import com.mattstine.dddworkshop.pizzashop.infrastructure.events.ports.EventLog;
import com.mattstine.dddworkshop.pizzashop.infrastructure.events.ports.Topic;
import com.mattstine.dddworkshop.pizzashop.infrastructure.repository.adapters.InProcessEventSourcedRepository;
import com.mattstine.dddworkshop.pizzashop.kitchen.domain.aggregates.KitchenOrder;
import com.mattstine.dddworkshop.pizzashop.kitchen.domain.aggregates.Pizza;
import com.mattstine.dddworkshop.pizzashop.kitchen.domain.events.PizzaAddedEvent;
import com.mattstine.dddworkshop.pizzashop.kitchen.domain.events.PizzaEvent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class InProcessEventSourcedPizzaRepository extends InProcessEventSourcedRepository<Pizza.PizzaRef, Pizza, Pizza.PizzaState, PizzaEvent, PizzaAddedEvent> implements PizzaRepository {

  Map<KitchenOrder.KitchenOrderRef, Set<Pizza.PizzaRef>> kitchenOrderRefToPizzaRefSet;

  public InProcessEventSourcedPizzaRepository(EventLog eventLog, Topic pizzas) {
    super(eventLog, Pizza.PizzaRef.class, Pizza.class, Pizza.PizzaState.class, PizzaAddedEvent.class, pizzas);

    kitchenOrderRefToPizzaRefSet = new HashMap<>();

    eventLog.subscribe(new Topic("pizzas"), e -> {
      if (e instanceof PizzaAddedEvent) {
        PizzaAddedEvent pae = (PizzaAddedEvent) e;
        Set<Pizza.PizzaRef> pizzaRefs = kitchenOrderRefToPizzaRefSet.computeIfAbsent(pae.getState().getKitchenOrderRef(), k -> new HashSet<>());
        pizzaRefs.add(pae.getRef());
      }
    });
  }

  @Override
  public Set<Pizza> findPizzasByKitchenOrderRef(KitchenOrder.KitchenOrderRef kitchenOrderRef) {
    return kitchenOrderRefToPizzaRefSet.get(kitchenOrderRef).stream()
      .map(this::findByRef)
      .collect(Collectors.toSet());
  }
}
