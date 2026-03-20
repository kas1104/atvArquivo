//Conexão com as demais classes entidades
import classeEntidade.entity.ConverterEmXml;
import classeEntidade.entity.Lista;
import classeEntidade.entity.Parametros;

//Biblioteca
import java.util.Objects;

public class interfacePrincipal {
    //Função principal
    public static void main(String... args)throws Exception{
        //Classe instanciada
        Parametros parametroObjeto = new Parametros();

        //Variavel que recebe os parametros da classe entidade exibirItens
        Lista exibirValores = parametroObjeto.exibirItens();

        //Estrutura Condicional que verifica se ha valores dentro do arquivo
        if(Objects.nonNull(exibirValores)){
            System.out.println("Todos os valores no arquivo: " + exibirValores);

            //Vetor que irá recebere todos os valores do arquivo para serem convertidos em XML
            String[] valoresDoArquivo = new String[3];

            valoresDoArquivo[0] = exibirValores.getNome();
            valoresDoArquivo[1] = exibirValores.getItem1();
            valoresDoArquivo[2] = exibirValores.getItem2();

            //Classe instanciada que atribui os valores da lista para serem convertidos em XML
            ConverterEmXml conversorXML = new ConverterEmXml(valoresDoArquivo);

            //Variavel instanciada que retorna o arquivo no caminho informado no sistema
            conversorXML.ArquivoXML(valoresDoArquivo);
        }
        else
        {
            System.out.println("Não ha nenhum valor!!");
        }
    }
}
