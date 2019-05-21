package com.marco.service.credentials.credentialservice;

import com.marco.domain.credentials.LoginDetail;
import com.marco.service.ServiceGI;

import java.util.Set;

public interface LoginDetailService extends ServiceGI<LoginDetail, String> {
    Set<LoginDetail> getAllLoginDetails();
}
