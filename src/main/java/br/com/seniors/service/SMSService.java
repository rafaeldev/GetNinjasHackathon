package br.com.seniors.service;

import br.com.seniors.SMSProperties;
import br.com.seniors.model.ServiceOrder;
import java.net.URI;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Dell
 */
@Service
public class SMSService {

    private static final String API_URL = "https://platform.clickatell.com/messages/http/send?apiKey=#KEY#&to=55#TO_NUMBER#&content=#MSG#";
    private static final String KEY = "#KEY#";
    private static final String TO = "#TO_NUMBER#";
    private static final String MSG = "#MSG#";

    private final Random RAND = new Random();
    
    @Autowired
    SMSProperties smsp;
    
    public void sendSMS(ServiceOrder order) {
        RestTemplate restTemplate = new RestTemplate();
        
        String url = API_URL
                .replaceFirst(KEY, smsp.getKey())
                .replaceFirst(TO, order.getPhoneNumber())
                .replaceFirst(MSG, "http://192.168.60.93:8080/confirm-order/" + order.getToken());
        
        restTemplate.getForObject(url, String.class);
    }

}
