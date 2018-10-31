package com.nagarro.yourmartapi.repository;

import com.nagarro.yourmartapi.entity.Admin;

public interface AdminRepository {

	Admin authenticate(String username, String password);

}