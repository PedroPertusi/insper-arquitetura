package com.insper.ex3.produto;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service //eh um bin gerenciavel do spring
public class ProdutoService {
    
    private List<Produto> produtos = new ArrayList<>();


    public List<Produto> listarProdutos() {
        return produtos;
    }

    public Produto salvarProduto(Produto produto) {
        produto.setId(UUID.randomUUID().toString());
        produtos.add(produto);
        return produto;
    }

//    public Produto buscaProduto(String id) {
//        for (Produto produtos : prod) {
//            return produtos;
//        }
//    }
}
