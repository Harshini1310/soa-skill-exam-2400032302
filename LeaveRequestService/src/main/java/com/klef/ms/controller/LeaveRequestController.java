
package com.klef.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.ms.entity.LeaveRequest;
import com.klef.ms.service.LeaveRequestService;

@RestController
@RequestMapping("/api/leaverequests")
public class LeaveRequestController {

    @Autowired
    private LeaveRequestService service;

    @GetMapping("/")
    public String home() {
        return "Leave Request CRUD Service is running";
    }
    
    // Insert Record
    @PostMapping("/Insert")
    public LeaveRequest insertLeaveRequest(
            @RequestBody LeaveRequest leaveRequest) {

        return service.insertLeaveRequest(leaveRequest);
    }

    // Update Record
    @PutMapping("/Update/{id}")
    public LeaveRequest updateLeaveRequest(
            @PathVariable Long id,
            @RequestBody LeaveRequest leaveRequest) {

        return service.updateLeaveRequest(id, leaveRequest);
    }

    // Delete Record
    @DeleteMapping("/Delete/{id}")
    public String deleteLeaveRequest(@PathVariable Long id) {

        service.deleteLeaveRequest(id);
        return "Leave Request deleted successfully";
    }

    // Display All Records
    @GetMapping("/DisplayAll")
    public List<LeaveRequest> getAllLeaveRequests() {

        return service.getAllLeaveRequests();
    }

    // Display Record By ID
    @GetMapping("/DisplayByID/{id}")
    public LeaveRequest getLeaveRequestById(
            @PathVariable Long id) {

        return service.getLeaveRequestById(id);
    }

    // Derived Query Method 1
    @GetMapping("/findByName/{name}")
    public List<LeaveRequest> findByName(
            @PathVariable String name) {

        return service.findByName(name);
    }

    // Derived Query Method 2
    @GetMapping("/findByType/{type}")
    public List<LeaveRequest> findByType(
            @PathVariable String type) {

        return service.findByType(type);
    }
}
