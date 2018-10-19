package com.mattstine.dddworkshop.pizzashop.kitchen;

import com.mattstine.dddworkshop.pizzashop.kitchen.domain.aggregates.KitchenOrder;
import com.mattstine.dddworkshop.pizzashop.kitchen.domain.aggregates.Pizza;
import com.mattstine.dddworkshop.pizzashop.ordering.OnlineOrderRef;

import java.util.Set;

/**
 * @author Matt Stine
 */
public interface KitchenService {
	void startOrderPrep(KitchenOrder.KitchenOrderRef kitchenOrderRef);

	void finishPizzaPrep(Pizza.PizzaRef ref);

	void removePizzaFromOven(Pizza.PizzaRef ref);

	KitchenOrder findKitchenOrderByOnlineOrderRef(OnlineOrderRef onlineOrderRef);

	KitchenOrder findKitchenOrderByRef(KitchenOrder.KitchenOrderRef kitchenOrderRef);

	Pizza findPizzaByRef(Pizza.PizzaRef ref);

	Set<Pizza> findPizzasByKitchenOrderRef(KitchenOrder.KitchenOrderRef kitchenOrderRef);
}
