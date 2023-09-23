package com.bovauction.bovwallet.repository;

import com.bovauction.bovwallet.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository  extends JpaRepository<Client, Long> {
    boolean existsUserByCpf(final String cpf);
    boolean existsUserByEmail(final String email);
}
