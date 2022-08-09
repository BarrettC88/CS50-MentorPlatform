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
        this.mentorshipRequestRepository.save(new Request("Christopher Barrett", "I would like a roadmap for java concurrency", "Java Concurrency"));

    }
}
