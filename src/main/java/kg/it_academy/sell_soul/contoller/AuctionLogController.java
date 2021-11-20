package kg.it_academy.sell_soul.contoller;

import kg.it_academy.sell_soul.entity.AuctionLog;
import kg.it_academy.sell_soul.entity.User;
import kg.it_academy.sell_soul.model.ResponseMessage;
import kg.it_academy.sell_soul.service.AuctionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auction-log")
public class AuctionLogController {
    private final AuctionLogService auctionLogService;

    @Autowired
    public AuctionLogController(AuctionLogService auctionLogService) {
        this.auctionLogService = auctionLogService;
    }

    @PostMapping
    public AuctionLog save(@RequestBody AuctionLog auctionLog) {
        return auctionLogService.save(auctionLog);
    }

    @PostMapping("/add")
    public ResponseMessage<AuctionLog> saveCorrect(@RequestBody AuctionLog auctionLog) {
        return new ResponseMessage<AuctionLog>().prepareSuccessMessage(auctionLogService.save(auctionLog));
    }

    @GetMapping("/buy/{id}")
    public ResponseMessage<User> buy(@PathVariable Long id) {
        return new ResponseMessage<User>().prepareSuccessMessage(auctionLogService.buy(id));
    }

    @GetMapping
    public List<AuctionLog> getAll() {
        return auctionLogService.getAll();
    }

    @GetMapping("/api/{id}")
    public ResponseMessage<AuctionLog> findById(@PathVariable Long id) {
        return new ResponseMessage<AuctionLog>().prepareSuccessMessage(auctionLogService.findById(id));
    }

    @DeleteMapping("/api/{id}")
    public ResponseMessage<AuctionLog> deleteById(@PathVariable Long id) {
        return new ResponseMessage<AuctionLog>().prepareSuccessMessage(auctionLogService.deleteById(id));
    }
}
