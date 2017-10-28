package br.com.seniors.repository;

import br.com.seniors.model.Service;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Dell
 */
public interface ServiceRepository extends CrudRepository<Service, Integer> {
    
    public List<Service> findByGroup_Id(Integer id);
    
}
