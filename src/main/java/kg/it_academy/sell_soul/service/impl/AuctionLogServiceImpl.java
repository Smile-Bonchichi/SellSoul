package kg.it_academy.sell_soul.service.impl;

import kg.it_academy.sell_soul.entity.AuctionLog;
import kg.it_academy.sell_soul.repository.AuctionLogRepository;
import kg.it_academy.sell_soul.service.AuctionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionLogServiceImpl implements AuctionLogService {
    @Autowired
    private AuctionLogRepository auctionLogRepository;

    @Override
    public AuctionLog save(AuctionLog auctionLog) {
        return auctionLogRepository.save(auctionLog);
    }

    @Override
    public List<AuctionLog> getAll() {
        return auctionLogRepository.findAll();
    }

    @Override
    public AuctionLog findById(Long id) {
        return auctionLogRepository.findById(id).orElse(null);
    }

    @Override
    public AuctionLog deleteById(Long id) {
        AuctionLog auctionLogForDelete = findById(id);
        if (auctionLogForDelete != null)
            auctionLogRepository.deleteById(id);
        return auctionLogForDelete;
    }
}
