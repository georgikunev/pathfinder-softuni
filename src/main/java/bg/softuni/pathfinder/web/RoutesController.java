package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.service.RouteService;
import bg.softuni.pathfinder.service.dto.RouteInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RoutesController {

    private RouteService routeService;

    public RoutesController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/routes")
    public String routes(Model model) {

        RouteInfoDTO randomRoute = routeService.getRandomRoute();
        List<RouteInfoDTO> allRoutes = routeService.getAllRoutes();
        model.addAttribute("routes", allRoutes);

        return "routes";
    }
}
