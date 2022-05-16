package com.athensarenabox.subscription.repositories;

import com.athensarenabox.subscription.daos.ClientDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientDao, String> { }
