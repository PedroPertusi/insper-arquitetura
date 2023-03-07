package com.insper.ex3.compra;

import lombok.Getter;
import lombok.Setter;
import com.insper.ex3.produto.*;

@Getter
@Setter
public class Item {
    private Produto produto;
    private Float preco;
}
