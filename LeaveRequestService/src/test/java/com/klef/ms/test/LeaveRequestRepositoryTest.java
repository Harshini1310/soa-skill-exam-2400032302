
package com.klef.ms.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import com.klef.ms.entity.LeaveRequest;
import com.klef.ms.service.LeaveRequestService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LeaveRequestRepositoryTest {

    @Autowired
    private LeaveRequestService service;

    @Test
    void testFindAllLeaveRequests() {

        List<LeaveRequest> requests =
                service.getAllLeaveRequests();

        assertNotNull(requests);
        assertFalse(requests.isEmpty());

        System.out.println("Total Leave Requests: "
                + requests.size());
    }

    
    @Test
    void testFindLeaveRequestById() {

        LeaveRequest request =
                service.getLeaveRequestById(1L);

        assertNotNull(request);

        assertEquals(1L, request.getId());

       
    }

    @Test
    void testFindByName() {

        List<LeaveRequest> requests =
                service.findByName("Harshini");

        assertNotNull(requests);
        assertFalse(requests.isEmpty());

        assertEquals("Harshini",
                requests.get(0).getName());

    }

  
    @Test
    void testCountLeaveRequests() {

        List<LeaveRequest> requests =
                service.getAllLeaveRequests();

        long count = requests.size();

        assertEquals(10L, count);

    }

    
    @Test
    void testLeaveRequestDetails() {

        LeaveRequest request =
                service.getLeaveRequestById(1L);

        assertNotNull(request);

        assertNotNull(request.getName());
        assertNotNull(request.getType());
        assertNotNull(request.getStatus());
        assertNotNull(request.getLocation());

       
    }

  
}
