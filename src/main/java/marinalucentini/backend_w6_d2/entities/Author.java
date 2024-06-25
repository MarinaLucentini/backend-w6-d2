package marinalucentini.backend_w6_d2.entities;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Author {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
    private String avatar;
}
