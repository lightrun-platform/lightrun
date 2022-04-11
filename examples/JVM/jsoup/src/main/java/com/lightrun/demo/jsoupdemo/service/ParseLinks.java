package com.lightrun.demo.jsoupdemo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

// Based on code from https://jsoup.org/cookbook/extracting-data/example-list-links
@Component
public class ParseLinks {
    public Set<String> listLinks(String url, boolean includeMedia) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a[href]");
        Elements imports = doc.select("link[href]");

        Set<String> result = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        if(includeMedia) {
            Elements media = doc.select("[src]");
            for (Element src : media) {
                result.add(src.absUrl("src"));
                //result.add(src.attr("abs:src"));
            }
        }

        for (Element link : imports) {
            result.add(link.absUrl("abs:href"));
        }

        for (Element link : links) {
            result.add(link.absUrl("abs:href"));
        }

        return result;
    }
}
