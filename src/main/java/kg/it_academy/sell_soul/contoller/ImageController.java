package kg.it_academy.sell_soul.contoller;

import kg.it_academy.sell_soul.entity.Image;
import kg.it_academy.sell_soul.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/image")
public class ImageController {
    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping
    public List<Image> getAll() {
        return imageService.getAll();
    }

    @PostMapping
    public Image saveImage(@RequestParam(name = "file") MultipartFile file) {
        return imageService.saveImage(file);
    }
}
