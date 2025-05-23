package com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.config;

import com.springbootessentials.springbootessentials.application.ports.output.order.OrderDao;
import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.repository.order.jpa.OrderDaoJpaAdapter;
import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.repository.order.mock.OrderDaoMockAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Set;

@Configuration
public class OrderDaoConfig {

    private static final Logger log = LogManager.getLogger(OrderDaoConfig.class);

    private static final String ORDER_DAO_ADAPTER_PROPERTY = "spe.adapter.repository";

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
