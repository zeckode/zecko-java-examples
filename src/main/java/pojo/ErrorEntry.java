package pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.util.Date;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorEntry implements Serializable {

    private static final long serialVersionUID = -4430016768517317700L;

    String message;

    Date timestamp;

    Object details;

    public ErrorEntry(String message, Date timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }
}
