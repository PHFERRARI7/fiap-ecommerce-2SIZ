package br.com.fiap.ecommerce.api.produto;

/*
    nome: obrigatório, 3-100 caracteres
    preco: obrigatório, maior que 0
    SKU: obrigatório e único no sistema, sem espaços em branco
    descrição: opcional, até 255 caracteres
    estoque: obrigatório, inteiro > 0
    categoria: obrigatório, deve existir no banco
     */

import br.com.fiap.ecommerce.api.categoria.Categoria;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record DadosCadastroProduto(

        @NotBlank
        @Size(min=3, max=100)
        String nome,

        @NotNull
        @Positive
        @Digits(integer = 10, fraction = 2) // São 8 números antes da vírgula e 2 depois, total de 10
        BigDecimal preco,

        @NotBlank
        // No regex:
        // ^ = Início da String
        // $ = Final da String
        // \\S = Qualquer caracter que não seja espaço
        // + um ou mais caracteres
        @Pattern(regexp = "^\\S+$", message = "SKU não pode conter espaços em branco")
        String sku,

        @Size(max = 255)
        String descricao,

        @NotNull
        @PositiveOrZero
        int estoque,

        @NotNull
        Long categoriaId

) {
}
