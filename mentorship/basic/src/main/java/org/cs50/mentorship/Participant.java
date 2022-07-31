package org.cs50.mentorship;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Participant {

    private @Id @GeneratedValue Long participantId;
    private String firstName;
    private String lastName;

    private Participant() {}

    public Participant(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant user = (Participant) o;
        return Objects.equals(participantId, user.participantId) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participantId, firstName, lastName);
    }

    public Long getId() {
        return participantId;
    }

    public void setId(Long id) {
        this.participantId = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "participantId=" + participantId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
