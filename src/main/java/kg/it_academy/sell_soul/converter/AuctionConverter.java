package kg.it_academy.sell_soul.converter;

import kg.it_academy.sell_soul.converter.base_converter.BaseConverter;
import kg.it_academy.sell_soul.entity.Auction;
import kg.it_academy.sell_soul.model.AuctionModel;
import kg.it_academy.sell_soul.service.ItemService;
import kg.it_academy.sell_soul.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class AuctionConverter extends BaseConverter<AuctionModel, Auction> {
    @Autowired
    private static StatusService statusService;
    @Autowired
    private static ItemService itemService;

    public AuctionConverter() {
        super(AuctionConverter::convertToEntity, AuctionConverter::convertToModel);
    }

    private static AuctionModel convertToModel(Auction entityToConvert) {
        if (entityToConvert == null) return null;

        return AuctionModel.builder()
                .addTime(entityToConvert.getAddTime().toString())
                .startTime(entityToConvert.getStartTime().toString())
                .endTime(entityToConvert.getEndTime().toString())
                .startPrice(entityToConvert.getStartPrice())
                .status(entityToConvert.getStatus().getId())
                .item(entityToConvert.getItem().getId())
                .build();
    }

    private static Auction convertToEntity(AuctionModel modelToConvert) {
        if (modelToConvert == null) return null;

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        return Auction.builder()
                .addTime(LocalDateTime.parse(modelToConvert.getAddTime(), dateTimeFormatter))
                .startTime(LocalDateTime.parse(modelToConvert.getStartTime(), dateTimeFormatter))
                .endTime(LocalDateTime.parse(modelToConvert.getEndTime(), dateTimeFormatter))
                .status(statusService.findById(modelToConvert.getStatus()))
                .item(itemService.findById(modelToConvert.getItem()))
                .build();
    }
}
