package com.klef.ms.service;

import java.util.List;

import com.klef.ms.entity.LeaveRequest;

public interface LeaveRequestService {

    LeaveRequest insertLeaveRequest(LeaveRequest leaveRequest);

    LeaveRequest updateLeaveRequest(Long id, LeaveRequest leaveRequest);

    void deleteLeaveRequest(Long id);

    List<LeaveRequest> getAllLeaveRequests();

    LeaveRequest getLeaveRequestById(Long id);

    List<LeaveRequest> findByName(String name);

    List<LeaveRequest> findByType(String type);
}