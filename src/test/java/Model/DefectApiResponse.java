package Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DefectApiResponse {
    @Builder.Default boolean status=true;
    Results results;
}
