package com.it_academy.parsers.dom;

import com.it_academy.entity.Article;
import com.it_academy.entity.Contacts;
import com.it_academy.entity.Hotkeys;
import com.it_academy.entity.Journal;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;


public class DOMParserDemo {
    private static final String XML_PATH = "hw4.xml";

    public static void main(String[] args) {
        Document document = DomParsersUtils.parseXMLDocument(XML_PATH);
        Element rootNode = document.getDocumentElement();
        NodeList nodeList = DomParsersUtils.getNodeList(document);
        String title = getJournalTitleFromXML(rootNode);
        Journal journal = new Journal(title, null, null);
        DomParsersUtils.getNodeListStream(nodeList).forEach(node -> {
            if (node instanceof Element) {
                switch (node.getNodeName()) {
                    case "contacts":
                        journal.setContacts(getContacts(node));
                        break;
                    case "articles":
                        journal.setArticle(getArticlesList(node));
                        break;
                }
            }
        });
        System.out.println(journal);
    }

    public static String getJournalTitleFromXML(Element rootNode) {
        var titleNode = rootNode.getElementsByTagName("title").item(0);
        String title = titleNode.getTextContent();
        return title;
    }

    private static Contacts getContacts(Node node) {
        Contacts contacts = new Contacts();
        NodeList childNodes = node.getChildNodes();
        DomParsersUtils.getNodeListStream(childNodes).forEach(childNode -> {
            if (childNode instanceof Element) {
                String content = childNode
                        .getLastChild()
                        .getTextContent()
                        .trim();
                switch (childNode.getNodeName()) {
                    case "address":
                        contacts.setAddress(content);
                        break;
                    case "tel":
                        contacts.setTel(content);
                        break;
                    case "email":
                        contacts.setEmail(content);
                        break;
                    case "url":
                        contacts.setUrl(content);
                        break;
                }
            }
        });
        return contacts;
    }

    private static ArrayList<Article> getArticlesList(Node node) {
        ArrayList articlesList = new ArrayList<Article>();
        NodeList childArticleNodes = node.getChildNodes();
        DomParsersUtils.getNodeListStream(childArticleNodes).forEach(childNode -> {
            if (childNode instanceof Element) {
                Article article = new Article();
                article.setArticleID(childNode.getAttributes().
                        getNamedItem("ID").getNodeValue());
                articlesList.add(article);
                NodeList superChildArticleNodes = childNode.getChildNodes();
                DomParsersUtils.getNodeListStream(superChildArticleNodes).forEach(superChildNode -> {
                    if (superChildNode instanceof Element) {
                        String content1 = superChildNode
                                .getLastChild()
                                .getTextContent()
                                .trim();
                        switch (superChildNode.getNodeName()) {
                            case "title":
                                article.setTitle(content1);
                                break;
                            case "author":
                                article.setAuthor(content1);
                                break;
                            case "url":
                                article.setUrl(content1);
                                break;
                            case "hotkeys":
                                ArrayList hotkeysList = getHotkeysList(superChildNode);
                                article.setHotkeys(hotkeysList);
                                break;
                        }
                    }
                });
            }
        });
        return articlesList;
    }

    private static ArrayList<Hotkeys> getHotkeysList(Node superChildNode) {
        ArrayList hotkeysList = new ArrayList<Hotkeys>();
        Hotkeys hotkeys = new Hotkeys();
        hotkeysList.add(hotkeys);
        NodeList childHotkeysNodes = superChildNode.getChildNodes();
        DomParsersUtils.getNodeListStream(childHotkeysNodes).forEach(childHotkeydNode -> {
            if (childHotkeydNode instanceof Element) {
                String hotkeysContent = childHotkeydNode
                        .getLastChild()
                        .getTextContent()
                        .trim();
                switch (hotkeysContent) {
                    case "language":
                        hotkeys.setHotkeyLanguage(hotkeysContent);
                        break;
                    case "marckup":
                        hotkeys.setHotkeyMarckup(hotkeysContent);
                        break;
                    case "hypertext":
                        hotkeys.setHotkeyHypertext(hotkeysContent);
                        break;
                }
            }
        });
        return hotkeysList;
    }
}

