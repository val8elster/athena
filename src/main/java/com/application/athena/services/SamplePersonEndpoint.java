package com.application.athena.services;

import com.application.athena.data.SamplePerson;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.Endpoint;
import com.vaadin.hilla.exception.EndpointException;
import java.util.Optional;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Endpoint
@AnonymousAllowed
public class SamplePersonEndpoint {

    private final SamplePersonService service;

    public SamplePersonEndpoint(SamplePersonService service) {
        this.service = service;
    }

    public Page<SamplePerson> list(Pageable page) {
        return service.list(page);
    }

    public Optional<SamplePerson> get(Long id) {
        return service.get(id);
    }

    public SamplePerson update(SamplePerson entity) {
        try {
            return service.update(entity);
        } catch (OptimisticLockingFailureException e) {
            throw new EndpointException("Somebody else has updated the data while you were making changes.");
        }
    }

    public void delete(Long id) {
        service.delete(id);
    }

    public int count() {
        return service.count();
    }

}
