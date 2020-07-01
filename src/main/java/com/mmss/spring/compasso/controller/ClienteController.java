package com.mmss.spring.compasso.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mmss.spring.compasso.dto.ClienteDTO;
import com.mmss.spring.compasso.model.Cliente;
import com.mmss.spring.compasso.service.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/clientes")
@Api("Api Clientes")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController( ClienteService clienteService ) {
        this.clienteService = clienteService;
    }

    @GetMapping("{id}") 
    @ApiOperation("Obter detalhes de um cliente")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Cliente encontrado"),
        @ApiResponse(code = 404, message = "Cliente não encontrado para o ID informado")
    })
	public Cliente getClienteById(@PathVariable @ApiParam("Id do cliente") Integer id ){  
    	 return clienteService.findById(id);
    }
    
    @GetMapping("/nome/{nome}")
    @ApiOperation("Consulta clientes por nome")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Cliente(s) listado(s) com sucesso"),
        @ApiResponse(code = 400, message = "Erro de listagem")
    })
    public List<Cliente> getClienteByNome(
            @PathVariable
            @ApiParam("Nome do cliente") String nome ) throws ResponseStatusException{
    	
    	return clienteService.findByNome(nome);    	
	
    }

    @PostMapping
    @ResponseStatus(CREATED)
    @ApiOperation("Salva um novo cliente")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Cliente salvo com sucesso"),
            @ApiResponse(code = 400, message = "Erro de validação")
    })
	public Cliente save(@RequestBody @Valid @ApiParam("Novo Cliente") Cliente cliente) {
		return clienteService.save(cliente);

	}

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    @ApiOperation("Exclui um cliente pelo Id")
    public void delete( @PathVariable @ApiParam("Id do Cliente") Integer id ){
        clienteService.delete(id);

    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    @ApiOperation("Altera o nome de um cliente")
    public void update( @PathVariable Integer id,
                        @RequestBody @Valid  @ApiParam("Update Cliente") ClienteDTO clienteDto ){
    	Cliente cliente = new Cliente();
    	cliente.setId(id);
    	cliente.setNome(clienteDto.getNome());
        clienteService.update(cliente);
    }

    @GetMapping()
    @ApiOperation("Consulta todos os clientes")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Cliente(s) listado(s) com sucesso"),
        @ApiResponse(code = 400, message = "Erro de listagem")
    })
    public List<ClienteDTO> findClientes(){
        List<ClienteDTO> listaClientesDto = clienteService.findAll();                     
        return listaClientesDto; 
    }
    
}
