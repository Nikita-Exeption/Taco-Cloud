package org.Nikita.Taco.Cloud.repository;

import org.Nikita.Taco.Cloud.model.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

}
