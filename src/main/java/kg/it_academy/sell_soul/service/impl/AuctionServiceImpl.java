package kg.it_academy.sell_soul.service.impl;

import kg.it_academy.sell_soul.entity.Auction;
import kg.it_academy.sell_soul.repository.AuctionRepository;
import kg.it_academy.sell_soul.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionServiceImpl implements AuctionService {
    @Autowired
    private AuctionRepository auctionRepository;

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
        return auctionRepository.findById(id).orElse(null);
    }

    @Override
    public Auction deleteById(Long id) {
        Auction auctionForDelete = findById(id);
        if (auctionForDelete != null)
            auctionRepository.deleteById(id);
        return auctionForDelete;
    }
}
