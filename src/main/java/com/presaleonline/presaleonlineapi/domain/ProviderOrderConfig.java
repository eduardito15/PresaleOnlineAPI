package com.presaleonline.presaleonlineapi.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProviderOrderConfig {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Provider provider;

    @ElementCollection
    private List<String> daysOfWeek;

    @Column
    private boolean automatic;

    @Column
    private boolean generateSameDay;

    @Column
    private int hour;

    public ProviderOrderConfig() {
        daysOfWeek = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public List<String> getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(List<String> daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public boolean isAutomatic() {
        return automatic;
    }

    public void setAutomatic(boolean automatic) {
        this.automatic = automatic;
    }

    public boolean isGenerateSameDay() {
        return generateSameDay;
    }

    public void setGenerateSameDay(boolean generateSameDay) {
        this.generateSameDay = generateSameDay;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
}
