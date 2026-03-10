package br.com.fiap.ecommerce.api.categoria;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosCadastroCategoria(

        @NotBlank // Não aceita nulos ou espaços em branco
        @Size (min = 3, max = 60) // define tamanho mínimo e máximo
        @Column(unique = true) // Obriga valores não repetidos
        String nome,

        @Size(max = 255) // Tamanho máximo
        String descricao) {

}
