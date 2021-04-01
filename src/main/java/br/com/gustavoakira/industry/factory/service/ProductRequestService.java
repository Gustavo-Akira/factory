package br.com.gustavoakira.industry.factory.service;

import br.com.gustavoakira.industry.factory.model.ProductRequest;
import br.com.gustavoakira.industry.factory.repository.ProductRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductRequestService {
    @Autowired
    private ProductRequestRepository repository;

    public void saveNewRequest(ProductRequest productRequest){
        repository.save(productRequest);
    }
}
