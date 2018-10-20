package com.mattstine.dddworkshop.pizzashop.delivery.domain.events;

import com.mattstine.dddworkshop.pizzashop.delivery.domain.aggregates.DeliveryOrder;
import com.mattstine.dddworkshop.pizzashop.delivery.domain.aggregates.DeliveryOrderRef;
import com.mattstine.dddworkshop.pizzashop.infrastructure.repository.ports.RepositoryAddEvent;
import lombok.Value;

/**
 * @author Matt Stine
 */
@Value
public final class DeliveryOrderAddedEvent implements DeliveryOrderEvent, RepositoryAddEvent {
	DeliveryOrderRef ref;
	DeliveryOrder.OrderState state;
}
