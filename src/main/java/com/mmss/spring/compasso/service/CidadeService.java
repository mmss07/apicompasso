package com.mmss.spring.compasso.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mmss.spring.compasso.model.Cidade;
import com.mmss.spring.compasso.repository.Cidades;
import com.mmss.spring.compasso.util.StringUtil;

@Service
public class CidadeService {
	
	private Cidades cidades;

    public CidadeService( Cidades cidades ) {
        this.cidades = cidades;
    }
    
    public Cidade getCidadeById(Integer id ){
        return cidades
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Cidade não encontrado"));
    }
    
    public List<Cidade> getCidadeByUf(String uf ){
    	ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );
    	Cidade cidade  = new Cidade();
    	cidade.setUf(uf);
		Example<Cidade> example = Example.of(cidade, matcher);
		List<Cidade> listaCidades = cidades.findAll(example);
		if(!StringUtil.isListNotNullNotEmpty(listaCidades)) {
			return listaCidades;
		}
		
		throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Cidade não encontrada");
		
    }
    
    public List<Cidade> getCidadeByNome(String uf ){
    	ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );
    	Cidade cidade  = new Cidade();
    	cidade.setNome(uf);
		Example<Cidade> example = Example.of(cidade, matcher);		
		List<Cidade> listaCidades = cidades.findAll(example);
		if(!StringUtil.isListNotNullNotEmpty(listaCidades)) {
			return listaCidades;
		}
		
		throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Cidade não encontrada");
    }
    
    public Cidade save(Cidade cidade ){
    	if(!StringUtil.validaUf(cidade.getUf())) {
    		 throw new ResponseStatusException(HttpStatus.NO_CONTENT,"Uf inválida");
    	}
    	cidade.setUf(cidade.getUf().toUpperCase());
        return cidades.save(cidade);
    }
	
	public void delete(Integer id ){
        cidades.findById(id)
                .map( cidade -> {
                    cidades.delete(cidade );
                    return cidade;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cidade não encontrada") );

    }	
}
