package kg.it_academy.sell_soul.contoller;

import kg.it_academy.sell_soul.entity.Auction;
import kg.it_academy.sell_soul.model.AuctionModel;
import kg.it_academy.sell_soul.model.ResponseMessage;
import kg.it_academy.sell_soul.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auction")
public class AuctionController {
    private final AuctionService auctionService;

    @Autowired
    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @PostMapping("/addWithAd")
    public ResponseMessage<Auction> saveWithAd(@RequestBody AuctionModel auction) {
        return new ResponseMessage<Auction>().prepareSuccessMessage(auctionService.saveWithAd(auction));
    }

    @PostMapping("/addWithoutAd")
    public ResponseMessage<Auction> saveWithoutAd(@RequestBody AuctionModel auction) {
        return new ResponseMessage<Auction>().prepareSuccessMessage(auctionService.saveWithoutAd(auction));
    }

    @GetMapping
    public List<Auction> getAll() {
        return auctionService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseMessage<Auction> findById(@PathVariable Long id) {
        return new ResponseMessage<Auction>().prepareSuccessMessage(auctionService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<Auction> deleteById(@PathVariable Long id) {
        return new ResponseMessage<Auction>().prepareSuccessMessage(auctionService.deleteById(id));
    }
}
