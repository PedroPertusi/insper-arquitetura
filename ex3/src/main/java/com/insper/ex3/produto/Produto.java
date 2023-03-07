package com.insper.ex3.produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Produto {
    
    private String id;

    @NonNull
    @NotNull
    @NotBlank
    private String nome;

    @NonNull
    @NotBlank
    @NotNull
    private Integer estoque;


    @NonNull
    @NotBlank
    @NotNull
    private Float preco;


}