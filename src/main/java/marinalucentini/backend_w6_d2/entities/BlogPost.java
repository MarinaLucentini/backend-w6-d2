package marinalucentini.backend_w6_d2.entities;

import lombok.*;

import java.time.LocalTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogPost {
    private int id;
    private String cathegory;
    private String title;
    private String cover;
    private String body;
    private LocalTime
    readingTime;
}
