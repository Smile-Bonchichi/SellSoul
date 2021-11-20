package kg.it_academy.sell_soul.service.impl;

import kg.it_academy.sell_soul.entity.Status;
import kg.it_academy.sell_soul.exception.ApiFailException;
import kg.it_academy.sell_soul.repository.StatusRepository;
import kg.it_academy.sell_soul.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {
    private final StatusRepository statusRepository;

    @Autowired
    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

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
        Status status = statusRepository.findById(id).orElse(null);
        if (status == null)
            throw new ApiFailException("Не найден статус с таким id!");
        return status;
    }

    @Override
    public Status deleteById(Long id) {
        Status statusForDelete = findById(id);
        if (statusForDelete != null)
            statusRepository.deleteById(id);
        else
            throw new ApiFailException("Статус с таким id не найден!");
        return statusForDelete;
    }
}
