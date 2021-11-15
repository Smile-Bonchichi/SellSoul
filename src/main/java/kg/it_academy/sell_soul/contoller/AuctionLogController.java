package kg.it_academy.sell_soul.contoller;

import kg.it_academy.sell_soul.contoller.base_controller.BaseController;
import kg.it_academy.sell_soul.entity.AuctionLog;
import kg.it_academy.sell_soul.model.ResponseMessage;
import kg.it_academy.sell_soul.service.AuctionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auction-log")
public class AuctionLogController extends BaseController<AuctionLog> {
    @Autowired
    private AuctionLogService auctionLogService;

    @PostMapping
    @Override
    public AuctionLog save(@RequestBody AuctionLog auctionLog) {
        return  auctionLogService.save(auctionLog);
    }

    @PostMapping("/add")
    public ResponseMessage<AuctionLog> saveCorrect(@RequestBody AuctionLog auctionLog) {
        return new ResponseMessage<AuctionLog>().prepareSuccessMessage(auctionLogService.save(auctionLog));
    }

    @GetMapping
    @Override
    public List<AuctionLog> getAll() {
        return auctionLogService.getAll();
    }

    @GetMapping("/api/{id}")
    @Override
    public AuctionLog findById(@PathVariable Long id) {
        return auctionLogService.findById(id);
    }

    @DeleteMapping("/api/{id}")
    @Override
    public AuctionLog deleteById(@PathVariable Long id) {
        return auctionLogService.deleteById(id);
    }
}
