package cuenation.api.cue.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cue_categories")
public class CueCategory {

    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

    private String host;

    private String link;

    public CueCategory() {
        
    }

    public CueCategory(String name, String link) {
        this.name = name;
        this.link = link;
    }

    public CueCategory(String name, String host, String link) {
        this.name = name;
        this.host = host;
        this.link = link;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    public String getHost() {
        return host;
    }

    @Override
    public String toString() {
        return "CueCategory{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", host='" + host + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
