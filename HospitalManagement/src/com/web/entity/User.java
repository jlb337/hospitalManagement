package com.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class User implements Serializable {
    private Integer userId;

    private Integer poId;

    private Integer departmentID;

    private String userName;

    private String userPassword;

    private String userPhoto;

    private String userSex;

    private Date userBirthday;

    private String userCard;

    private Integer userState;

    private String userDescribe;

    private String marrySituation;

    private String level;

    private String birthPlace;

    private String nation;

    private String country;

    private String telephone;

    private String idplace;

    private Integer isDelete;
    
    /*
     * 外键导致的外部实体
     * */
    private Department department;
    private Position position;
    
    
    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPoId() {
        return poId;
    }

    public void setPoId(Integer poId) {
        this.poId = poId;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserCard() {
        return userCard;
    }

    public void setUserCard(String userCard) {
        this.userCard = userCard;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public String getUserDescribe() {
        return userDescribe;
    }

    public void setUserDescribe(String userDescribe) {
        this.userDescribe = userDescribe;
    }

    public String getMarrySituation() {
        return marrySituation;
    }

    public void setMarrySituation(String marrySituation) {
        this.marrySituation = marrySituation;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIdplace() {
        return idplace;
    }

    public void setIdplace(String idplace) {
        this.idplace = idplace;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPoId() == null ? other.getPoId() == null : this.getPoId().equals(other.getPoId()))
            && (this.getDepartmentID() == null ? other.getDepartmentID() == null : this.getDepartmentID().equals(other.getDepartmentID()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getUserPassword() == null ? other.getUserPassword() == null : this.getUserPassword().equals(other.getUserPassword()))
            && (this.getUserPhoto() == null ? other.getUserPhoto() == null : this.getUserPhoto().equals(other.getUserPhoto()))
            && (this.getUserSex() == null ? other.getUserSex() == null : this.getUserSex().equals(other.getUserSex()))
            && (this.getUserBirthday() == null ? other.getUserBirthday() == null : this.getUserBirthday().equals(other.getUserBirthday()))
            && (this.getUserCard() == null ? other.getUserCard() == null : this.getUserCard().equals(other.getUserCard()))
            && (this.getUserState() == null ? other.getUserState() == null : this.getUserState().equals(other.getUserState()))
            && (this.getUserDescribe() == null ? other.getUserDescribe() == null : this.getUserDescribe().equals(other.getUserDescribe()))
            && (this.getMarrySituation() == null ? other.getMarrySituation() == null : this.getMarrySituation().equals(other.getMarrySituation()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getBirthPlace() == null ? other.getBirthPlace() == null : this.getBirthPlace().equals(other.getBirthPlace()))
            && (this.getNation() == null ? other.getNation() == null : this.getNation().equals(other.getNation()))
            && (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry()))
            && (this.getTelephone() == null ? other.getTelephone() == null : this.getTelephone().equals(other.getTelephone()))
            && (this.getIdplace() == null ? other.getIdplace() == null : this.getIdplace().equals(other.getIdplace()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPoId() == null) ? 0 : getPoId().hashCode());
        result = prime * result + ((getDepartmentID() == null) ? 0 : getDepartmentID().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getUserPassword() == null) ? 0 : getUserPassword().hashCode());
        result = prime * result + ((getUserPhoto() == null) ? 0 : getUserPhoto().hashCode());
        result = prime * result + ((getUserSex() == null) ? 0 : getUserSex().hashCode());
        result = prime * result + ((getUserBirthday() == null) ? 0 : getUserBirthday().hashCode());
        result = prime * result + ((getUserCard() == null) ? 0 : getUserCard().hashCode());
        result = prime * result + ((getUserState() == null) ? 0 : getUserState().hashCode());
        result = prime * result + ((getUserDescribe() == null) ? 0 : getUserDescribe().hashCode());
        result = prime * result + ((getMarrySituation() == null) ? 0 : getMarrySituation().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getBirthPlace() == null) ? 0 : getBirthPlace().hashCode());
        result = prime * result + ((getNation() == null) ? 0 : getNation().hashCode());
        result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());
        result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
        result = prime * result + ((getIdplace() == null) ? 0 : getIdplace().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", poId=").append(poId);
        sb.append(", departmentID=").append(departmentID);
        sb.append(", userName=").append(userName);
        sb.append(", userPassword=").append(userPassword);
        sb.append(", userPhoto=").append(userPhoto);
        sb.append(", userSex=").append(userSex);
        sb.append(", userBirthday=").append(userBirthday);
        sb.append(", userCard=").append(userCard);
        sb.append(", userState=").append(userState);
        sb.append(", userDescribe=").append(userDescribe);
        sb.append(", marrySituation=").append(marrySituation);
        sb.append(", level=").append(level);
        sb.append(", birthPlace=").append(birthPlace);
        sb.append(", nation=").append(nation);
        sb.append(", country=").append(country);
        sb.append(", telephone=").append(telephone);
        sb.append(", idplace=").append(idplace);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
}