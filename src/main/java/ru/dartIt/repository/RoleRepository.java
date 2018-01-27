package ru.dartIt.repository;

import ru.dartIt.model.Role;

import java.util.Set;

public interface RoleRepository {
    Set<Role>findAll();
}
