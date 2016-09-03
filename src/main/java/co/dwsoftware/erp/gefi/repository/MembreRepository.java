package co.dwsoftware.erp.gefi.repository;

import co.dwsoftware.erp.gefi.model.Membre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface MembreRepository extends CrudRepository<Membre, Long> {

    Membre findByNom(@Param("nom") String nom);
    Membre findByPrenom(@Param("prenom") String prenom);
    Membre findByNumeroCni(@Param("numeroCni") String numeroCni);
    Membre findByAdresse(@Param("adresse") String adresse);

}
