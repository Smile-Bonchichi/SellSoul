package kg.it_academy.sell_soul.service.impl;

import kg.it_academy.sell_soul.entity.Auction;
import kg.it_academy.sell_soul.entity.AuctionLog;
import kg.it_academy.sell_soul.entity.Item;
import kg.it_academy.sell_soul.entity.User;
import kg.it_academy.sell_soul.exception.ApiFailException;
import kg.it_academy.sell_soul.repository.AuctionLogRepository;
import kg.it_academy.sell_soul.service.AuctionLogService;
import kg.it_academy.sell_soul.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AuctionLogServiceImpl implements AuctionLogService {
    private final AuctionLogRepository auctionLogRepository;
    private final ItemService itemService;

    @Autowired
    public AuctionLogServiceImpl(AuctionLogRepository auctionLogRepository, ItemService itemService) {
        this.auctionLogRepository = auctionLogRepository;
        this.itemService = itemService;
    }

    @Override
    public AuctionLog save(AuctionLog auctionLog) {
        Auction auction = auctionLog.getAuction();
        if (auction.getStatus().getId() == 0L) {
            throw new ApiFailException("Аукцион закрыт!");
        } else if (auctionLog.getHighestPrice().compareTo(auction.getStartPrice()) < 0)
            throw new ApiFailException("Цена меньше начальной!");
        else if (auctionLog.getBuyer().getBalance().compareTo(auctionLog.getHighestPrice()) < 0){
            throw new ApiFailException("Недастаточно средств!");
        }
        else{
            auctionLog = auctionLogRepository.save(auctionLog);
        }
        return auctionLog;
    }

    @Override
    public List<AuctionLog> getAll() {
        return auctionLogRepository.findAll();
    }

    @Override
    public AuctionLog findById(Long id) {
        AuctionLog auctionLog = auctionLogRepository.findById(id).orElse(null);
        if(auctionLog == null)
            throw new ApiFailException("Не найден логи с таким id!");
        return auctionLog;
    }

    @Override
    public AuctionLog deleteById(Long id) {
        AuctionLog auctionLogForDelete = findById(id);

        if (auctionLogForDelete != null)
            auctionLogRepository.deleteById(id);
        else
            throw new ApiFailException("Логи с таким id не найден!");
        return auctionLogForDelete;
    }

    @Override
    public User buy(Long id) {
        List<AuctionLog> auctionLogs = auctionLogRepository.findAuctionLogsByAuction_Id(id);
        BigDecimal max = auctionLogs.get(0).getHighestPrice();
        User buyer = new User();
        for (int i = 0; i < auctionLogs.size(); i++) {
            if (auctionLogs.get(i).getHighestPrice().compareTo(max) > 0) {
                max = auctionLogs.get(i).getHighestPrice();
                buyer = auctionLogs.get(i).getBuyer();
            }
        }
        Auction auction = auctionLogs.get(0).getAuction();
        Item item = auction.getItem();
        buyer.setBalance(buyer.getBalance().subtract(max));
        User seller = item.getUser();
        seller.setBalance(seller.getBalance().add(max));
        item.setUser(buyer);
        return buyer;
    }
}
