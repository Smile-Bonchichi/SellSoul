package kg.itAcademy.SellSoul.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import kg.itAcademy.SellSoul.entity.BaseEntity.BaseEntity;
import lombok.*;


@Table(name = "users")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class User extends BaseEntity {
    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "balance")
    private Long balance;
}
