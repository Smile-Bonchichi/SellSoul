package kg.it_academy.sell_soul.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserAuthModel {

    private String login;

    private String password;
}
