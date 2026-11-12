package com.site.actor_managment.controller;

import com.site.actor_managment.model.Actor;
import com.site.actor_managment.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping("/actor")
    public List<Actor> getActorDetails() {
        return actorService.getAllActors();
    }

    @GetMapping("/actor/{id}")
    public Actor getActorById(@PathVariable int id) {
        return actorService.getActorById(id);
    }

    @PostMapping("/actor")
    public Actor createActor(@RequestBody Actor actor) {
        return actorService.addActor(actor);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteActorById(@PathVariable int id) {
        return actorService.deleteActorById(id);
    }
}
