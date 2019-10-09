package com.orders.credyorders.service;

import com.orders.credyorders.model.Agents;
import com.orders.credyorders.repos.AgentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "agentService")
public class AgentServiceImpl implements AgentService{

    @Autowired
    private AgentsRepository agerepos;


    @Override
    public List<Agents> findAll() {

        List<Agents> list = new ArrayList<>();
        agerepos.findAll().iterator().forEachRemaining(list::add);
        return list;


    }
}
