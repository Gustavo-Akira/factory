package br.com.gustavoakira.industry.factory.service;

import br.com.gustavoakira.industry.factory.messenger.Messenger;
import br.com.gustavoakira.industry.factory.model.ProductRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinishRequestService {
    @Autowired
    private Messenger messenger;

    @Autowired
    private ObjectMapper mapper;

    public void finish(ProductRequest productRequest) throws JsonProcessingException {
        String mapped = mapper.writeValueAsString(productRequest);
        messenger.send("FinishedProduct",mapped);
    }
}
