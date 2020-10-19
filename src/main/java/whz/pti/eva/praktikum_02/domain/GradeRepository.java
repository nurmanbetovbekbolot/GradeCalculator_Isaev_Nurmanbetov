package whz.pti.eva.praktikum_02.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface GradeRepository.
 * This interface works with JPA to store data
 *
 * @author Isaev A. Nurmanbetov B.
 */
public interface GradeRepository extends JpaRepository<Grade, Integer> {
}
