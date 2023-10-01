public class DescriptografaComFrequencia {
    public static void main(String[] args) {
        String mensagemCifrada = "BRGTGCGCJKSCNSTVGCRKCNGJXSYBNBG.CKLKCZBGCJKCDBACXKTRKTCPGTBVCXTKNWGVBVCRKCVGZG,CBZBLWVBZRGCJKZVBEKZVCNWDTBRBV.";

        // Calcula a frequência das letras na mensagem cifrada
        int[] frequenciaCifrada = new int[26]; // Uma posição para cada letra do alfabeto
        for (char letra : mensagemCifrada.toCharArray()) {
            if (Character.isLetter(letra)) {
                letra = Character.toUpperCase(letra); // Transforma para maiúscula para simplificar
                int indice = letra - 'A'; // Obtém o índice da letra no alfabeto
                frequenciaCifrada[indice]++;
            }
        }

        // Frequência esperada das letras em português (exemplo)
        int[] frequenciaEsperada = {14, 2, 5, 4, 13, 1, 2, 1, 7, 0, 0, 8, 4, 5, 7, 2, 0, 6, 6, 9, 4, 2, 1, 2, 0, 1};

        // Mapeia as letras cifradas para as letras mais prováveis com base na frequência
        char[] correspondentes = new char[26];
        for (int i = 0; i < 26; i++) {
            int maxFrequencia = 0;
            int indiceMaxFrequencia = 0;
            for (int j = 0; j < 26; j++) {
                if (frequenciaCifrada[j] > maxFrequencia) {
                    maxFrequencia = frequenciaCifrada[j];
                    indiceMaxFrequencia = j;
                }
            }
            frequenciaCifrada[indiceMaxFrequencia] = -1; // Marcamos a letra como usada
            correspondentes[indiceMaxFrequencia] = (char) ('A' + i);
        }

        // Descriptografa a mensagem substituindo as letras cifradas pelos correspondentes mais prováveis
        StringBuilder mensagemDescriptada = new StringBuilder();
        for (char letra : mensagemCifrada.toCharArray()) {
            if (Character.isLetter(letra)) {
                letra = Character.toUpperCase(letra); // Transforma para maiúscula
                int indice = letra - 'A'; // Obtém o índice da letra no alfabeto
                char correspondente = correspondentes[indice];
                if (Character.isLowerCase(letra)) {
                    correspondente = Character.toLowerCase(correspondente); // Mantém o caso original
                }
                mensagemDescriptada.append(correspondente);
            } else {
                mensagemDescriptada.append(letra); // Mantém caracteres não alfabéticos inalterados
            }
        }

        // Imprime a mensagem descriptografada
        System.out.println(mensagemDescriptada.toString());
    }
}
