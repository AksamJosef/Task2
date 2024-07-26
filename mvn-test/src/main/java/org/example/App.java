package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws JAXBException, FileNotFoundException {

//        JAXBContext context = JAXBContext.newInstance(PioUntypedActWorksAcceptance.class);
//        Unmarshaller unmarshaller = context.createUnmarshaller();

        File file = new File("test.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String s = scanner.nextLine();
        }

//        System.out.println(element);

    }
}
