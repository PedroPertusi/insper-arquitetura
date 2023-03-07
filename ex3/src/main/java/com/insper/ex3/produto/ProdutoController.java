package com.insper.ex3.produto;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> getProdutos() {
        return produtoService.listarProdutos();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Produto salvarProduto(@RequestBody @Valid Produto produto) {
        return produtoService.salvarProduto(produto);
    }
}
