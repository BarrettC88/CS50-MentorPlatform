package org.cs50.mentorship;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Request {

    public Request(){

    }

    private @Id @GeneratedValue Long requestId;

    private String initiator;

    private String request;

    private String tags;

    public Request(String initiator, String request, String tags) {
        this.initiator = initiator;
        this.request = request;
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request that = (Request) o;
        return requestId.equals(that.requestId) && initiator.equals(that.initiator) && request.equals(that.request) && tags.equals(that.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId, initiator, request, tags);
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
