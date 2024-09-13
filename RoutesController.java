package org.pathfinder2.web;


import org.pathfinder2.servises.RouteInfoDto;
import org.pathfinder2.servises.RouteService;
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

    public String routes(Model model){
//        RouteInfoDto route=routeService.getRondomRoute();
//        model.addAttribute( "route",route);

        List<RouteInfoDto> routes=routeService.getAll();
        model.addAttribute("allRoutes",routes);




        return "routes";
    }
}
