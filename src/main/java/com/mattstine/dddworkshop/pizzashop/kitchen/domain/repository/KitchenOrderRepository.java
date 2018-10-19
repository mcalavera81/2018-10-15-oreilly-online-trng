package com.mattstine.dddworkshop.pizzashop.kitchen.domain.repository;

import com.mattstine.dddworkshop.pizzashop.infrastructure.repository.ports.Repository;
import com.mattstine.dddworkshop.pizzashop.kitchen.domain.aggregates.KitchenOrder;
import com.mattstine.dddworkshop.pizzashop.kitchen.domain.events.KitchenOrderAddedEvent;
import com.mattstine.dddworkshop.pizzashop.kitchen.domain.events.KitchenOrderEvent;
import com.mattstine.dddworkshop.pizzashop.ordering.OnlineOrderRef;

public interface KitchenOrderRepository extends Repository<KitchenOrder.KitchenOrderRef, KitchenOrder, KitchenOrder.OrderState, KitchenOrderEvent, KitchenOrderAddedEvent> {
    KitchenOrder findByOnlineOrderRef(OnlineOrderRef onlineOrderRef);
}
