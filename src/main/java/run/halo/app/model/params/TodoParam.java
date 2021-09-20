package run.halo.app.model.params;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import run.halo.app.model.dto.base.InputConverter;
import run.halo.app.model.entity.Todo;
import run.halo.app.model.support.CreateCheck;
import run.halo.app.model.support.UpdateCheck;

/**
 * @author Jerry Su
 * @Date 2021/9/19 14:28
 */
@Data
public class TodoParam implements InputConverter<Todo> {

    @NotNull(message = "id不能为空", groups = {UpdateCheck.class})
    private Integer id;

    @NotBlank(message = "标题不能为空", groups = {CreateCheck.class, UpdateCheck.class})
    @Size(max = 50, message = "标题长度不能超过 {max}", groups = {CreateCheck.class, UpdateCheck.class})
    private String title;

    private String abstractContent;
    @NotBlank(message = "内容不能为空", groups = {CreateCheck.class, UpdateCheck.class})
    @Size(max = 2000, message = "内容的字符长度不能超过 {max}", groups = {CreateCheck.class,
        UpdateCheck.class})
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date startDate;
    private Integer status;
    private Integer top;
}
