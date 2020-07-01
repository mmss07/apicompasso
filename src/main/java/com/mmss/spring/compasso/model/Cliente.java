package com.mmss.spring.compasso.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length = 100)
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;
    
    @Column(name = "sexo", length = 1)
    @NotEmpty(message = "{campo.sexo.obrigatorio}")    
    private String sexo;
    
    @Column(name = "dataaniversario")
    @NotNull(message = "{campo.data.aniversario.obrigatorio}")
    private Date dataaniversario;
    
    @Column(name = "idade")
    @NotNull(message = "{campo.idade.obrigatorio}")
    private Integer idade;
    
    @Column(name = "cidade", length = 100)
    @NotEmpty(message = "{campo.cidade.obrigatorio}")
    private String cidade;

}
