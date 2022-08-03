package org.cs50.mentorship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final ParticipantRepository repository;

    @Autowired
    public DatabaseLoader(ParticipantRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.repository.save(new Participant("Christopher", "Barrett"));
    }
}
