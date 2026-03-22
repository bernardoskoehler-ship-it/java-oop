public static class Usuario{
    private String nome;
    private String email;
    private String senha;
    private int tentativasRestantes = 3;

    Usuario(String nome, String email, String senha) {
        setNome(nome);
        setEmail(email);
        setSenha(senha);
    }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        }else {
            System.out.println("Nome invalido");
            this.nome = "placeHolder";
        }
    }
    public void setEmail(String email) {
        if(email != null && !email.trim().isEmpty() && email.contains("@")) {
            this.email = email;
        }else {
            System.out.println("Email invalido");
            this.email = "email@gmailcom";
        }
    }
    private void setSenha(String senha) {
        if(senha != null && !senha.trim().isEmpty() && senha.length() >= 6) {
            this.senha = senha;
        }else {
            System.out.println("Senha invalida");
            this.senha = "000000";
        }
    }
    public void fazerLogin(String email, String senha) {
        if(this.email.equals(email) && this.senha.equals(senha) && tentativasRestantes > 0) {
            System.out.println("Login realizado com sucesso!");
            System.out.println("Usuario: " +nome +" | Email: " +this.email +" | Senha: " +this.senha +" | Tentativas restantes: " +tentativasRestantes);
        }else if(tentativasRestantes <= 0){
            System.out.println("As tentativas acabaram");
        }else {
            tentativasRestantes --;
            System.out.println("O login falhou. Tentativas restantes: " +tentativasRestantes);
        }
    }
    public void mudarSenha(String senhaAtual, String novaSenha) {
        if(senhaAtual.equals(this.senha) && tentativasRestantes > 0) {
            setSenha(novaSenha);
        }else if(tentativasRestantes <= 0){
            System.out.println("acabaram as tentativas");
        }else {
            tentativasRestantes --;
            System.out.println("Senha errada! Tentativas restantes: " +tentativasRestantes);
        }
    }
    public void mostrarUsuario() {
        System.out.println("Usuario: " +nome +" | Email: " +this.email +" | Senha: " +"**********" +" | Tentativas restantes: " +tentativasRestantes);
    }
}
public static void main(String[] args) {
    Usuario user = new Usuario("Bernardo", "be@gmail.com", "123456789");

    user.mostrarUsuario();

    user.mudarSenha("43786544", "654321");
    user.fazerLogin("be@gmail.com", "123456789");
}
