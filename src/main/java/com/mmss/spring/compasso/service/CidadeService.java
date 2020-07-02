package com.mmss.spring.compasso.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.mmss.spring.compasso.exception.RegraNegocioException;
import com.mmss.spring.compasso.model.Cidade;
import com.mmss.spring.compasso.repository.Cidades;
import com.mmss.spring.compasso.util.StringUtil;

@Service
public class CidadeService {
	
	private Cidades cidades;

    public CidadeService( Cidades cidades ) {
        this.cidades = cidades;
    }
    
    public Cidade getCidadeById(int id ){
        return cidades
                .findById(id)
                .orElseThrow(() ->
                        new RegraNegocioException("Cidade não encontrado"));
    }
    
    public List<Cidade> getCidadeByUf(String uf ){
    	if(!StringUtil.validaUf(uf)) {
   		 	throw new RegraNegocioException("Uf inválida");
    	}
    	ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );
    	Cidade cidade  = new Cidade();
    	cidade.setUf(uf);
		Example<Cidade> example = Example.of(cidade, matcher);
		List<Cidade> listaCidades = cidades.findAll(example);
		if(StringUtil.isListNotNullNotEmpty(listaCidades)) {
			return listaCidades;
		}
		
		throw  new RegraNegocioException("Cidade não encontrada");
		
    }
    
    public List<Cidade> getCidadeByNome(String nome ){
    	ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );
    	Cidade cidade  = new Cidade();
    	cidade.setNome(nome);
		Example<Cidade> example = Example.of(cidade, matcher);		
		List<Cidade> listaCidades = cidades.findAll(example);
		if(StringUtil.isListNotNullNotEmpty(listaCidades)) {
			return listaCidades;
		}
		
		throw  new RegraNegocioException("Cidade não encontrada");
    }
    
    public Cidade save(Cidade cidade ){
    	if(!StringUtil.validaUf(cidade.getUf())) {
    		 throw new RegraNegocioException("Uf inválida");
    	}
    	cidade.setUf(cidade.getUf().toUpperCase());
        return cidades.save(cidade);
    }
	
	public void delete(int id ){
        cidades.findById(id)
                .map( cidade -> {
                    cidades.delete(cidade );
                    return cidade;
                })
                .orElseThrow(() -> new RegraNegocioException("Cidade não encontrada") );

    }	
	
	public List<Cidade> findAll(){
    	List<Cidade> listaCidade = cidades.findAll();
        
		if(StringUtil.isListNotNullNotEmpty(listaCidade)) {
			return listaCidade;
		}
		
		throw  new RegraNegocioException("Cidade não encontrada");
        
        
    }
	
}
