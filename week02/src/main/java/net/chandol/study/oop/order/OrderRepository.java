package net.chandol.study.oop.order;


import net.chandol.study.oop.infra.Registrar;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

public class OrderRepository {
    public static void persist(Order order){
        Registrar.add(order, Order.class);
    }

    public static Order get(String id){
        return Registrar.get(id, Order.class);
    }

    public static List<Order> findByCustomer(String id){
        Set<Order> orders = Registrar.getAll(Order.class);

        return orders.stream()
                .filter(o -> o.getCustomer().getId().equals(id))
                .collect(toList());
    }
}
