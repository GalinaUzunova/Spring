package org.pathfinder2.servises;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.pathfinder2.model.Picture;
import org.pathfinder2.model.Route;
import org.pathfinder2.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Transactional
public class RouteService {

     private RouteRepository routeRepository;
     private Random random;
    private ModelMapper mapper;


     public RouteService(RouteRepository routeRepository) {
          this.routeRepository = routeRepository;
          this.random=new Random();
          this.mapper=new ModelMapper();
     }



      public    List<RouteInfoDto> getAll() {
             return this.routeRepository.findAll().stream().
                     map(this::mappToDto).toList();
         }

    public RouteInfoDto getRondomRoute() {

        long routeCount = this.routeRepository.count();

        long randomId = random.nextLong(routeCount) + 1;
        Optional<Route> route = routeRepository.findById(randomId);
        if (route.isEmpty()) {
            // throw exception; return empty

        }
        return  mappToDto(route.get());

    }

            public RouteInfoDto mappToDto(Route route){
          RouteInfoDto routeInfoDto = mapper.map(route, RouteInfoDto.class);

         Optional<Picture> first = route.getPitures().stream().findFirst();

         routeInfoDto.setImageUrl(first.get().getUrl());
         return routeInfoDto;


     }
}
