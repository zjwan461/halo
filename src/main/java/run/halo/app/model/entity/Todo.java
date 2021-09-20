package run.halo.app.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Jerry Su
 * @Date 2021/9/19 14:09
 */
@Data
@Entity
@Table(name = "todo")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Todo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "abstract", nullable = false)
    private String abstractContent;

    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "content", length = 2000, nullable = false)
    private String content;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "top")
    private Integer top;

}
