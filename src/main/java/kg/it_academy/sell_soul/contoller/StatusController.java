package kg.it_academy.sell_soul.contoller;

import kg.it_academy.sell_soul.entity.Status;
import kg.it_academy.sell_soul.model.ResponseMessage;
import kg.it_academy.sell_soul.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusController {
    private final StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @PostMapping
    public ResponseMessage<Status> save(@RequestBody Status status) {
        return new ResponseMessage<Status>().prepareSuccessMessage(statusService.save(status));
    }

    @GetMapping
    public List<Status> getAll() {
        return statusService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseMessage<Status> findById(@PathVariable Long id) {
        return new ResponseMessage<Status>().prepareSuccessMessage(statusService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<Status> deleteById(@PathVariable Long id) {
        return new ResponseMessage<Status>().prepareSuccessMessage(statusService.deleteById(id));
    }
}
