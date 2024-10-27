package com.AlbertoMrMekko.hobbiecenter.service;

import com.AlbertoMrMekko.hobbiecenter.model.Saga;
import com.AlbertoMrMekko.hobbiecenter.repository.SagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SagaService
{
    @Autowired
    private SagaRepository repository;

    public Saga addSaga(Saga saga)
    {
        if (saga.validateSagaCreation())
        {
            return repository.save(saga);
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }
}
