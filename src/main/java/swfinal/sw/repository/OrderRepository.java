package swfinal.sw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import swfinal.sw.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
}
