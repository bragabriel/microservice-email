package com.gabriel.emailmicroservice.application.core.domain.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "addresses")
public class Address {
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
}
