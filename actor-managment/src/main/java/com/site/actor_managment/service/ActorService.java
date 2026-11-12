package com.site.actor_managment.service;

import com.site.actor_managment.annotation.TrackExecution;
import com.site.actor_managment.model.Actor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActorService {
    private final List<Actor> actors = new ArrayList<>();

    public ActorService() {
        actors.add(new Actor(1, "John Doe", "The Great Adventure"));
        actors.add(new Actor(2, "Jane Smith", "Mystery Island"));
    }

    public List<Actor> getAllActors() {
        return actors;
    }

    @TrackExecution
    public Actor getActorById(int id) {
        for (Actor actor : actors) {
            if (actor.getId() == id) {
                return actor;
            }
        }
        return null;
    }

    public Actor addActor(Actor actor) {
        actors.add(actor);
        return actor;
    }

    public String deleteActorById(int id) {
        actors.removeIf(actor -> actor.getId() == id);
        return "Actor deleted successfully";
    }
}
