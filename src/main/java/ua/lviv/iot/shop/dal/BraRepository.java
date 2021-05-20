package ua.lviv.iot.shop.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.shop.models.Bra;

@Repository
public interface BraRepository extends JpaRepository<Bra, Integer> {
}
