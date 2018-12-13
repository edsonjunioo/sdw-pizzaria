package com.project.demo.controller;

public class SingletonAdmin {

    private static Admin admin;

    public SingletonAdmin() {
    }

    public synchronized static Admin getAdminRepository(){
        if(admin==null){
            admin = new Admin();
        }
        return admin;
    }
}
