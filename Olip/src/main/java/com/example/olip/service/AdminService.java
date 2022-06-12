package com.example.olip.service;

import com.example.olip.model.Admin;
import com.example.olip.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

    public Admin getAdminId(Integer id) {
        return adminRepository.findById(id).get();
    }
    public void addAdmin(Admin admin) {
        adminRepository.save(admin);
    }


}
