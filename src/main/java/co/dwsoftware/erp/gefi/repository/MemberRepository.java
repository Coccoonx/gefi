package co.dwsoftware.erp.gefi.repository;

import java.util.List;

import co.dwsoftware.erp.gefi.model.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface MemberRepository extends CrudRepository<Member, Long> {

    Member findByLastName(@Param("name") String name);

}
