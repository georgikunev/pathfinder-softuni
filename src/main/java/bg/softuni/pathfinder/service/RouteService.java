package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.data.RouteRepository;
import bg.softuni.pathfinder.model.Picture;
import bg.softuni.pathfinder.model.Route;
import bg.softuni.pathfinder.service.dto.RouteInfoDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class RouteService {

    private RouteRepository routeRepository;
    private Random random;
    private ModelMapper modelMapper;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
        this.modelMapper = new ModelMapper();
        this.random = new Random();
    }

    @Transactional
    public RouteInfoDTO getRandomRoute() {
        long routeCount = routeRepository.count();
        long rndRouteId = random.nextLong(routeCount) + 1;
        Optional<Route> route = routeRepository.findById(rndRouteId);


        return mapToInfo(route.get());
    }
    @Transactional
    public List<RouteInfoDTO> getAllRoutes() {
        return routeRepository.findAll().stream().map(this::mapToInfo).toList();
    }

    private RouteInfoDTO mapToInfo(Route route) {

        RouteInfoDTO dto = modelMapper.map(route, RouteInfoDTO.class);
        Optional<Picture> first = route.getPictures().stream().findFirst();
        dto.setImgUrl(first.get().getUrl());
        return dto;
    }
}
