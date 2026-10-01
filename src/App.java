// Exercício didático: Construindo um Avaliador de Senhas em Java.
// Observação: isto é um exercício de lógica para praticar if, for, arrays e métodos;
// NÃO é um validador de senhas adequado para uso em produção.
public class App {

    public static void main(String[] args) {
        // Senhas fictícias usadas apenas para demonstrar cada caminho do avaliador.
        String[] senhasDeTeste = {
            "batata",     // muito curta
            "semnumero",  // tamanho ok, mas sem dígito
            "senha123",   // está na lista de senhas comuns
            "segredo123", // sem letra maiúscula
            "Segredo123"  // passa em todas as regras
        };

        for (String senhaFicticia : senhasDeTeste) {
            String resultado = avaliarSenha(senhaFicticia);
            System.out.println("Senha: " + senhaFicticia + " -> " + resultado);
        }
    }

    static String avaliarSenha(String senha) {
        // 1) Tamanho mínimo
        if (senha.length() < 8) {
            return "DICA: A senha deve ter no mínimo 8 caracteres.";
        }

        // 2) Deve conter ao menos um número
        boolean temNumero = false;
        for (int i = 0; i < senha.length(); i++) {
            if (Character.isDigit(senha.charAt(i))) {
                temNumero = true;
                break;
            }
        }
        if (!temNumero) {
            return "DICA: Adicione pelo menos um número à sua senha.";
        }

        // 3) Não pode ser uma senha comum/óbvia
        String[] senhasComuns = {"12345678", "senha123", "admin123"};
        for (String senhaComum : senhasComuns) {
            if (senha.equals(senhaComum)) {
                return "ALERTA: Esta senha é muito comum ou óbvia.";
            }
        }

        // 4) Deve conter ao menos uma letra maiúscula (missão do slide)
        boolean temMaiuscula = false;
        for (int i = 0; i < senha.length(); i++) {
            if (Character.isUpperCase(senha.charAt(i))) {
                temMaiuscula = true;
                break;
            }
        }
        if (!temMaiuscula) {
            return "DICA: Adicione pelo menos uma letra maiúscula à sua senha.";
        }

        // 5) Passou por todas as regras
        return "SUCESSO: Sua senha passou pelos critérios básicos!";
    }
}
