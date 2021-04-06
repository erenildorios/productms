package br.com.compasso.productms.services;

import br.com.compasso.productms.domain.Produto;
import br.com.compasso.productms.exception.EntidadeNaoEncontradaException;
import br.com.compasso.productms.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvar(Produto produto) {

        //seta o ID do produto
        produto.setId(UUID.randomUUID().toString());

        return produtoRepository.save(produto);
    }

    public Produto atualiza(Produto produto) {

        return produtoRepository.save(produto);
    }


    public void excluir(String produtoId) {
        try {
            produtoRepository.deleteById(produtoId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de produto com código %s", produtoId));
        }
    }

    public HashSet<Produto> search(Optional<BigDecimal> min_price, Optional<BigDecimal> max_price, Optional<String> q) {
        HashSet<Produto> listaProdutos = new HashSet<>();

        if (q.isPresent()) {
            listaProdutos = produtoRepository.findByNameOrDescription(q.get(), q.get());
        }

        if (min_price.isPresent() && max_price.isPresent()) {
            listaProdutos.addAll(produtoRepository.findByPriceBetween(min_price.get(), max_price.get()));
        }



        return listaProdutos;

    }
}
