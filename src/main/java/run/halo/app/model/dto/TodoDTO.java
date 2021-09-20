package run.halo.app.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import run.halo.app.model.dto.base.OutputConverter;
import run.halo.app.model.entity.Todo;

/**
 * @author Jerry Su
 * @Date 2021/9/19 14:54
 */
@Data
@ToString
@EqualsAndHashCode
public class TodoDTO implements OutputConverter<TodoDTO, Todo> {
    private Integer id;
    private String title;
        private String abstractContent;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date startDate;
    private String content;
    private Integer status;
    private Integer top;
}
