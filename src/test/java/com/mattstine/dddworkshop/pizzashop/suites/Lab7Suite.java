package com.mattstine.dddworkshop.pizzashop.suites;

import com.mattstine.dddworkshop.pizzashop.delivery.*;
import com.mattstine.dddworkshop.pizzashop.delivery.domain.aggregates.DeliveryOrderTests;
import com.mattstine.dddworkshop.pizzashop.delivery.domain.repositories.InProcessEventSourcedDeliveryOrderRepositoryIntegrationTests;
import com.mattstine.dddworkshop.pizzashop.delivery.domain.repositories.InProcessEventSourcedDeliveryOrderRepositoryTests;
import com.mattstine.dddworkshop.pizzashop.kitchen.*;
import com.mattstine.dddworkshop.pizzashop.kitchen.domain.KitchenOrderTests;
import com.mattstine.dddworkshop.pizzashop.kitchen.domain.PizzaTests;
import com.mattstine.dddworkshop.pizzashop.kitchen.domain.repository.InProcessEventSourcedKitchenOrderRepositoryIntegrationTests;
import com.mattstine.dddworkshop.pizzashop.kitchen.domain.repository.InProcessEventSourcedKitchenOrderRepositoryTests;
import com.mattstine.dddworkshop.pizzashop.kitchen.domain.repository.InProcessEventSourcedPizzaRepositoryIntegrationTests;
import com.mattstine.dddworkshop.pizzashop.kitchen.domain.repository.InProcessEventSourcedPizzaRepositoryTests;
import com.mattstine.lab.infrastructure.*;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Matt Stine
 */
@RunWith(Categories.class)
@Suite.SuiteClasses({
		KitchenOrderTests.class,
		PizzaTests.class,
		InProcessEventSourcedKitchenOrderRepositoryTests.class,
		InProcessEventSourcedPizzaRepositoryTests.class,
		KitchenServiceTests.class,
		KitchenServiceIntegrationTests.class,
		InProcessEventSourcedKitchenOrderRepositoryIntegrationTests.class,
		InProcessEventSourcedPizzaRepositoryIntegrationTests.class,
		DeliveryOrderTests.class,
		DeliveryServiceIntegrationTests.class,
		DeliveryServiceTests.class,
		InProcessEventSourcedDeliveryOrderRepositoryIntegrationTests.class,
		InProcessEventSourcedDeliveryOrderRepositoryTests.class
})
@Categories.IncludeCategory({
		Lab1Tests.class,
		Lab2Tests.class,
		Lab3Tests.class,
		Lab4Tests.class,
		Lab5Tests.class,
		Lab6Tests.class,
		Lab7Tests.class
})
public class Lab7Suite {
}
