package kg.it_academy.sell_soul.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuctionModel {

    private String addTime;

    private String startTime;

    private String endTime;

    private BigDecimal startPrice;

    private Long item;

    private Long status;
}
