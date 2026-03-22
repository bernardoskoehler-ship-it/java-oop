static class Funcionario {
    String nome;
    double salario;

    void exibirDados() {
        System.out.println(nome + " ganha " + salario);
    }
}
static class Gerente extends Funcionario {
    void exibirDados() {
        super.exibirDados();
        System.out.println("Cargo: Gerente");
    }
}
static class Desenvolvedor extends Funcionario {
    void exibirDados() {
        super.exibirDados();
        System.out.println("Cargo: Desenvolvedor");
    }
}
public static void main(String[] args) {
Gerente g = new Gerente();
Desenvolvedor d = new Desenvolvedor();

g.nome = "Leo";
g.salario = 7500.00;

d.nome = "Bernardo";
d.salario = 9750.00;

g.exibirDados();
d.exibirDados();
}
