package main.java.com.locacao.Model;

import java.sql.Date;
import java.sql.Time;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("locacoes")
public class TipoLocacaoModel {

    @Id
    private String id;
    private String marca;
    private String modelo;
    private float num_passageiros;
    private float valor_locacao;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public float getNum_passageiros() {
        return num_passageiros;
    }
    public void setNum_passageiros(float num_passageiros) {
        this.num_passageiros = num_passageiros;
    }
    public float getValor_locacao() {
        return valor_locacao;
    }
    public void setValor_locacao(float valor_locacao) {
        this.valor_locacao = valor_locacao;
    }
}

@Document("locacoes")
public class LocacaoModel {

    @Id
    private String id_loc;
    private String id_veículo;
    private String id_cliente;
    private int dias;
    
    public String getId_loc() {
        return id_loc;
    }
    public void setId_loc(String id_loc) {
        this.id_loc = id_loc;
    }
    public String getId_veículo() {
        return id_veículo;
    }
    public void setId_veículo(String id_veículo) {
        this.id_veículo = id_veículo;
    }
    public String getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }
    public int getDias() {
        return dias;
    }
    public void setDias(int dias) {
        this.dias = dias;
    }

    
}

