package am.itspace.myfriend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private int id;
    private User fromId;
    private User toId;
    private String message;
    private Date date;
}
