package run.halo.app.service.impl;

import java.util.Map;
import org.apache.commons.lang3.SystemUtils;
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
        Map<String, String> result = null;
        if (SystemUtils.IS_OS_LINUX) {
            result = LinuxStateForShell.runLocalShell(LinuxStateForShell.COMMANDS);
        } else {
            result = LinuxStateForShell.runDistanceShell(LinuxStateForShell.COMMANDS, "devuser",
                "asdf1111",
                "156.247.9.176");
        }
        return LinuxStateForShell.getServerInfo(result);
    }
}
