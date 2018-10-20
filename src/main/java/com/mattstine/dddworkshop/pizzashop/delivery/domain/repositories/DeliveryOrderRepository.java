package com.mattstine.dddworkshop.pizzashop.delivery.domain.repositories;

import com.mattstine.dddworkshop.pizzashop.delivery.domain.aggregates.DeliveryOrder;
import com.mattstine.dddworkshop.pizzashop.delivery.domain.aggregates.DeliveryOrderRef;
import com.mattstine.dddworkshop.pizzashop.delivery.domain.events.DeliveryOrderAddedEvent;
import com.mattstine.dddworkshop.pizzashop.delivery.domain.events.DeliveryOrderEvent;
import com.mattstine.dddworkshop.pizzashop.infrastructure.repository.ports.Repository;
import com.mattstine.dddworkshop.pizzashop.kitchen.domain.aggregates.KitchenOrder;

/**
 * @author Matt Stine
 */
public interface DeliveryOrderRepository extends Repository<DeliveryOrderRef, DeliveryOrder, DeliveryOrder.OrderState, DeliveryOrderEvent, DeliveryOrderAddedEvent> {
	DeliveryOrder findByKitchenOrderRef(KitchenOrder.KitchenOrderRef kitchenOrderRef);
}
