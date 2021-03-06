package cuenation.api.cue.service;

import cuenation.api.cue.domain.CueCategory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Component
public class CategoriesHtmlParser {

    public List<CueCategory> parse() throws IOException {
        List<CueCategory> categories = new LinkedList<>();
        String text, host, href;

        Document doc = Jsoup.connect("http://cuenation.com/?page=categories").get();
        Elements lists = doc.getElementsByClass("list");
        for (Element list : lists) {
            Elements links = list.getElementsByTag("a");

            for (Element link : links) {
                text = link.text().trim();
                // yeah, category links are relative URIs
                href = "http://cuenation.com/" + link.attr("href");

                if (text.length() > 0 && link.attr("href").length() > 0) {
                    Elements hosts = link.parent().getElementsByTag("i");
                    if (hosts.size() > 0) {
                        host = hosts.get(0).text();
                        categories.add(new CueCategory(text, host, href));
                    } else {
                        categories.add(new CueCategory(text, href));
                    }
                }
            }
        }

        return categories;
    }

}
