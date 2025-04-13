package com.acme.hello.platform.generic.interfaces.rest.assemblers;

import com.acme.hello.platform.generic.domain.model.entities.Developer;
import com.acme.hello.platform.generic.interfaces.rest.resources.GreetDeveloperRequest;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

public class DeveloperAssembler {
    public static Developer toEntityFromRequest(GreetDeveloperRequest request) {
        if (ObjectUtils.isEmpty(request) ||
                StringUtils.isAnyBlank(request.firstName(), request.lastName())) {
            return null;
        }
        return Developer.builder().firstName(request.firstName()).lastName(request.lastName()).build();
    }
}
