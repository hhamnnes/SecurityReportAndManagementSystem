package no.hiof.hmh.domain.model;

import java.time.LocalDateTime;

public class SecurityOccurrence {

    private String name;
    private String description;
    private String location;
    private SecurityOccurrenceCategory category;
    private LocalDateTime timestamp;

    public SecurityOccurrence() {}

    public SecurityOccurrence(String name,
                              String description,
                              String location,
                              SecurityOccurrenceCategory category,
                              LocalDateTime timestamp) {
        this.name = name;
        this.description = description;
        this.location = location;

        if (category != null) this.category = category;
        else throw new IllegalArgumentException("Category can not be a null value");
        
        if(timestamp != null) this.timestamp = timestamp;
        else throw new IllegalArgumentException("timestamp can not be an null value");
        
        
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public SecurityOccurrenceCategory getCategory() {
        return category;
    }

    public void setCategory(SecurityOccurrenceCategory category) {
        this.category = category;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }


    
    
}
