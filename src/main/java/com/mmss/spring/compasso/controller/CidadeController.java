package com.mmss.spring.compasso.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mmss.spring.compasso.model.Cidade;
import com.mmss.spring.compasso.service.CidadeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/cidades")
@Api("Api Cidades")
public class CidadeController {

    private CidadeService cidadeService;
    
    public CidadeController( CidadeService cidadeService ) {
        this.cidadeService = cidadeService;
    }

    @GetMapping("{id}")
    @ApiOperation("Obter detalhes de uma cidade por id")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Cidade encontrada"),
        @ApiResponse(code = 404, message = "Cidade não encontrada para o ID informado")
    })
    public Cidade getCidadeById(
            @PathVariable
            @ApiParam("Id da cidade") int id ){
        return cidadeService.getCidadeById(id);                
    }
    
    @GetMapping("/uf/{uf}")
    @ApiOperation("Obter detalhe(s) da(s) cidade(s) por UF")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Cidade encontrada"),
        @ApiResponse(code = 400, message = "Erro de validação"),
        @ApiResponse(code = 404, message = "Cidade não encontrada para Uf informada")
    })
    public List<Cidade> getCidadeByUf (
            @PathVariable
            @ApiParam("Uf da cidade") String uf ){
        return cidadeService.getCidadeByUf(uf);                
    }
    
    @GetMapping("/nome/{nome}")
    @ApiOperation("Obter detalhe(s) da(s) cidade(s) por nome")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Cidade encontrada"),
        @ApiResponse(code = 404, message = "Cidade não encontrada para o Nome informado")
    })
    public List<Cidade> getCidadeByNome(
            @PathVariable
            @ApiParam("Nome da cidade") String nome ) {
        return cidadeService.getCidadeByNome(nome);                
    }
    
    @PostMapping
    @ResponseStatus(CREATED)
    @ApiOperation("Salva uma nova cidade")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Cidade salva com sucesso"),
            @ApiResponse(code = 400, message = "Erro de validação")
    })
    public Cidade save( @RequestBody @Valid @ApiParam("Nova Cidade") Cidade cidade ){    	
        return cidadeService.save(cidade);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    @ApiOperation("Exclui uma cidade")
    public void delete( @PathVariable @ApiParam("Id da Cidade") int id ){
    	cidadeService.delete(id);
    }
    
    @GetMapping()
    @ApiOperation("Consulta todas as cidades")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Cidade(s) listada(s) com sucesso"),
        @ApiResponse(code = 404, message = "Não existem cidade(s)  cadastradas no banco")
    })
    public List<Cidade> findAll(){
        List<Cidade> listaCidades = cidadeService.findAll();                     
        return listaCidades; 
    }
    
}
