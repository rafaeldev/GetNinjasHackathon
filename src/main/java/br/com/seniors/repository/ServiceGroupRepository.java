package br.com.seniors.repository;

import br.com.seniors.model.ServiceGroup;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Dell
 */
public interface ServiceGroupRepository extends CrudRepository<ServiceGroup, Integer> {
    
    public List<ServiceGroup> findByTarget_Id(Integer id);
    
}
