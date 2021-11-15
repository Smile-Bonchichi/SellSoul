package kg.it_academy.sell_soul.service;

import kg.it_academy.sell_soul.entity.Auction;
import kg.it_academy.sell_soul.entity.Item;
import kg.it_academy.sell_soul.model.AuctionModel;
import kg.it_academy.sell_soul.service.base_service.BaseService;

import java.util.List;

public interface AuctionService extends BaseService<Auction> {
    List<Auction> findByActiveAuction();
    Auction saveWithoutAd(AuctionModel auction);
    Auction saveWithAd(AuctionModel auction);
}
