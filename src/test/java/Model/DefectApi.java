package Model;

import io.netty.handler.codec.spdy.SpdyHttpResponseStreamIdHandler;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DefectApi {
    String code;
    String title;
    String actual_result;
    Integer  severity;

}
