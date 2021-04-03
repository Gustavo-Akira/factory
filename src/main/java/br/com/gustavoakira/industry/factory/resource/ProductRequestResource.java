package br.com.gustavoakira.industry.factory.resource;

import br.com.gustavoakira.industry.factory.model.ProductRequest;
import br.com.gustavoakira.industry.factory.service.ProductRequestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ProductRequestResource {
    @Autowired
    private ProductRequestService service;

    @GetMapping("/product-requests")
    public ResponseEntity<List<ProductRequest>> getProductRequests(){
        return ResponseEntity.ok(service.getProductRequests());
    }

    @GetMapping("/product-request/{id}")
    public ResponseEntity<ProductRequest> getProductRequest(@PathVariable Long id){
        return ResponseEntity.ok(service.getProductRequest(id));
    }

    @DeleteMapping("product-request/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) throws JsonProcessingException {
        service.deleteRequest(id);
        return ResponseEntity.noContent().build();
    }
}
