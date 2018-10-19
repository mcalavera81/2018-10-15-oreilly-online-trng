package com.mattstine.dddworkshop.pizzashop.kitchen.domain.events;

import com.mattstine.dddworkshop.pizzashop.infrastructure.repository.ports.RepositoryAddEvent;
import com.mattstine.dddworkshop.pizzashop.kitchen.domain.aggregates.Pizza;
import lombok.Value;

@Value
public final class PizzaAddedEvent implements PizzaEvent, RepositoryAddEvent {
    Pizza.PizzaRef ref;
    Pizza.PizzaState state;
}
