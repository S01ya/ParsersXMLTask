package com.it_academy.parsers.sax;

import com.it_academy.entity.Article;
import com.it_academy.entity.Contacts;
import com.it_academy.entity.Hotkeys;
import com.it_academy.entity.Journal;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXHandler extends DefaultHandler {

    Journal journal = new Journal(null, null, null);
    Article article = null;
    Contacts contacts = new Contacts();
    Hotkeys hotkey = null;
    List<Article> articles = new ArrayList<>();
    List<Hotkeys> hotkeys = null;
    String content = null;
    int marker = 0;
    int markerHotkeys = 0;

    @Override
    //Triggered when the start of tag is found.
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes)
            throws SAXException {
        switch (qName) {
            case "journal":
                marker = 1;
                break;
            case "contacts":
                marker++;
                break;
            case "article":
                article = new Article();
                article.setArticleID(attributes.getValue("ID"));
                marker++;
                break;
            case "hotkeys":
                hotkey = new Hotkeys();
                hotkeys = new ArrayList<>();
                break;
            case "hotkey":
                markerHotkeys++;
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName,
                           String qName) throws SAXException {
        switch (qName) {
            case "title":
                if (marker == 1) {
                    journal.setTitle(content);
                }
                if (marker == 3) {
                    article.setTitle(content);
                }
                if (marker == 4) {
                    article.setTitle(content);
                }
                break;
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
                if (marker == 2) {
                    contacts.setUrl(content);
                }
                if (marker == 3) {
                    article.setUrl(content);
                }
                if (marker == 4) {
                    article.setUrl(content);
                }
                break;
            case "author":
                if (marker == 3) {
                    article.setAuthor(content);
                }
                if (marker == 4) {
                    article.setAuthor(content);
                }
                break;
            case "contacts":
                journal.setContacts(contacts);
                break;
            case "article":
                articles.add(article);
                journal.setArticle(articles);
                article.setHotkeys(hotkeys);
                break;
            case "hotkeys":
                if (marker == 3 && markerHotkeys ==3) {
                    hotkeys.add(hotkey);
                }
                if (marker == 4 && markerHotkeys == 5) {
                    hotkeys.add(hotkey);
                }
                break;
            case "hotkey":
                switch (markerHotkeys) {
                    case 1:
                        hotkey.setHotkeyLanguage(content);
                        break;
                    case 2:
                        hotkey.setHotkeyMarckup(content);
                        break;
                    case 3:
                        hotkey.setHotkeyHypertext(content);
                        break;
                    case 4:
                        hotkey.setHotkeyMarckup(content);
                        break;
                    case 5:
                        hotkey.setHotkeyHypertext(content);
                        break;
                }
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        content = String.copyValueOf(ch, start, length).trim();
    }
}
