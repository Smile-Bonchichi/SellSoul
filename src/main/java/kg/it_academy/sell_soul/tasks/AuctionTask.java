package kg.it_academy.sell_soul.tasks;

import kg.it_academy.sell_soul.entity.Auction;
import kg.it_academy.sell_soul.entity.Status;
import kg.it_academy.sell_soul.service.AuctionService;
import kg.it_academy.sell_soul.service.StatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class AuctionTask {
    private final AuctionService auctionService;
    private final StatusService statusService;

    @Autowired
    public AuctionTask(AuctionService auctionService, StatusService statusService) {
        this.auctionService = auctionService;
        this.statusService = statusService;
    }

    @Scheduled(cron = "* * * * * *")
    public void checkTimeOfClose() {
        List<Auction> auctions = auctionService.findByActiveAuction();
//        log.info("checkTimeOfClose " + LocalDateTime.now());
        Status unActive = statusService.findById(1L);
        auctions.stream().filter(auction -> auction.getEndTime()
                        .compareTo(LocalDateTime.now()) <= 0)
                .forEach(auction -> auction.setStatus(unActive));
    }

    @Scheduled(fixedRate = 1000)
    public void checkTimeOfOpen() {
        //      log.info("checkTimeOfOpen " + LocalDateTime.now());
        List<Auction> auctions = auctionService.getAll();
        Status active = statusService.findById(2L);
        auctions.stream().filter(auction -> auction.getEndTime()
                        .compareTo(LocalDateTime.now()) <= 0)
                .forEach(auction -> auction.setStatus(active));
    }
}
