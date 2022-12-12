package server.model;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private long user_id;
    private String email;
    private String name;
    private String surname;
    private int age;
    private Role role;
    private String password;
}
