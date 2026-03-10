package br.com.fiap.ecommerce.api.controller;

import br.com.fiap.ecommerce.api.categoria.Categoria;
import br.com.fiap.ecommerce.api.categoria.CategoriaRepository;
import br.com.fiap.ecommerce.api.categoria.DadosCadastroCategoria;
import br.com.fiap.ecommerce.api.categoria.DadosListagemCategoria;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Define que esta classe é um controller
@RequestMapping("categorias") // Define o caminho que receberá as requisições
public class CategoriaController {

    @Autowired // Spring instancia o objeto para nós
    private CategoriaRepository categoriaRepository;

    @Transactional // Rollback no banco em caso de erros
    @PostMapping // Recebe as requisições do tipo POST

    // Recebe o conteúdo de body e garante que é válido conforme as restrições do DTO
    public void cadastrarCategoria(@RequestBody @Valid DadosCadastroCategoria dados){
        categoriaRepository.save(new Categoria(dados));
    }

    @GetMapping // Recebe as requisições do tipo Get
    public List<DadosListagemCategoria> listarCategorias () {
        return categoriaRepository.findAll()
                .stream()
                .map(DadosListagemCategoria::new)
                .toList();
    }
}
