package classeEntidade.entity;

//Classe que irá receber os dados dentro do arquivo e guarda-los dentro da memoria pelas variaveis
public class Lista {
    //Atributos referentes a cada tipo de dados
    private String nome;
    private String item1;
    private String item2;

    //Construtor da Classe
    public Lista(String nome, String item1, String item2){
        this.nome = nome;
        this.item1 = item1;
        this.item2 = item2;
    }

    //Metodos Getters que retorna os valores dos atributos
    public String getNome() {
        return nome;
    }

    public String getItem1() {
        return item1;
    }

    public String getItem2() {
        return item2;
    }

    //Metodo toString que verifica como está escrito cada arquivo e sua separação para ler
    //cada elemento de forma limpa
    @Override
    public String toString() {
        return this.getNome().concat("_")
                .concat(this.getItem1()).concat("_")
                .concat(this.getItem2());
    }
}
