package com.mmss.spring.compasso.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mmss.spring.compasso.dto.ClienteDTO;
import com.mmss.spring.compasso.exception.RegraNegocioException;
import com.mmss.spring.compasso.model.Cliente;
import com.mmss.spring.compasso.repository.Clientes;
import com.mmss.spring.compasso.util.StringUtil;

@Service
public class ClienteService {
	
	
	private Clientes clientes;

    public ClienteService( Clientes clientes ) {
        this.clientes = clientes;
    }
	
    public Cliente save(Cliente cliente ){
    	if (!cliente.getSexo().equalsIgnoreCase("M") && !cliente.getSexo().equalsIgnoreCase("F")) {			
			throw new RegraNegocioException("Valor para campo sexo - M ou F");
		}
    	
    	if (!StringUtil.verificarIdadeComDataAniversario(cliente.getIdade(), cliente.getDataaniversario())) {		
			throw new RegraNegocioException("Idade informada não é a mesma de nascimento!");
		}
    	return clientes.save(cliente);
     
    }
    
    public List<ClienteDTO> findAll(){
    	List<Cliente> listaClientes = clientes.findAll();
        List<ClienteDTO> listaClientesDto = new ArrayList<ClienteDTO>();
        listaClientes.forEach(cliente ->{
        	listaClientesDto.add(convertClienteXClienteDTO(cliente));
        });
		if(StringUtil.isListNotNullNotEmpty(listaClientesDto)) {
			return listaClientesDto;
		}
		
		throw  new RegraNegocioException("Cliente(s) não encontrado(s)");
        
        
    }
  
    public Cliente findById(Integer id){
    	 return clientes
                 .findById(id)
                 .orElseThrow(() ->
                         new RegraNegocioException("Cliente não encontrado"));
    }
    
    public void update( Cliente cliente ) throws ResponseStatusException{
        clientes
                .findById(cliente.getId())
                .map( clienteExistente -> {                    
                    clienteExistente.setNome(cliente.getNome());
                    clientes.save(clienteExistente);
                    return clienteExistente;                   
                }).orElseThrow(() -> new RegraNegocioException("Cliente não encontrado") );
    }
        
    public void delete(Integer id ){
        clientes.findById(id)
                .map( cliente -> {
                	clientes.delete(cliente );
                    return cliente;
                })
                .orElseThrow(() -> new RegraNegocioException("Cliente não encontrado") );

    }
    
    public List<Cliente> findAll(Cliente cliente){
    	ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );
		Example<Cliente> example = Example.of(cliente, matcher);
        return clientes.findAll(example);
    }
    
    public  List<Cliente> findByNome(String nome){
    	ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );
    	Cliente cliente  = new Cliente();
    	cliente.setNome(nome);
		Example<Cliente> example = Example.of(cliente, matcher);		
        List<Cliente> listaClientes = clientes.findAll(example);
        if(StringUtil.isListNotNullNotEmpty(listaClientes)) {
			return listaClientes;
		}
		
		throw  new RegraNegocioException("Cliente não encontrado");

    }  
    
    private ClienteDTO convertClienteXClienteDTO(Cliente cliente) {
    	SimpleDateFormat frt = new SimpleDateFormat("dd/MM/yyyy");
    	ClienteDTO clienteDTO = new ClienteDTO();
    	clienteDTO.setCidade(cliente.getCidade());
    	clienteDTO.setId(cliente.getId());
    	clienteDTO.setIdade(cliente.getIdade());
    	clienteDTO.setNome(cliente.getNome());
    	clienteDTO.setSexo(cliente.getSexo());
    	String data = frt.format(cliente.getDataaniversario());
    	clienteDTO.setDataaniversario(data);
		return clienteDTO;
    }

}
