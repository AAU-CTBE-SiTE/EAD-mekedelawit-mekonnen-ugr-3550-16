package com.site.actor_managment.controller;

import com.site.actor_managment.model.Actor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ActorController {
    List<Actor> actors = new ArrayList<>();

    public ActorController() {
        actors.add(new Actor(1, "John Doe", "The Great Adventure"));
        actors.add(new Actor(2, "Jane Smith", "Mystery Island"));
    }

    // CRUD -- READ

    @GetMapping("/actor")
    public List<Actor> getActorDetails() {
        return actors;
    }

    @GetMapping("/actor/{id}")
    public Actor getActorById(@PathVariable int id) {
        for (Actor actor : actors) {
            if (actor.getId() == id) {
                return actor;
            }
        }
        return null;
    }

    // CRUD -- CREATE

    @PostMapping("/actor")
    public Actor createActor(@RequestBody Actor actor) {
        actors.add(actor);
        return actor;
    }

    // CRUD -- UPDATE (PUT replaces all the fields)

    @PutMapping("/actor/{id}")
    public Actor updateActor(@PathVariable int id, @RequestBody Actor updatedActor) {
        for (Actor actor : actors) {
            if (actor.getId() == id) {
                actor.setName(updatedActor.getName());
                actor.setMovieName(updatedActor.getMovieName());
                return actor;
            }
        }
        return null;
    }

    // CRUD -- UPDATE (PATCH changes only the fields that are sent)

    @PatchMapping("/actor/{id}")
    public Actor patchActor(@PathVariable int id, @RequestBody Actor updatedActor) {
        for (Actor actor : actors) {
            if (actor.getId() == id) {
                if (updatedActor.getName() != null) {
                    actor.setName(updatedActor.getName());
                }
                if (updatedActor.getMovieName() != null) {
                    actor.setMovieName(updatedActor.getMovieName());
                }
                return actor;
            }
        }
        return null;
    }

    // CRUD -- DELETE

    @DeleteMapping("/delete/{id}")
    public String deleteActorById(@PathVariable int id) {
        for (Actor actor : actors) {
            if (actor.getId() == id) {
                actors.remove(actor);
                break;
            }
        }
        return "Actor deleted successfully";
    }
}
