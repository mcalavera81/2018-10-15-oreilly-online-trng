package com.mattstine.dddworkshop.pizzashop.delivery;

import com.mattstine.dddworkshop.pizzashop.infrastructure.repository.ports.Repository;
import com.mattstine.dddworkshop.pizzashop.kitchen.domain.aggregates.KitchenOrder;

/**
 * @author Matt Stine
 */
interface DeliveryOrderRepository extends Repository<DeliveryOrderRef, DeliveryOrder, DeliveryOrder.OrderState, DeliveryOrderEvent, DeliveryOrderAddedEvent> {
	DeliveryOrder findByKitchenOrderRef(KitchenOrder.KitchenOrderRef kitchenOrderRef);
}
