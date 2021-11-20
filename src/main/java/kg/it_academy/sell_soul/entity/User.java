package kg.it_academy.sell_soul.entity;

import javax.persistence.*;

import kg.it_academy.sell_soul.entity.base_entity.BaseEntity;
import lombok.*;

import java.math.BigDecimal;

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
    private BigDecimal balance;

    private Long isActive;
}
