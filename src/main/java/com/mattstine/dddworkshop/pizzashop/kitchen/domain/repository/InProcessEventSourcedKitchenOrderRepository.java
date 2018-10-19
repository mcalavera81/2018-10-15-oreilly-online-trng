package com.mattstine.dddworkshop.pizzashop.kitchen.domain.repository;

import com.mattstine.dddworkshop.pizzashop.infrastructure.events.ports.EventLog;
import com.mattstine.dddworkshop.pizzashop.infrastructure.events.ports.Topic;
import com.mattstine.dddworkshop.pizzashop.infrastructure.repository.adapters.InProcessEventSourcedRepository;
import com.mattstine.dddworkshop.pizzashop.kitchen.domain.aggregates.KitchenOrder;
import com.mattstine.dddworkshop.pizzashop.kitchen.domain.events.KitchenOrderAddedEvent;
import com.mattstine.dddworkshop.pizzashop.kitchen.domain.events.KitchenOrderEvent;
import com.mattstine.dddworkshop.pizzashop.ordering.OnlineOrderRef;

import java.util.HashMap;
import java.util.Map;

public final class InProcessEventSourcedKitchenOrderRepository extends InProcessEventSourcedRepository<KitchenOrder.KitchenOrderRef, KitchenOrder, KitchenOrder.OrderState, KitchenOrderEvent, KitchenOrderAddedEvent> implements KitchenOrderRepository {

    Map<OnlineOrderRef, KitchenOrder.KitchenOrderRef> onlineOrderRefToKitchenOrderRef;

    public InProcessEventSourcedKitchenOrderRepository(EventLog eventLog,
                                                 Topic topic) {
        super(eventLog,
                KitchenOrder.KitchenOrderRef.class,
                KitchenOrder.class,
                KitchenOrder.OrderState.class,
                KitchenOrderAddedEvent.class,
                topic);

        onlineOrderRefToKitchenOrderRef = new HashMap<>();

        eventLog.subscribe(new Topic("kitchen_orders"), e -> {
            if (e instanceof KitchenOrderAddedEvent) {
                KitchenOrderAddedEvent koae = (KitchenOrderAddedEvent) e;
                onlineOrderRefToKitchenOrderRef.put(koae.getState().getOnlineOrderRef(), koae.getRef());
            }
        });
    }

    @Override
    public KitchenOrder findByOnlineOrderRef(OnlineOrderRef onlineOrderRef) {
        KitchenOrder.KitchenOrderRef kitchenOrderRef = onlineOrderRefToKitchenOrderRef.get(onlineOrderRef);
        if (kitchenOrderRef != null) {
            return this.findByRef(kitchenOrderRef);
        }
        return null;
    }
}
