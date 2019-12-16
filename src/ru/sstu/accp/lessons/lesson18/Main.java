/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sstu.accp.lessons.lesson18;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Губин_Н
 */
public class Main {

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document d = builder.parse("src\\ru\\sstu\\accp\\lessons\\lesson18\\users.xml");

        //    parseManual(d);
        ArrayList<User> users = parseUserFromXML(d);
        for (User u : users) {
            System.out.println(u);
        }

        Document newDocument = builder.newDocument();
        Element root = newDocument.createElement("users");
        newDocument.appendChild(root);

        User u = new User(12, "Фамилиев", "Иван", 25, 2220);
        root.appendChild(createUserElement(newDocument, u));

        users.add(new User(13, "Sidorova", "Masha", 40, 10001));
        users.add(new User(43, "Sidorova", "Marina", 40, 10001));
        users.add(new User(99, "Sidorov", "Sidr", 20, 20000));
        users.add(new User(34, "Ivanov", "Ivan", 20, 10000));
        users.add(new User(66, "Ivanov", "Ivan", 30, 10000));

        for (User u1 : users) {
            root.appendChild(createUserElement(newDocument, u1));
        }

        TransformerFactory factory1 = TransformerFactory.newInstance();
        Transformer transformer = factory1.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        DOMSource dOMSource = new DOMSource(newDocument);
        StreamResult result = new StreamResult("src\\ru\\sstu\\accp\\lessons\\lesson18\\users_2.xml");
        transformer.transform(dOMSource, result);

    }

    private static Element createUserElement(Document d, User u) {
        Element userElement = d.createElement("user");

        Element lnElement = d.createElement("lastname");
        lnElement.setTextContent(u.getLastName());
        userElement.appendChild(lnElement);

        Element fnElement = d.createElement("firstname");
        fnElement.setTextContent(u.getFirstName());
        userElement.appendChild(fnElement);

        Element ageElement = d.createElement("age");
        ageElement.setTextContent(String.valueOf(u.getAge()));
        userElement.appendChild(ageElement);

        Element salaryElement = d.createElement("salary");
        salaryElement.setTextContent(String.valueOf(u.getSalary()));
        userElement.appendChild(salaryElement);

        userElement.setAttribute("id", String.valueOf(u.getId()));
        return userElement;
    }

    private static ArrayList<User> parseUserFromXML(Document d) throws DOMException {
        ArrayList<User> list = new ArrayList<>();

        Element root = d.getDocumentElement();
        NodeList rootChild = root.getChildNodes();
        for (int i = 0; i < rootChild.getLength(); i++) {
            Node users = rootChild.item(i);
            if (users.getNodeName().startsWith("#text")) {
                continue;
            }

            if (users.getNodeName().equals("user")) {
                User u = new User();
                list.add(u);

                NodeList userChilds = users.getChildNodes();

                NamedNodeMap attr = users.getAttributes();
                for (int j = 0; j < attr.getLength(); j++) {
                    Node n = attr.item(j);
                    if (n.getNodeName().equalsIgnoreCase("id")) {
                        u.setId(Integer.valueOf(n.getTextContent()));
                    }
                }

                for (int j = 0; j < userChilds.getLength(); j++) {
                    Node userNode = userChilds.item(j);
                    if (userNode.getNodeName().startsWith("#text")) {
                        continue;
                    }
                    if (userNode.getNodeName().equals("lastname")) {
                        u.setLastName(userNode.getTextContent());
                    }
                    if (userNode.getNodeName().equals("firstname")) {
                        u.setFirstName(userNode.getTextContent());
                    }
                    if (userNode.getNodeName().equals("age")) {
                        u.setAge(Integer.valueOf(userNode.getTextContent()));
                    }
                    if (userNode.getNodeName().equals("salary")) {
                        u.setSalary(Double.valueOf(userNode.getTextContent()));
                    }
                }
            }
        }
        return list;
    }

    private static void parseManual(Document d) throws DOMException {
        Element root = d.getDocumentElement();
        System.out.println(root.getTagName());
//        System.out.println(root.getTextContent());
        NodeList rootChild = root.getChildNodes();
        for (int i = 0; i < rootChild.getLength(); i++) {
            Node users = rootChild.item(i);
            if (users.getNodeName().startsWith("#text")) {
                continue;
            }
            System.out.println("   " + users.getNodeName());
            if (users.getNodeName().equals("lang")) {
                System.out.println("      " + users.getTextContent());
            }
            if (users.getNodeName().equals("user")) {
                NodeList userChilds = users.getChildNodes();

                NamedNodeMap attr = users.getAttributes();
                for (int j = 0; j < attr.getLength(); j++) {
                    Node n = attr.item(j);
                    System.out.println("      " + n.getNodeName());
                    System.out.println("         " + n.getTextContent());
                }

                for (int j = 0; j < userChilds.getLength(); j++) {
                    Node userNode = userChilds.item(j);
                    if (userNode.getNodeName().startsWith("#text")) {
                        continue;
                    }
                    System.out.println("      " + userNode.getNodeName());
                    if (!userNode.getNodeName().equals("documetns")) {
                        System.out.println("         " + userNode.getTextContent());
                    }
                    if (userNode.getNodeName().equals("documetns")) {
                        NodeList docs = userNode.getChildNodes();
                        for (int k = 0; k < docs.getLength(); k++) {
                            Node doc = docs.item(k);
                            if (doc.getNodeName().startsWith("#text")) {
                                continue;
                            }
                            System.out.println("         " + doc.getNodeName());

                            NamedNodeMap attrDoc = doc.getAttributes();
                            for (int l = 0; l < attrDoc.getLength(); l++) {
                                Node n = attrDoc.item(l);
                                System.out.println("            " + n.getNodeName());
                                System.out.println("               " + n.getTextContent());
                            }

                        }

                    }

                }
            }
        }
    }
}
