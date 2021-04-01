package br.com.gustavoakira.industry.factory.repository;

import br.com.gustavoakira.industry.factory.model.ProductRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRequestRepository extends JpaRepository<ProductRequest,Long> {
}
