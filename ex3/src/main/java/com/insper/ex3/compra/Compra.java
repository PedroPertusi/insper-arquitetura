package com.insper.ex3.compra;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Compra {
    private String id;
    private LocalDateTime dataCompra;
    private List<Item> itens = new ArrayList<>();
}
