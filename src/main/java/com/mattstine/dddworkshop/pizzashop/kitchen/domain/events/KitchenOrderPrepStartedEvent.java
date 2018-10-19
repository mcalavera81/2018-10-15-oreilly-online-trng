package com.mattstine.dddworkshop.pizzashop.kitchen.domain.events;

import com.mattstine.dddworkshop.pizzashop.infrastructure.events.ports.Event;
import com.mattstine.dddworkshop.pizzashop.kitchen.domain.aggregates.KitchenOrder;
import lombok.Value;

@Value
public final class KitchenOrderPrepStartedEvent implements Event, KitchenOrderEvent {
    KitchenOrder.KitchenOrderRef ref;
}
