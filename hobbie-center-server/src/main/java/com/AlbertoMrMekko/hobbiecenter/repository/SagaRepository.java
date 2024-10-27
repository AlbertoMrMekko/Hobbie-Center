package com.AlbertoMrMekko.hobbiecenter.repository;

import com.AlbertoMrMekko.hobbiecenter.model.Saga;
import com.AlbertoMrMekko.hobbiecenter.model.enums.SagaStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SagaRepository extends JpaRepository<Saga, Long>
{
    List<Saga> findByStatus(SagaStatusEnum status);
}
