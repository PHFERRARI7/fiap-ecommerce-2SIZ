package br.com.fiap.ecommerce.api.produto;

import br.com.fiap.ecommerce.api.categoria.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name="produtos")
@Entity(name = "Produto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    /*
    nome: obrigatório, 3-100 caracteres
    preco: obrigatório, maior que 0
    SKU: obrigatório e único no sistema, sem espaços em branco
    descrição: opcional, até 255 caracteres
    estoque: obrigatório, inteiro > 0
    categoria: obrigatório, deve existir no banco
     */

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private BigDecimal preco;
    private String sku;
    private String descricao;
    private int estoque;

    @ManyToOne(fetch = FetchType.LAZY) // somente busca a categoria no banco se for usar diretamente
    @JoinColumn(name = "categoria_id") // define a coluna de junção (relação categoria x produto)
    private Categoria categoria;

    private int ativo;


}
