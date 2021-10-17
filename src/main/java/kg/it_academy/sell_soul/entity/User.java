package kg.it_academy.sell_soul.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import kg.it_academy.sell_soul.entity.base_entity.BaseEntity;
import lombok.*;

@Table(name = "users")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User extends BaseEntity {
    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "balance")
    private Long balance;
}
