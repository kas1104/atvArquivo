package classeEntidade.entity;

//Bibliotecas
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class ConverterEmXml {
    //Atributus da classe ConverterXml
    //Caminho dentro da maquina para salvar os arquivo convertido
    private static final String caminhoSalvar= "C:\\Users\\Usuário\\OneDrive\\Documentos\\kallebeTeste\\atividade";
    private String[] valores;

    //Construtor da classe
    public ConverterEmXml(String[] valores){
        this.valores = valores;
    }

    //Fnção que converte os valores do arquivo txt lidos pelo sistema em XML
    public void ArquivoXML(String[] valores){

        //Parametros que instancia a classe do construtor de documentos
        DocumentBuilderFactory documentoConstrutor = DocumentBuilderFactory.newInstance();

        //Estrutura de tratamento para detectar qualquer erro que houver no momento da conversão
        try{
            DocumentBuilder dbObjeto = documentoConstrutor.newDocumentBuilder();
            Document documentoConverter =dbObjeto.newDocument();

            //Parametros que definem a exibição dos dados na WEB
            //Parametro de Titulo
            Element linhaPai = documentoConverter.createElement("Titulo");
            documentoConverter.appendChild(linhaPai);

            //Parametro que exibirá o nome
            Element Nome = documentoConverter.createElement("Nome");
            linhaPai.appendChild(Nome);
            Nome.appendChild(documentoConverter.createTextNode(valores[0]));

            //Parametro que exibirá o item 1
            Element item1 = documentoConverter.createElement("Item1");
            linhaPai.appendChild(item1);
            item1.appendChild(documentoConverter.createTextNode(valores[1]));

            //Parametro que exibira o item 2
            Element item2 = documentoConverter.createElement("Item2");
            linhaPai.appendChild(item2);
            item2.appendChild(documentoConverter.createTextNode(valores[2]));

            //Parametros de finalização de todo o processo e salvam o arquivo no caminho indicado
            TransformerFactory transformersObjeto =TransformerFactory.newInstance();
            Transformer TransformerXML = transformersObjeto.newTransformer();
            DOMSource source = new DOMSource(documentoConverter);
            StreamResult gerarArquivo =new StreamResult(new File(caminhoSalvar + ".xml"));

            TransformerXML.transform(source, gerarArquivo);

        } catch (Exception excecaoVariavel){
            excecaoVariavel.printStackTrace();
        }
    }


}
