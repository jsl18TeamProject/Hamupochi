package com.example.HamuPochi.Repository.Custom;

import com.example.HamuPochi.Entity.Admin;

import java.util.Optional;

public interface AdminRepositoryCustom {
    Optional<Admin> findByIdCustom(String username);
}
