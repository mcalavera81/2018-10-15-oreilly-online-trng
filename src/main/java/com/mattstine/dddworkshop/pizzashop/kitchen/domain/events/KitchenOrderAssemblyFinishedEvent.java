package com.mattstine.dddworkshop.pizzashop.kitchen.domain.events;

import com.mattstine.dddworkshop.pizzashop.kitchen.domain.aggregates.KitchenOrder;
import lombok.Value;

@Value
public final class KitchenOrderAssemblyFinishedEvent implements KitchenOrderEvent {
    KitchenOrder.KitchenOrderRef ref;
}
