package kg.it_academy.sell_soul.contoller;

import kg.it_academy.sell_soul.contoller.base_controller.BaseController;
import kg.it_academy.sell_soul.entity.Auction;
import kg.it_academy.sell_soul.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auction")
public class AuctionController extends BaseController<Auction> {
    @Autowired
    AuctionService auctionService;

    @PostMapping
    @Override
    public Auction save(@RequestBody Auction auction) {
        return auctionService.save(auction);
    }

    @GetMapping
    @Override
    public List<Auction> getAll() {
        return auctionService.getAll();
    }

    @GetMapping("/{id}")
    @Override
    public Auction findById(@PathVariable Long id) {
        return auctionService.findById(id);
    }

    @DeleteMapping("/{id}")
    @Override
    public Auction deleteById(@PathVariable Long id) {
        return auctionService.deleteById(id);
    }
}
