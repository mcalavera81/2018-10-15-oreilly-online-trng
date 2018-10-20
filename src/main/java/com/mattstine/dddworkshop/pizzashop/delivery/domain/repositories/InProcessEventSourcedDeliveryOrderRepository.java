package com.mattstine.dddworkshop.pizzashop.delivery.domain.repositories;

import com.mattstine.dddworkshop.pizzashop.delivery.domain.aggregates.DeliveryOrder;
import com.mattstine.dddworkshop.pizzashop.delivery.domain.aggregates.DeliveryOrderRef;
import com.mattstine.dddworkshop.pizzashop.delivery.domain.events.DeliveryOrderAddedEvent;
import com.mattstine.dddworkshop.pizzashop.delivery.domain.events.DeliveryOrderEvent;
import com.mattstine.dddworkshop.pizzashop.infrastructure.events.ports.EventLog;
import com.mattstine.dddworkshop.pizzashop.infrastructure.events.ports.Topic;
import com.mattstine.dddworkshop.pizzashop.infrastructure.repository.adapters.InProcessEventSourcedRepository;
import com.mattstine.dddworkshop.pizzashop.kitchen.domain.aggregates.KitchenOrder.KitchenOrderRef;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Matt Stine
 */
public final class InProcessEventSourcedDeliveryOrderRepository extends InProcessEventSourcedRepository<DeliveryOrderRef, DeliveryOrder, DeliveryOrder.OrderState, DeliveryOrderEvent, DeliveryOrderAddedEvent> implements DeliveryOrderRepository {

	private final Map<KitchenOrderRef, DeliveryOrderRef> kitchenOrderRefToDeliveryOrderRef;

	public InProcessEventSourcedDeliveryOrderRepository(EventLog eventLog, Topic topic) {
		super(eventLog,
				DeliveryOrderRef.class,
				DeliveryOrder.class,
				DeliveryOrder.OrderState.class,
				DeliveryOrderAddedEvent.class,
				topic);

		kitchenOrderRefToDeliveryOrderRef = new HashMap<>();

		eventLog.subscribe(topic, e -> {
			if (e instanceof DeliveryOrderAddedEvent) {
				kitchenOrderRefToDeliveryOrderRef.put(((DeliveryOrderAddedEvent) e)
						.getState()
						.getKitchenOrderRef(),
					((DeliveryOrderAddedEvent) e).getRef());
			}
		});
	}

	@Override
	public DeliveryOrder findByKitchenOrderRef(KitchenOrderRef kitchenOrderRef) {
		DeliveryOrderRef ref = kitchenOrderRefToDeliveryOrderRef.get(kitchenOrderRef);
		if (ref != null) {
			return this.findByRef(ref);
		}
		return null;
	}
}
