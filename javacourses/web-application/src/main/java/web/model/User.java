package web.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class User {

    private String firstName;

    private String lastName;

    private String age;
}
