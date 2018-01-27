package ru.dartIt.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.dartIt.model.Role;

import java.util.Set;

@Repository
@Transactional(readOnly = true)
public class RoleRepositoryImpl implements RoleRepository {

    @Override
    public Set<Role> findAll() {
        return null;
    }
}
