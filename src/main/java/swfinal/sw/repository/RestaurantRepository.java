package swfinal.sw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import swfinal.sw.entity.RestaurantEntity;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity,Long> {
}
