package br.com.gustavoakira.industry.factory.service;

import br.com.gustavoakira.industry.factory.model.ProductRequest;
import br.com.gustavoakira.industry.factory.repository.ProductRequestRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductRequestService {
    @Autowired
    private ProductRequestRepository repository;

    @Autowired
    private FinishRequestService service;

    public void saveNewRequest(ProductRequest productRequest){
        repository.save(productRequest);
    }

    public void deleteRequest(Long id) throws JsonProcessingException {
        ProductRequest request = getProductRequest(id);
        repository.delete(request);
        service.finish(request);
    }

    public ProductRequest getProductRequest(Long id){
        return repository.findById(id).orElseThrow();
    }

    public List<ProductRequest> getProductRequests(){
        return  repository.findAll();
    }
}
