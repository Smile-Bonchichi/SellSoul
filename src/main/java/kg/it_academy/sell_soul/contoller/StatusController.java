package kg.it_academy.sell_soul.contoller;

import kg.it_academy.sell_soul.contoller.base_controller.BaseController;
import kg.it_academy.sell_soul.entity.Status;
import kg.it_academy.sell_soul.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusController extends BaseController<Status> {
    private final StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @PostMapping
    @Override
    public Status save(@RequestBody Status status) {
        return statusService.save(status);
    }

    @GetMapping
    @Override
    public List<Status> getAll() {
        return statusService.getAll();
    }

    @GetMapping("/{id}")
    @Override
    public Status findById(@PathVariable Long id) {
        return statusService.findById(id);
    }

    @DeleteMapping("/{id}")
    @Override
    public Status deleteById(@PathVariable Long id) {
        return statusService.deleteById(id);
    }
}
