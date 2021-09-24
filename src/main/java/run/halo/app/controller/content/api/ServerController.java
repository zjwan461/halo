package run.halo.app.controller.content.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import run.halo.app.model.dto.ServerInfoDTO;

/**
 * @author Jerry.Su
 * @Date 2021/9/24 16:49
 */
@RestController("apiServerController")
@RequestMapping("/api/content/server")
public class ServerController {

    @GetMapping("/info")
    public ServerInfoDTO serverInfo() {

        return null;
    }
}
