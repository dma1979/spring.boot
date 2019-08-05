package by.dma.crudwebapp.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity to manage users.
 *
 * @author dzmitry.marudau
 * @since 2019.7
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String login;

    @Column
    private String name;

    @Column
    private String email;
}
