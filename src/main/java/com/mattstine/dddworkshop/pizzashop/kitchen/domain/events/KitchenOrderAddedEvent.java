package com.mattstine.dddworkshop.pizzashop.kitchen.domain.events;

import com.mattstine.dddworkshop.pizzashop.infrastructure.repository.ports.RepositoryAddEvent;
import com.mattstine.dddworkshop.pizzashop.kitchen.domain.aggregates.KitchenOrder;
import lombok.Value;

@Value
public final class KitchenOrderAddedEvent implements KitchenOrderEvent, RepositoryAddEvent {
    KitchenOrder.KitchenOrderRef ref;
    KitchenOrder.OrderState state;
}
