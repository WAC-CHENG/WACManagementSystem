package com.milotnt.service;

import com.milotnt.pojo.Admin;

/*Admin login module interface*/
public interface AdminService {

    /**
     * Way for admin to login
     * @param admin
     * @return If not return null, current date.
     */
    Admin adminLogin(Admin admin);

}
