package com.example.dairy.Samiul.User7;

import java.io.Serializable;

public class ReportClass implements Serializable {

    String topic;
    String description;

    public ReportClass(String topic, String description) {
        this.topic = topic;
        this.description = description;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ReportClass{" +
                "topic='" + topic + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
