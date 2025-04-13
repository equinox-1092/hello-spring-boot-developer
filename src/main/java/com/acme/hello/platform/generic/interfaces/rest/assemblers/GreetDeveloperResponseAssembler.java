package com.acme.hello.platform.generic.interfaces.rest.assemblers;

import com.acme.hello.platform.generic.domain.model.entities.Developer;
import com.acme.hello.platform.generic.interfaces.rest.resources.GreetDeveloperResponse;
import org.apache.commons.lang3.ObjectUtils;

public class GreetDeveloperResponseAssembler {
    private static boolean isDeveloperNullOrEmptyNamed(Developer developer) {
        return ObjectUtils.isEmpty(developer) ||
                developer.isAnyNameEmpty() ||
                developer.isAnyNameBlank();
    }

    public static GreetDeveloperResponse toResponseFromEntity(Developer developer) {
        if (isDeveloperNullOrEmptyNamed(developer)) {
            return new GreetDeveloperResponse("Welcome Anonymous Spring Boot Developer");
        }
        return new GreetDeveloperResponse(
                developer.getId(),
                developer.getFullName(),
                "Congrats " + developer.getFullName() + "! You are a Spring Boot Developer");

    }
}
