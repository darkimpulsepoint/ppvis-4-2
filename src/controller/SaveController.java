package controller;//package controller;


//import j
//import model.Teacher;
import model.Client;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class SaveController {

    public void parser(File file, List<Client> list){

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        System.out.println(file.getName());
        try {
            builder = factory.newDocumentBuilder();

            Document doc = builder.newDocument();
            Element rootElement = doc.createElementNS("","clients");
            doc.appendChild(rootElement);

            for(Client client: list)
                rootElement.appendChild(getClient(doc, client));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            StreamResult file1 = new StreamResult(file);
            transformer.transform(source, file1);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private static Node getClient(Document doc, Client client) {
        Element language = doc.createElement("client");

        language.appendChild(getClientElements(doc,  "surname", client.getFio().getSurname()));
        language.appendChild(getClientElements(doc,  "name", client.getFio().getName()));
        language.appendChild(getClientElements(doc,  "patronymic", client.getFio().getPatronymic()));
        language.appendChild(getClientElements(doc,  "homePhone", client.getHomePhone()));
        language.appendChild(getClientElements(doc,  "mobilePhone", client.getMobilePhone()));
        language.appendChild(getClientElements(doc,  "accountNumber", client.getAccountNumber()));
        language.appendChild(getClientElements(doc,  "adress", client.getAdress()));


        return language;
    }

    private static Node getClientElements(Document doc, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }


}