package com.mattstine.dddworkshop.pizzashop.kitchen.domain.repository;

import com.mattstine.dddworkshop.pizzashop.infrastructure.repository.ports.Repository;
import com.mattstine.dddworkshop.pizzashop.kitchen.domain.aggregates.KitchenOrder;
import com.mattstine.dddworkshop.pizzashop.kitchen.domain.aggregates.Pizza;
import com.mattstine.dddworkshop.pizzashop.kitchen.domain.events.PizzaAddedEvent;
import com.mattstine.dddworkshop.pizzashop.kitchen.domain.events.PizzaEvent;

import java.util.Set;

public interface PizzaRepository extends Repository<Pizza.PizzaRef, Pizza, Pizza.PizzaState, PizzaEvent, PizzaAddedEvent> {
    Set<Pizza> findPizzasByKitchenOrderRef(KitchenOrder.KitchenOrderRef kitchenOrderRef);
}
