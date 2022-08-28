package Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectApi {
    String title;
    String code;
    String description;
}
