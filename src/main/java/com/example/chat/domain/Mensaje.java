package com.example.chat.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Mensaje implements Serializable {
    private String texto;
    private Long fecha;
    private String username;
    private String tipo;
    private String color;
}
