package company.domain.repository;

import company.domain.entity.ManufacturerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturedRepository extends CrudRepository<ManufacturerEntity, Long>
{}