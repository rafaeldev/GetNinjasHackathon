package br.com.seniors.controller;

import br.com.seniors.model.Service;
import br.com.seniors.model.ServiceGroup;
import br.com.seniors.model.ServiceTarget;
import br.com.seniors.repository.ServiceGroupRepository;
import br.com.seniors.repository.ServiceRepository;
import br.com.seniors.repository.ServiceTargetRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Dell
 */
@Controller
public class ServicesController {
    
    @RequestMapping("/test-gson")
    @ResponseBody
    public String page(Model model) {
        String test = "{ \"name1\": \"Abobora\" }";
        
        ServiceTarget result = new Gson().fromJson(test, ServiceTarget.class);
        
        return result.getName();
    }
    
    @Autowired
    ServiceTargetRepository serviceTargetRepository;
    
    @RequestMapping("/targets")
    @ResponseBody
    public Iterable<ServiceTarget> getTargets() {
        return serviceTargetRepository.findAll();
    }
    
    @Autowired
    ServiceGroupRepository serviceGroupRepository;
    
    @RequestMapping("/groups")
    @ResponseBody
    public Iterable<ServiceGroup> getGroups() {
        return serviceGroupRepository.findAll();
    }
    
    @RequestMapping("/groups/{serviceTargetId}")
    @ResponseBody
    public Iterable<ServiceGroup> getGroupsById(@PathVariable("serviceTargetId") Integer id) {
        return serviceGroupRepository.findByTarget_Id(id);
    }
    
    @Autowired
    ServiceRepository serviceRepository;
    
    @RequestMapping("/services")
    @ResponseBody
    public Iterable<ServiceGroup> getServices() {
        return serviceGroupRepository.findAll();
    }
    
    @RequestMapping("/services/{serviceGroupId}")
    @ResponseBody
    public Iterable<Service> getServicesById(@PathVariable("serviceGroupId") Integer id) {
        return serviceRepository.findByGroup_Id(id);
    }
    
    
}
