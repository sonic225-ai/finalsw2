package swfinal.sw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import swfinal.sw.entity.DishEntity;

@Repository
public interface DishRepository extends JpaRepository<DishEntity, Long> {
}
