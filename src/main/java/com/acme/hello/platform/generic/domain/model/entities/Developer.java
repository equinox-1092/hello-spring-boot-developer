package com.acme.hello.platform.generic.domain.model.entities;

import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

@Getter
@Builder
public class Developer {
    private final UUID id = UUID.randomUUID();
    private final String firstName;
    private final String lastName;

    private Developer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public boolean isAnyNameEmpty() {
        return StringUtils.isAnyEmpty(firstName, lastName);
    }

    public boolean isAnyNameBlank() {
        return StringUtils.isAnyBlank(firstName, lastName);
    }
}
