package platform.persistence;

import platform.businesslayer.Code;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CodeRepository extends CrudRepository<Code, String> {

}