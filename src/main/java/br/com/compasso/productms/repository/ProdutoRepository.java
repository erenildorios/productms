package br.com.compasso.productms.repository;

import br.com.compasso.productms.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, String> {

    HashSet<Produto> findByPriceBetween(BigDecimal priceInicial, BigDecimal priceFinal);

    HashSet<Produto> findByNameOrDescription(String name, String description);

}
