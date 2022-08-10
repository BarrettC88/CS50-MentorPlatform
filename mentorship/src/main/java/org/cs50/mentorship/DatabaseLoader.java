package org.cs50.mentorship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final ParticipantRepository participantRepository;
    private final RequestRepository mentorshipRequestRepository;

    @Autowired
    public DatabaseLoader(ParticipantRepository participantRepository, RequestRepository mentorshipRequestRepository) {
        this.participantRepository = participantRepository;
        this.mentorshipRequestRepository = mentorshipRequestRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.participantRepository.save(new Participant("Christopher", "Barrett"));
        this.mentorshipRequestRepository.save(new Request("Joe Soap", "I would like a roadmap for java concurrency", "#Java #Concurrency"));
        this.mentorshipRequestRepository.save(new Request("French Fry", "I would like to get into Data Science using Python", "#Python #DataScience"));
        this.mentorshipRequestRepository.save(new Request("Jenny Abe", "I would like a Web Programming roadmap", "#WebProgramming"));
        this.mentorshipRequestRepository.save(new Request("Loco Rocco", "I would like to get into Networking", "#Networks"));
    }
}
