package br.com.gustavoakira.industry.factory.service;

import br.com.gustavoakira.industry.factory.dto.AddDTO;
import br.com.gustavoakira.industry.factory.dto.ResponseDTO;
import br.com.gustavoakira.industry.factory.messenger.Messenger;
import br.com.gustavoakira.industry.factory.model.ProductRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ListenerService {

    @Value("${topic.name.consumer")
    private String topicName;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private ProductRequestService service;

    @Autowired
    private Messenger messenger;


    @KafkaListener(topics = "${topic.name.consumer}",groupId = "RequestProduct")
    public void consume(ConsumerRecord<String,String> payload) throws JsonProcessingException {
        AddDTO dto = mapper.readValue(payload.value(), AddDTO.class);
        ProductRequest request = new ProductRequest();
        request.setProductId(dto.getProduct().getId());
        request.setQuantity(dto.getQuantity());
        request.setProductName(dto.getProduct().getName());
        service.saveNewRequest(request);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("accepted");
        responseDTO.setProduct(request.getProductName());
        responseDTO.setQuantity(request.getQuantity());
        String message = mapper.writeValueAsString(responseDTO);
        messenger.send("RequestCreated",message);
    }
}
