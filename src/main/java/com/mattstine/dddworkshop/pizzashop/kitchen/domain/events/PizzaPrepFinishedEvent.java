package com.mattstine.dddworkshop.pizzashop.kitchen.domain.events;

import com.mattstine.dddworkshop.pizzashop.kitchen.domain.aggregates.Pizza;
import lombok.Value;

@Value
public final class PizzaPrepFinishedEvent implements PizzaEvent {
    Pizza.PizzaRef ref;
}

