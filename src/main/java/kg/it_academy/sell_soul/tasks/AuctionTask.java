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
    @Autowired
    private AuctionService auctionService;
    @Autowired
    private StatusService statusService;

//    @Scheduled(cron = "* * * * * *")
//    public void checkTimeOfClose() {
////        List<Auction> auctions = auctionService.findByActiveAuction();
//        log.info("checkTimeOfClose " + LocalDateTime.now().toString());
////        Status unActive = statusService.findById(0L);
////        for (int i = 0; i < auctions.size(); i++) {
////            if (auctions.get(i).getEndTime().compareTo(LocalDateTime.now()) <= 0) {
////                auctions.get(i).setStatus(unActive);
////            }
////        }
//    }
//
//    @Scheduled(fixedRate = 1000)
//    public void checkTimeOfOpen() {
//        log.info("checkTimeOfOpen " + LocalDateTime.now().toString());
////        List<Auction> auctions = auctionService.getAll();
////        Status active = statusService.findById(1L);
////        for (int i = 0; i < auctions.size(); i++) {
////            if (auctions.get(i).getEndTime().compareTo(LocalDateTime.now()) <= 0) {
////                auctions.get(i).setStatus(active);
////            }
////        }
//    }
}
