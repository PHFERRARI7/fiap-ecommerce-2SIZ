package br.com.fiap.ecommerce.api.categoria;

import br.com.fiap.ecommerce.api.categoria.Categoria;

public record DadosListagemCategoria(Long id, String nome) {

    public DadosListagemCategoria(Categoria categoria){

        this(categoria.getId(), categoria.getNome());
    }
}
