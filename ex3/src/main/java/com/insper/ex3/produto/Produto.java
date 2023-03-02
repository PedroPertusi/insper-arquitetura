package com.insper.ex3.produto;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Produto {
    
    private String id;

    @NonNull
    private String nome;
    @NonNull
    private Integer estoque;
    @NonNull
    private Float preco;


}