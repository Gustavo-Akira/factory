package br.com.gustavoakira.industry.factory.messenger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class RequestCreatedMessenger {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void send(String topic,String data){
        this.kafkaTemplate.send(topic,data);
    }
}
