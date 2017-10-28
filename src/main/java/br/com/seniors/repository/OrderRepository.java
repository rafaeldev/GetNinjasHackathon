package br.com.seniors.repository;

import br.com.seniors.model.ServiceOrder;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Dell
 */
public interface OrderRepository extends CrudRepository<ServiceOrder, Long> {
    
    ServiceOrder findByToken(String token);
    
}
