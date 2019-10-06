package com.marco.controller.bookings;

import com.marco.domain.bookings.Report;
import com.marco.factory.bookings.ReportFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReportControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/railway/report";

    @Test
    public void a_create() {
        Report report = ReportFactory.buildReport(400, 200, 20);

        ResponseEntity<Report> postResponse = restTemplate.postForEntity(baseURL + "/create", report, Report.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {
        Report report = restTemplate.getForObject(baseURL + "/read/400", Report.class);
        Report updated = new Report.Builder().copy(report).profit(250).build();
        restTemplate.put(baseURL + "/update", updated);

        Report updatedReport = restTemplate.getForObject(baseURL + "/read/400", Report.class);

        assertNotNull(updatedReport);
        assertEquals(updated.getProfit(), updatedReport.getProfit(), 0.1);
    }

    @Test
    public void e_delete() {
        Report report = restTemplate.getForObject(baseURL + "/read/400", Report.class);
        assertNotNull(report);
        assertEquals(400, report.getReportID());

        restTemplate.delete(baseURL + "/delete/" + report.getReportID());
        report = restTemplate.getForObject(baseURL + "/read/400", Report.class);

        assertNull(report);
    }

    @Test
    public void b_read() {
        ResponseEntity<Report> reportResponseEntity = restTemplate.getForEntity(baseURL + "/read/400", Report.class);
        assertNotNull(reportResponseEntity.getBody());
        assertEquals(400, reportResponseEntity.getBody().getReportID());
    }

    @Test
    public void d_getAllReports() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("ReportHeader", "This is the getAll header");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String>  responseEntity = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);
    }
}