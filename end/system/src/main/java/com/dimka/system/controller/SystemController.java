package com.dimka.system.controller;

import com.dimka.system.utils.SystemUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

@Slf4j
@RestController
public class SystemController {

    @PostMapping("/system/state/shutdown")
    public void shutDown() throws IOException {
      log.info("shutting down");
      SystemUtils.shutDown();
    }

    @GetMapping("/system/screenshot")
    public void getScreenshot(HttpServletResponse response) throws Exception {
        ImageIO.write(SystemUtils.getScreenShot(), "jpg", response.getOutputStream());
    }
}
