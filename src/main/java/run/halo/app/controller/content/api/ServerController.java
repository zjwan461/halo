package run.halo.app.controller.content.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import run.halo.app.model.dto.ServerInfoDTO;
import run.halo.app.service.ServerService;

/**
 * @author Jerry.Su
 * @Date 2021/9/24 16:49
 */
@RestController("apiServerController")
@RequestMapping("/api/content/server")
public class ServerController {

    private final ServerService serverService;

    public ServerController(ServerService serverService) {
        this.serverService = serverService;
    }

    @GetMapping("/info")
    public ServerInfoDTO serverInfo() {
        return serverService.getInfo();
    }
}
