package kg.it_academy.sell_soul.service.impl;

import kg.it_academy.sell_soul.converter.AuctionConverter;
import kg.it_academy.sell_soul.entity.Auction;
import kg.it_academy.sell_soul.exception.ApiFailException;
import kg.it_academy.sell_soul.model.AuctionModel;
import kg.it_academy.sell_soul.repository.AuctionRepository;
import kg.it_academy.sell_soul.service.AuctionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class AuctionServiceImpl implements AuctionService {
    @Autowired
    private AuctionRepository auctionRepository;

    private AuctionConverter auctionConverter = new AuctionConverter();

    @Override
    public Auction saveWithAd(AuctionModel auctionModel) {
        Auction auction = auctionConverter.convertFromModel(auctionModel);
        if (auction.getStartPrice().compareTo(BigDecimal.ZERO) < 0)
            throw new ApiFailException("Сумма внесенная в начальную цену меньше 0!");
        else if (auction.getStartTime().compareTo(LocalDateTime.now()) < 0 || auction.getEndTime().compareTo(LocalDateTime.now()) < 0)
            throw new ApiFailException("Время введено не верно!");
        else if (auction.getEndTime().compareTo(auction.getStartTime()) <= 0)
            throw new ApiFailException("Время окончания введено не верно, он меньше времени начала!");
        else
            auction = auctionRepository.save(auction);
        return auction;
    }

    public Auction saveWithoutAd(AuctionModel auctionModel) {
        Auction auction = auctionConverter.convertFromModel(auctionModel);
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
        return save(auction);
    }

    @Override
    public List<Auction> getAll() {
        return auctionRepository.findAll();
    }

    @Override
    public Auction findById(Long id) {
        return auctionRepository.findById(id).orElse(null);
    }

    @Override
    public Auction deleteById(Long id) {
        Auction auctionForDelete = findById(id);
        if (auctionForDelete != null)
            auctionRepository.deleteById(id);
        return auctionForDelete;
    }

    @Autowired
    public void setAuctionRepository(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    @Override
    public List<Auction> findByActiveAuction() {
        List<Auction> auctions = auctionRepository.getAuctionByActiveStatus();
        return auctions;
    }
}
