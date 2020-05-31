package com.dimka.telegram.response;

import com.dimka.telegram.dto.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component("300")
public class JPGResponseDispatcher implements ResponseDispatcher {

    @SneakyThrows
    @Override
    public List<PartialBotApiMethod> dispatchResponse(Update update, Response response) {
        String content = (String) response.getContent();
        byte[] decode = Base64.getDecoder().decode(content);
        SendPhoto photo;
        try (ByteArrayInputStream bis = new ByteArrayInputStream(decode)) {
            BufferedImage bImage2 = ImageIO.read(bis);
            File image = new File("output.jpg");
            ImageIO.write(bImage2, "jpg",  image);
            photo = new SendPhoto()
                    .setPhoto("output.jpg", new FileInputStream(image))
                    .setChatId(update.getMessage().getChatId());
            boolean delete = image.delete();
            log.info("photo delete result: " + delete);
        }
        return Collections.singletonList(photo);
    }
}
