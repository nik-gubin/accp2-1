/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sstu.accp.lessons.lesson17;

import java.io.File;
import java.io.IOException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

/**
 *
 * @author Губин_Н
 */
public class Main {

    public static void main(String[] args) {
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        try {
            Schema schema = factory.newSchema(
                    new File("src/ru/sstu/accp/lessons/lesson17/schame.xsd"));
            Validator validator = schema.newValidator();
            validator.validate(
                    new StreamSource("src/ru/sstu/accp/lessons/lesson17/users.xml"));
            System.out.println("OK");
        } catch (SAXException | IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
