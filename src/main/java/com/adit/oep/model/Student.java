/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adit.oep.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Win_It
 */

@Entity
@Table(name="student_login")
public class Student {
    @Column(name="student_name")
    private String sName;
    @Id
    @Column(name="student_id")
    private long sEnNumber;
    @Column(name="student_pass")
    private String sPassword;
    @Transient
    private int sBranchCode;
    @Transient
    private int sEntryYear;
    
    @Transient
    private List<Assignment> assignmentDone;
    @Transient
    private List<Assignment> assignmentRemain;

    public Student()
    {
        this.sEnNumber = 0L;
    }
    public Student(long sEnNumber,String sPassword)
    {
        this.sEnNumber = sEnNumber;
        this.sPassword = sPassword;
    }
    public Student(String sName, long sEnNumber, String sPassword) {
        this.sName = sName;
        this.sEnNumber = sEnNumber;
        this.sPassword = sPassword;

        processEnrollmentNumber();
    }
     
    public int getBranchCode(long enNo){
//        170010107019
        enNo /= 1000;
        return (int) (enNo % 100);
    }
    
    public int getYear(long enNo){
//        long temp = this.sEnNumber;
//        temp /= 1000;
//        this.sBranchCode = (int) (temp % 100);
          
        enNo /= 100000;
        int i =(int) (enNo /= 100000); 
        
        
        
        int year = java.time.Year.now().getValue() % 100;
        
        return year - i;
        
    }
    private void processEnrollmentNumber() {
        long temp = this.sEnNumber;
        temp /= 1000;
        this.sBranchCode = (int) (temp % 100);
        temp /= 10000000;

        this.sEntryYear = 2000 + (int) temp;
    }
    
    public String getsPassword()
    {
        return sPassword;
    }
    
    public long getsEnNumber()
    {
        return sEnNumber;
    }
    
    public String getsName()
    {
        return sName;
    }
    
    public void setsPassword(String sPassword)
    {
        this.sPassword = sPassword;
    }
    
    public void setsName(String sName)
    {
        this.sName = sName;
    }
    
    public void setsEnNumber(long sEnNumber)
    {
        this.sEnNumber = sEnNumber;
    }

    

    public void setSEnNumber(long sEnNumber) {
        this.sEnNumber = sEnNumber;
    }
}