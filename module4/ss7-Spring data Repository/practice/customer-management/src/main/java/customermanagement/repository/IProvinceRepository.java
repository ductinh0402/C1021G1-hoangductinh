package customermanagement.repository;

import customermanagement.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProvinceRepository extends JpaRepository<Province, Long> {
}
