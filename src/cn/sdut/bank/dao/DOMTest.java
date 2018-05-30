package cn.sdut.bank.dao;

import cn.sdut.bank.dao.*;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.security.DomainCombiner;
import java.text.ParseException;

/**
 * DOM方式解析
 */



public class DOMTest {
    private StringBuffer url;

    DOMTest(){
        //1、创建一个DocumentBuilderFactory的对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        File file = new File("./mysqlData.xml");
        //2、创建一个DocumentBuilder的对象
        try {

            DocumentBuilder db = dbf.newDocumentBuilder();
            org.w3c.dom.Document doc = db.parse(file);
            NodeList nl = doc.getElementsByTagName("");



        }catch (Exception a){
            a.printStackTrace();
        }







    }

    public String getUrl(){
        return url.toString();
    }





}
