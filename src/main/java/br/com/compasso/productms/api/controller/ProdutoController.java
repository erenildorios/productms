package br.com.compasso.productms.api.controller;

import br.com.compasso.productms.domain.Produto;
import br.com.compasso.productms.exception.EntidadeNaoEncontradaException;
import br.com.compasso.productms.repository.ProdutoRepository;
import br.com.compasso.productms.services.ProdutoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoRepository produtoRepository;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto adicionar(@RequestBody @Valid Produto produto) {

        return produtoService.salvar(produto);
    }


    @PutMapping("/{produtoId}")
    public ResponseEntity<Produto> atualizar(@PathVariable String produtoId,
                                             @RequestBody @Valid Produto produto) {
        Optional<Produto> produtoAtual = produtoRepository.findById(produtoId);

        if (produtoAtual.isPresent()) {
            BeanUtils.copyProperties(produto, produtoAtual.get(), "id");

            Produto produtoSalvo = produtoService.atualiza(produtoAtual.get());

            return ResponseEntity.ok(produtoSalvo);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{produtoId}")
    public ResponseEntity<Produto> buscar(@PathVariable String produtoId) {
        Optional<Produto> produto = produtoRepository.findById(produtoId);

        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        }

        return ResponseEntity.notFound().build();
    }


    @GetMapping
    public List<Produto> listar() {

        return produtoRepository.findAll();
    }

    @GetMapping("/search")
    public HashSet<Produto> search(Optional<BigDecimal> min_price, Optional<BigDecimal> max_price, Optional<String> q) {
        return produtoService.search(min_price, max_price, q);
    }

    @DeleteMapping("/{produtoId}")
    public ResponseEntity<?> remover(@PathVariable String produtoId) {
        try {
            produtoService.excluir(produtoId);
            return ResponseEntity.ok().build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
