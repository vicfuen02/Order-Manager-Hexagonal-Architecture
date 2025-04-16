package com.springbootessentials.springbootessentials.repository.config;

import com.springbootessentials.springbootessentials.repository.orderAdapter.OrderDao;
import com.springbootessentials.springbootessentials.repository.orderAdapter.OrderDaoJpaAdapter;
import com.springbootessentials.springbootessentials.repository.orderAdapter.OrderDaoMockAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Arrays;
import java.util.Set;

@Configuration
public class OrderDaoConfig {

    private static final Logger log = LogManager.getLogger(OrderDaoConfig.class);

    private static final String ORDER_DAO_ADAPTER_PROPERTY = "spe.adapter.order.repository";

    @Bean("orderDao")
    @Conditional(OrderDaoJpaAdapterCondition.class)
    public OrderDao orderDaoJpa() {
        log.debug("Initializing OrderDaoJpaAdapter");
        return new OrderDaoJpaAdapter();
    }

    @Bean("orderDao")
    @ConditionalOnProperty(name = ORDER_DAO_ADAPTER_PROPERTY, havingValue = "mock")
    public OrderDao orderDaoMOck() {

        log.debug("Initializing OrderDaoMockAdapter");
        return new OrderDaoMockAdapter();
    }


    public static class OrderDaoJpaAdapterCondition implements Condition {

        private static final Set<String> ORDER_DAO_ADAPTERS = Set.of("jpa", "mock");

        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

            String value = context.getEnvironment().getProperty(ORDER_DAO_ADAPTER_PROPERTY, "jpa");
            return value.equals("jpa") || !ORDER_DAO_ADAPTERS.contains(value);
        }
    }


}
