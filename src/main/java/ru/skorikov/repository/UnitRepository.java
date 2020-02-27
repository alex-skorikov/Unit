package ru.skorikov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skorikov.domain.Unit;

public interface UnitRepository extends JpaRepository<Unit, Integer> {

    Unit findUnitById(Integer id);
}
