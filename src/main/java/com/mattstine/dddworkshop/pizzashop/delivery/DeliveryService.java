package com.mattstine.dddworkshop.pizzashop.delivery;

import com.mattstine.dddworkshop.pizzashop.delivery.domain.aggregates.DeliveryOrder;
import com.mattstine.dddworkshop.pizzashop.kitchen.domain.aggregates.KitchenOrder;
import com.mattstine.dddworkshop.pizzashop.kitchen.domain.aggregates.KitchenOrder.KitchenOrderRef;

public interface DeliveryService {
  DeliveryOrder findDeliveryOrderByKitchenOrderRef(KitchenOrderRef kitchenOrderRef);
}
