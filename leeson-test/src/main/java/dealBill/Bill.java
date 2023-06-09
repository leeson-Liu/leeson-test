package dealBill;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * @author liubin
 * @create 2021-10-26 15:54
 * @desc
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
    private String localMsgId;
    private Integer callDuration;
    private Integer totalDuration;
    private Integer baseCallDuration;
    private Integer incrementCallDuration;
    private BigDecimal price;
    private BigDecimal cost;
    private BigDecimal costUserCurrency;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime responseTime;
    private Integer statusCode = 0;
    private String statusMsg ="NORMAL_CLEARING";

//    public Integer getStatusCode() {
//        return 0;
//    }
//
//    public String getStatusMsg() {
//        return "NORMAL_CLEARING";
//    }
}

