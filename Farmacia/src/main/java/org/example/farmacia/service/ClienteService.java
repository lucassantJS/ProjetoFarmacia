package org.example.farmacia.service;

import org.example.farmacia.model.ClienteModel;
import org.example.farmacia.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteModel> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<ClienteModel> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public ClienteModel save(ClienteModel cliente) {
        return clienteRepository.save(cliente);
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    public ClienteModel update(Long id, ClienteModel cliente) {
        if (clienteRepository.existsById(id)) {
            cliente.setIdCliente(id);
            return clienteRepository.save(cliente);
        } else {
            throw new RuntimeException("Cliente não encontrado para o ID :: " + id);
        }
    }
}
