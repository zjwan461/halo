package run.halo.app.service.impl;

import java.util.Map;
import org.springframework.stereotype.Service;
import run.halo.app.model.dto.ServerInfoDTO;
import run.halo.app.service.ServerService;
import run.halo.app.utils.LinuxStateForShell;

/**
 * @author Jerry.Su
 * @Date 2021/9/24 17:14
 */
@Service
public class ServerServiceImpl implements ServerService {
    @Override
    public ServerInfoDTO getInfo() {
        Map<String, String> result =
            LinuxStateForShell.runDistanceShell(LinuxStateForShell.COMMANDS, "devuser", "asdf1111",
                "156.247.9.176");
        return LinuxStateForShell.getServerInfo(result);
    }
}
