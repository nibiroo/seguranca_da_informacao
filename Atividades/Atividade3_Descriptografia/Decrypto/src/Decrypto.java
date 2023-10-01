import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Decrypto {
    private List<Character> mensagemToListaCaractere(String mensagem) {
        List<Character> listaDeCaractereMensagem = new ArrayList<>();

        for (int i = 0; i < mensagem.length(); i++) {
            char caractere = mensagem.charAt(i);
            listaDeCaractereMensagem.add(caractere);
        }
        return listaDeCaractereMensagem;
    }
    public void recorrenciaQtdeCaractere(String mensagem) {
        List<Character> characterList = mensagemToListaCaractere(mensagem);
        int contadorCaracterePai;
        List<Integer> characterListOrderByDesc = new ArrayList<>();

        for (Character caracterePai : characterList) {
            contadorCaracterePai = 0;
            for (Character caractereFilho : characterList) {
                if (caractereFilho == caracterePai) {
                    contadorCaracterePai++;
                }
            }
            characterListOrderByDesc.add(contadorCaracterePai);
        }
        System.out.println(characterListOrderByDesc);
    }
}
