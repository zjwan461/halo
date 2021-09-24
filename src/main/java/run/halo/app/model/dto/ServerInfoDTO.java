package run.halo.app.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Jerry.Su
 * @Date 2021/9/24 16:52
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode
public class ServerInfoDTO {

    private double cpuUsed;

    private double cpuFree;

    private double memoryUsed;

    private double memoryFree;

    private double diskUsed;

    private double diskFree;
}
