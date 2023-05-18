package com.mcfly.crud_rest_demo.dao;

import com.mcfly.crud_rest_demo.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl implements RoleDAO {

    private final EntityManager entityManager;

    @Autowired
    public RoleDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Role findRoleByName(String roleName) {
        final TypedQuery<Role> query = entityManager.createQuery("from Role where name=:rName", Role.class);
        query.setParameter("rName", roleName);
        Role role = null;
        try {
            role = query.getSingleResult();
        } catch (Exception ignored) {
        }
        return role;
    }
}
