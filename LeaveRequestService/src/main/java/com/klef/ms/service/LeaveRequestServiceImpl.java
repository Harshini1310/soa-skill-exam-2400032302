package com.klef.ms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.ms.entity.LeaveRequest;
import com.klef.ms.repository.LeaveRequestRepository;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

    @Autowired
    private LeaveRequestRepository repository;

    @Override
    public LeaveRequest insertLeaveRequest(LeaveRequest leaveRequest) {
        return repository.save(leaveRequest);
    }

    @Override
    public LeaveRequest updateLeaveRequest(Long id, LeaveRequest leaveRequest) {

        LeaveRequest existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave Request not found"));

        existing.setName(leaveRequest.getName());
        existing.setType(leaveRequest.getType());
        existing.setStatus(leaveRequest.getStatus());
        existing.setLocation(leaveRequest.getLocation());

        return repository.save(existing);
    }

    @Override
    public void deleteLeaveRequest(Long id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("Leave Request not found");
        }

        repository.deleteById(id);
    }

    @Override
    public List<LeaveRequest> getAllLeaveRequests() {
        return repository.findAll();
    }

    @Override
    public LeaveRequest getLeaveRequestById(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave Request not found"));
    }

    @Override
    public List<LeaveRequest> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<LeaveRequest> findByType(String type) {
        return repository.findByType(type);
    }
}