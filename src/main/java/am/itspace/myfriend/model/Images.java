package am.itspace.myfriend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Images {
    private int id;
    private int userId;
    private String imgName;

    private boolean like;
    private String comment;

    public boolean getLike(){return like;}
}
