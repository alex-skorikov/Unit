package ru.skorikov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skorikov.domain.Unit;

/**
 * Unit repository.
 */
public interface UnitRepository extends JpaRepository<Unit, Integer> {
    /**
     * Find unit by id.
     * @param id id.
     * @return unit.
     */
    Unit findUnitById(Integer id);
}
