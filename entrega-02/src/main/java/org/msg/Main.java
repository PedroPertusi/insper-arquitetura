import usuario.Usuario;
import main.java.org.msg.mensagem.Mensagem;
import main.java.org.msg.mensagem.MensagemArq;
import main.java.org.msg.mensagem.MensagemTxt;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Pedro",18);
        Mensagem mensagem = new Mensagem(usuario,"pedrocas msg");
        System.out.println(mensagem.getUsuario().getNome());
        MensagemTxt mensagemtxt = new MensagemTxt(usuario,"pedrocas msg2","Ola, me chamo Pedro e tenho 18 anos.");
        System.out.println(mensagemtxt.getUsuario().getNome());
        System.out.println(mensagemtxt.getConteudo());
        MensagemArq mensagemarq = new MensagemArq(usuario,"pedrocas msg3","Png");
        System.out.println(mensagemarq.getUsuario().getNome());
        System.out.println(mensagemarq.getTipo());
    }
}
