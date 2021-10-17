package kg.it_academy.sell_soul.service.impl;

import kg.it_academy.sell_soul.entity.Status;
import kg.it_academy.sell_soul.repository.StatusRepository;
import kg.it_academy.sell_soul.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusRepository statusRepository;

    @Override
    public Status save(Status status) {
        return statusRepository.save(status);
    }

    @Override
    public List<Status> getAll() {
        return statusRepository.findAll();
    }

    @Override
    public Status findById(Long id) {
        return statusRepository.findById(id).orElse(null);
    }

    @Override
    public Status deleteById(Long id) {
        Status statusForDelete = findById(id);
        if (statusForDelete != null)
            statusRepository.deleteById(id);
        return statusForDelete;
    }
}
