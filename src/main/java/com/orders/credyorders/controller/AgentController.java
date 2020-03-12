package com.orders.credyorders.controller;

import com.orders.credyorders.model.Agents;
import com.orders.credyorders.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agents")
public class AgentController {

    @Autowired
    private AgentService agentService;
   // http://localhost:2020/agents/agents
    @GetMapping(value = "/agents", produces = {"application/json"})
    public ResponseEntity<?> listAllAgents(){
        List<Agents> theAgents = agentService.findAll();
        return new ResponseEntity<>(theAgents, HttpStatus.OK);
    }


}
