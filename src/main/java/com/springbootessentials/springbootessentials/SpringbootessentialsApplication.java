package com.springbootessentials.springbootessentials;

import com.springbootessentials.springbootessentials.repository.common.dto.Code;
import com.springbootessentials.springbootessentials.repository.dto.OrderEntity;
import com.springbootessentials.springbootessentials.service.order.enums.OrderSentsEnum;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringbootessentialsApplication {

	private static List<OrderEntity> orderEntities = new ArrayList<>();

	public static void main(String[] args) {
		ConfigurableApplicationContext appCtx = SpringApplication.run(SpringbootessentialsApplication.class, args);
//		printAppBeans(appCtx);
		orderEntities = initOrders();
	}

	private static void printAppBeans(ConfigurableApplicationContext appCtx) {
		Arrays.stream(appCtx.getBeanDefinitionNames()).forEach(System.out::println);
	}


	public static List<OrderEntity> getOrders() {
		return orderEntities;
	}

	public static void setOrders(List<OrderEntity> orderEntities) {
		SpringbootessentialsApplication.orderEntities = orderEntities;
	}

	private static List<OrderEntity> initOrders() {

		List<OrderEntity> orderEntities = new ArrayList<>();
		OrderEntity orderEntity1 = new OrderEntity();
		orderEntity1.setId(1001L);
		orderEntity1.setItemName("order 1");
		orderEntity1.setStatus(new Code.Builder().setCode(OrderSentsEnum.NOT_SENT.getCode()).build());
		orderEntities.add(orderEntity1);

		OrderEntity orderEntity2 = new OrderEntity();
		orderEntity2.setId(1002L);
		orderEntity2.setItemName("order 2");
		orderEntity2.setStatus(new Code.Builder().setCode(OrderSentsEnum.NOT_SENT.getCode()).build());
		orderEntities.add(orderEntity2);

		OrderEntity orderEntity3 = new OrderEntity();
		orderEntity3.setId(1003L);
		orderEntity3.setItemName("order 3");
		orderEntity3.setStatus(new Code.Builder().setCode(OrderSentsEnum.NOT_SENT.getCode()).build());
		orderEntities.add(orderEntity3);

		return orderEntities;
	}

}
