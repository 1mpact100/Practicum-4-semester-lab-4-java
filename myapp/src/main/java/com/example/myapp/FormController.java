package com.example.myapp;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FormController {
    @GetMapping("/form")
    public String form() {
        return "form";
    }

    @PostMapping("/size2json")
    @ResponseBody
    public Map<String, Object> size2json(@RequestParam("image") MultipartFile file) throws IOException {
        BufferedImage image = ImageIO.read(file.getInputStream());
        
        if (!file.getContentType().equals("image/png")) {
            return Map.of("result", "invalid filetype");
        }

        int width = image.getWidth();
        int height = image.getHeight();

        return Map.of("width", width, "height", height);
    }
}
