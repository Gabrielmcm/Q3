package main.java.com.clientes.clientes.Shared;

public class ClienteDTO {
    
    private String id;
    private String nome;
    private int numero_cnh;
    private Date data_nasc;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getNumero_cnh() {
        return numero_cnh;
    }
    public void setNumero_cnh(int numero_cnh) {
        this.numero_cnh = numero_cnh;
    }
    public Date getData_nasc() {
        return data_nasc;
    }
    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }
}
