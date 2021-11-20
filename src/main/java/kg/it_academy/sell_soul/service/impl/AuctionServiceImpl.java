package kg.it_academy.sell_soul.service.impl;


import kg.it_academy.sell_soul.entity.Auction;
import kg.it_academy.sell_soul.exception.ApiFailException;
import kg.it_academy.sell_soul.model.AuctionModel;
import kg.it_academy.sell_soul.repository.AuctionRepository;
import kg.it_academy.sell_soul.service.AuctionService;
import kg.it_academy.sell_soul.service.ItemService;
import kg.it_academy.sell_soul.service.StatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Service
public class AuctionServiceImpl implements AuctionService {
    private final AuctionRepository auctionRepository;
    @Autowired
    private  StatusService statusService;
    @Autowired
    private  ItemService itemService;

    @Autowired
    public AuctionServiceImpl(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    @Override
    public Auction saveWithAd(AuctionModel auctionModel) {
        Auction auction = convertToEntity(auctionModel);
        if (auction.getStartPrice().compareTo(BigDecimal.ZERO) < 0)
            throw new ApiFailException("Сумма внесенная в начальную цену меньше 0!");
        else if (auction.getStartTime().compareTo(LocalDateTime.now()) < 0 || auction.getEndTime().compareTo(LocalDateTime.now()) < 0)
            throw new ApiFailException("Время введено не верно!");
        else if (auction.getEndTime().compareTo(auction.getStartTime()) <= 0)
            throw new ApiFailException("Время окончания введено не верно, он меньше времени начала!");
        else if (auction.getItem() == null)
            throw new ApiFailException("Товар не выбран!");
        else
            auction = auctionRepository.save(auction);
        return auction;
    }

    public Auction saveWithoutAd(AuctionModel auctionModel) {
        Auction auction = convertToEntity(auctionModel);
        auction.setStartTime(LocalDateTime.now());
        if (auction.getStartPrice().compareTo(BigDecimal.ZERO) < 0)
            throw new ApiFailException("Сумма внесенная в начальную цену меньше 0!");
        else if (auction.getEndTime().compareTo(auction.getStartTime()) < 0)
            throw new ApiFailException("Время окончания введено не верно, он меньше времени начала!");
        else
            auction = auctionRepository.save(auction);

        return auction;
    }

    @Override
    public Auction save(Auction auction) {
        return auctionRepository.save(auction);
    }

    @Override
    public List<Auction> getAll() {
        return auctionRepository.findAll();
    }

    @Override
    public Auction findById(Long id) {
        Auction auction = auctionRepository.findById(id).orElse(null);
        if(auction == null)
            throw new ApiFailException("Не найден аукцион с таким id!");
        return auction;
    }

    @Override
    public Auction deleteById(Long id) {
        Auction auctionForDelete = findById(id);
        if (auctionForDelete != null)
            auctionRepository.deleteById(id);
        else
            throw new ApiFailException("Аукцион с таким id не найден!");
        return auctionForDelete;
    }

    @Override
    public List<Auction> findByActiveAuction() {
        return auctionRepository.getAuctionByActiveStatus();
    }

    private  Auction convertToEntity(AuctionModel modelToConvert) {
        if (modelToConvert == null) return null;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        return Auction.builder()
                .addTime(LocalDateTime.parse(modelToConvert.getAddTime(), dateTimeFormatter))
                .startTime(LocalDateTime.parse(modelToConvert.getStartTime(), dateTimeFormatter))
                .endTime(LocalDateTime.parse(modelToConvert.getEndTime(), dateTimeFormatter))
                .status(statusService.findById(modelToConvert.getStatus()))
                .item(itemService.findById(modelToConvert.getItem()))
                .startPrice(modelToConvert.getStartPrice())
                .build();
    }

    private  AuctionModel convertToModel(Auction entityToConvert) {
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
}
