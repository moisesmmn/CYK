import cyk.CYKGramatica;
import gerenciadorArquivos.GerenciadorArquivos;
import java.io.IOException;

import javax.swing.JOptionPane;

public class CykExample {

    public static void main(String[] args) {

        try {
         
            String arquivo = JOptionPane.showInputDialog("Informe o nome do arquivo da gramatica\n Exemplo: (<nomeArquivo>.txt)");

            CYKGramatica gramatica = GerenciadorArquivos.readFromFile(arquivo);

            String palavra = JOptionPane.showInputDialog("Informa a palvra a ser reconhecida");

            boolean palavraAceita = gramatica.palavraAceita(palavra);

            if(palavraAceita){
                JOptionPane.showMessageDialog(null, "Palavra Aceita");
            }else{
                JOptionPane.showMessageDialog(null, "Palavra não Aceita");
            }

            System.out.println();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
