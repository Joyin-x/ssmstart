package com.demo.domain.employee;

/**
 * @author wwx
 * @date 2019/1/19 15:40
 **/
public class EmployeeVo {
    private int id;
    private String name;
    private String sex;
    private String birthday;
    private String native_place;
    private String address;
    private String phone;
    private String department_id;
    private String education;
    private String school;
    private String email;
    private String professional;
    private String remark;
    private String position;
    private int flag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNative_place() {
        return native_place;
    }

    public void setNative_place(String native_place) {
        this.native_place = native_place;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "EmployeeVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", native_place='" + native_place + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", department_id='" + department_id + '\'' +
                ", education='" + education + '\'' +
                ", school='" + school + '\'' +
                ", email='" + email + '\'' +
                ", professional='" + professional + '\'' +
                ", remark='" + remark + '\'' +
                ", position='" + position + '\'' +
                ", flag=" + flag +
                '}';
    }
}
