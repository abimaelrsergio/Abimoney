package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.*;

public interface ICustomersService {

    /**
     *
     * @param mobileNumber - Input mobile number
     * @return CustomerDetails based in mobile number
     */
    CustomerDetailsDto fetchCustomerDetails(String mobileNumber);
}
