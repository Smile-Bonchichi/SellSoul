package kg.it_academy.sell_soul.service;

import kg.it_academy.sell_soul.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    String saveImageInCloudinary(MultipartFile multipartFile);

    Image saveImage(String url);

    List<Image> getAll();

    Image saveImage(MultipartFile multipartFile);
}
