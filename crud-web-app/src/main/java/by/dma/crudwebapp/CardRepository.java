package by.dma.crudwebapp;

import by.dma.crudwebapp.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This JPA Repository have access to our data in database by using JPA Entity Manager behind the scene to access the data .
 *
 * @author dzmitry.marudau
 * @since 2019.4
 */
public interface CardRepository extends JpaRepository<Card, Long> {
}
