package com.example.chat.controllers;

import com.example.chat.domain.Mensaje;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.Random;

@Controller
public class ChatController {

    private String[] colors = {"red", "blue", "green"};

    @MessageMapping("/mensaje")
    @SendTo("/chat/mensaje")
    public Mensaje requestMessage(Mensaje mensaje){
        mensaje.setFecha(new Date().getTime());
        if (mensaje.getTipo().equals("NUEVO_USUARIO")){
            mensaje.setColor(colors[new Random().nextInt(colors.length)]);
            mensaje.setTexto(mensaje.getUsername() + " se ha conectado.");
        }
        return mensaje;
    }

    @MessageMapping("/escribiendo")
    @SendTo("/chat/escribiendo")
    public String writing(String username){
        return username.concat(" esta escribiendo ...");
    }

}
