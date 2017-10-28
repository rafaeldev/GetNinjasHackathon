package br.com.seniors.controller;

import br.com.seniors.SMSProperties;
import br.com.seniors.model.ServiceOrder;
import br.com.seniors.repository.OrderRepository;
import br.com.seniors.service.CodeGeneratorService;
import br.com.seniors.service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Dell
 */
@Controller
public class SMSController {

    SMSProperties smsp;

    public SMSController(SMSProperties smsp) {
        this.smsp = smsp;
    }

    @RequestMapping("/send")
    @ResponseBody
    public String getKey() {
        return smsp.getKey();
    }

    @Autowired
    SMSService smss;

    @Autowired
    CodeGeneratorService codeGeneratorService;

    @Autowired
    OrderRepository orderRepository;

    @RequestMapping("/sms")
    @ResponseBody
    public void testSMS() {
        ServiceOrder order = new ServiceOrder();

        order.setPhoneNumber("11967107991");
        order.setToken(codeGeneratorService.getCode());
        orderRepository.save(order);

        smss.sendSMS(order);
    }

    @RequestMapping("/confirm-order/{token}")
    public String confirmOrder(@PathVariable("token") String token) {
        ServiceOrder order = orderRepository.findByToken(token);
        order.setActive(Boolean.TRUE);
        order.setToken(null);

        orderRepository.save(order);
        
        return "redirect:/perobas";
    }

}
