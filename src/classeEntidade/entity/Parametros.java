package classeEntidade.entity;

//Bibliotecas
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;

public class Parametros {

    //Função que exibe os itens do arquivo no console
    public Lista exibirItens() throws IOException {

        //Parametro que declara a classe BufferedWriter que escreverá os dados em linha de codigo
        BufferedReader reader = null;

        //Estrutura de tratamento de erros e exceções
        try{
            //Parametro que realiza a leitura do Arquivo e verifica o conteudo
            reader = new BufferedReader(new FileReader(Arquivo.caminhoARQUIVO));

            //Parametro que verifica se a primeira quebra linha dentro do arquivo
            String linha = reader.readLine();

            //Parametro que retorna os valores dentro do converter Itens
            return converterItens(linha);

        }
        catch (Exception excecaoVariavel){
            excecaoVariavel.printStackTrace();
        } finally {
            //Parametro que encerra a conexão entre o sistema e o arquivo selecionado
            reader.close();
        }

        //Paramtro que retorna nulo
        return null;

    }

    //Função que converte os valores lidos do arquivo em linha de codigo
    private Lista converterItens(String codigo) throws IllegalAccessException{
        //Vetor que recebe os valores separados por '_' e os atribui as posições da lista
        String[] atributos = codigo.split("\\_");

        //Objeto que instancia a classe Lista
        Lista listaDeProdutos = new Lista(null, null, null);

        //Variavel que retorna todos os atributos da classe lista e os armazena no vetor
        Field[] conversorDosDados = Lista.class.getDeclaredFields();

        //Estrutura de repetição que atribui os valores lidos do arquivo a variavel listaDePProdutos
        for(int x = 0; x < conversorDosDados.length; x++){
            conversorDosDados[x].setAccessible(true);
            conversorDosDados[x].set(listaDeProdutos, atributos[x]);
        }
        //Parametrro que retorna os valores da listaDeProdutos
        return listaDeProdutos;
    }
}
