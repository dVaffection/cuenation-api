package user.representation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import cue.domain.Cue;
import cue.domain.UserCue;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import java.util.Date;

@Relation(collectionRelation = "userCues")
public class UserCueResource extends ResourceSupport {

    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("link")
    private String link;

    @JsonProperty("createdAt")
    private Date createdAt;

    @JsonCreator
    public UserCueResource(UserCue userCue) {
        Cue cue = userCue.getCue();

        // NOTE: this is an an original Cue ID but a UserCue Id!
        id = userCue.getId();
        // time of cues creation is duplicated for user cues in order to fetch them in a reverse order
        createdAt = userCue.getCreatedAt();

        title = cue.getTitle();
        link = cue.getLink();
    }

}
