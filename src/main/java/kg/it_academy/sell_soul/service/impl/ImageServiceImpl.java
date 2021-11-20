package kg.it_academy.sell_soul.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kg.it_academy.sell_soul.entity.Image;
import kg.it_academy.sell_soul.repository.ImageRepository;
import kg.it_academy.sell_soul.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ImageServiceImpl implements ImageService {
    private static final String CLOUDINARY_URL = "cloudinary://839826362311982:neFJEViwPCkJPMba1bfH1Jqlb4Q@dt212gr4m";

    private final ImageRepository imageRepository;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public String saveImageInCloudinary(MultipartFile multipartFile) {
        File file;

        try {
            file = Files.createTempFile(System.currentTimeMillis() + "",
                            Objects.requireNonNull(multipartFile.getOriginalFilename())
                                    .substring(multipartFile.getOriginalFilename().length() - 4))
                    .toFile();

            multipartFile.transferTo(file);

            Cloudinary cloudinary = new Cloudinary(CLOUDINARY_URL);
            Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            return ((String) uploadResult.get("url"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Image saveImage(String url) {
        return imageRepository.save(Image.builder()
                .url(url)
                .build());
    }

    @Override
    public List<Image> getAll() {
        return imageRepository.findAll();
    }

    @Override
    public Image saveImage(MultipartFile multipartFile) {
        return saveImage(saveImageInCloudinary(multipartFile));
    }
}
