package com.mmss.spring.compasso.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
	
    private Integer id;
    private String nome;
    private String sexo;
    private String dataaniversario;
    private int idade;
    private String cidade;

}
