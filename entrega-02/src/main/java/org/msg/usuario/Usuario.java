package usuario;

// import java.util.ArrayList;

public class Usuario {
    private String nome;
    private Integer idade;
    // private List<Mensagem> mensagemLista = new ArrayList<>();

    public Usuario(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    // public List<Mensagem> getMensagemLista() {
    //     return mensagemLista;
    // }

    // public void postMensagem(Mensagem mensagem) {
    //     mensagemLista.add(mensagem);
    // }

    // public void deleteMensagem(Mensagem mensagem) {
    //     mensagemLista.remove(mensagem);
    // }

    


}
