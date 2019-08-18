package com.web.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public UserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andUserIdIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("userId =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("userId >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("userId <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("userId in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andPoIdIsNull() {
            addCriterion("poId is null");
            return (Criteria) this;
        }

        public Criteria andPoIdIsNotNull() {
            addCriterion("poId is not null");
            return (Criteria) this;
        }

        public Criteria andPoIdEqualTo(Integer value) {
            addCriterion("poId =", value, "poId");
            return (Criteria) this;
        }

        public Criteria andPoIdNotEqualTo(Integer value) {
            addCriterion("poId <>", value, "poId");
            return (Criteria) this;
        }

        public Criteria andPoIdGreaterThan(Integer value) {
            addCriterion("poId >", value, "poId");
            return (Criteria) this;
        }

        public Criteria andPoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("poId >=", value, "poId");
            return (Criteria) this;
        }

        public Criteria andPoIdLessThan(Integer value) {
            addCriterion("poId <", value, "poId");
            return (Criteria) this;
        }

        public Criteria andPoIdLessThanOrEqualTo(Integer value) {
            addCriterion("poId <=", value, "poId");
            return (Criteria) this;
        }

        public Criteria andPoIdIn(List<Integer> values) {
            addCriterion("poId in", values, "poId");
            return (Criteria) this;
        }

        public Criteria andPoIdNotIn(List<Integer> values) {
            addCriterion("poId not in", values, "poId");
            return (Criteria) this;
        }

        public Criteria andPoIdBetween(Integer value1, Integer value2) {
            addCriterion("poId between", value1, value2, "poId");
            return (Criteria) this;
        }

        public Criteria andPoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("poId not between", value1, value2, "poId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIDIsNull() {
            addCriterion("departmentID is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIDIsNotNull() {
            addCriterion("departmentID is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIDEqualTo(Integer value) {
            addCriterion("departmentID =", value, "departmentID");
            return (Criteria) this;
        }

        public Criteria andDepartmentIDNotEqualTo(Integer value) {
            addCriterion("departmentID <>", value, "departmentID");
            return (Criteria) this;
        }

        public Criteria andDepartmentIDGreaterThan(Integer value) {
            addCriterion("departmentID >", value, "departmentID");
            return (Criteria) this;
        }

        public Criteria andDepartmentIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("departmentID >=", value, "departmentID");
            return (Criteria) this;
        }

        public Criteria andDepartmentIDLessThan(Integer value) {
            addCriterion("departmentID <", value, "departmentID");
            return (Criteria) this;
        }

        public Criteria andDepartmentIDLessThanOrEqualTo(Integer value) {
            addCriterion("departmentID <=", value, "departmentID");
            return (Criteria) this;
        }

        public Criteria andDepartmentIDIn(List<Integer> values) {
            addCriterion("departmentID in", values, "departmentID");
            return (Criteria) this;
        }

        public Criteria andDepartmentIDNotIn(List<Integer> values) {
            addCriterion("departmentID not in", values, "departmentID");
            return (Criteria) this;
        }

        public Criteria andDepartmentIDBetween(Integer value1, Integer value2) {
            addCriterion("departmentID between", value1, value2, "departmentID");
            return (Criteria) this;
        }

        public Criteria andDepartmentIDNotBetween(Integer value1, Integer value2) {
            addCriterion("departmentID not between", value1, value2, "departmentID");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("userName is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("userName is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("userName =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("userName <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("userName >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("userName >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("userName <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("userName <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("userName like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("userName not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("userName in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("userName not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("userName between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("userName not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNull() {
            addCriterion("userPassword is null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNotNull() {
            addCriterion("userPassword is not null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordEqualTo(String value) {
            addCriterion("userPassword =", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotEqualTo(String value) {
            addCriterion("userPassword <>", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThan(String value) {
            addCriterion("userPassword >", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("userPassword >=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThan(String value) {
            addCriterion("userPassword <", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("userPassword <=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLike(String value) {
            addCriterion("userPassword like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotLike(String value) {
            addCriterion("userPassword not like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIn(List<String> values) {
            addCriterion("userPassword in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotIn(List<String> values) {
            addCriterion("userPassword not in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordBetween(String value1, String value2) {
            addCriterion("userPassword between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotBetween(String value1, String value2) {
            addCriterion("userPassword not between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPhotoIsNull() {
            addCriterion("userPhoto is null");
            return (Criteria) this;
        }

        public Criteria andUserPhotoIsNotNull() {
            addCriterion("userPhoto is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhotoEqualTo(String value) {
            addCriterion("userPhoto =", value, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoNotEqualTo(String value) {
            addCriterion("userPhoto <>", value, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoGreaterThan(String value) {
            addCriterion("userPhoto >", value, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("userPhoto >=", value, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoLessThan(String value) {
            addCriterion("userPhoto <", value, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoLessThanOrEqualTo(String value) {
            addCriterion("userPhoto <=", value, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoLike(String value) {
            addCriterion("userPhoto like", value, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoNotLike(String value) {
            addCriterion("userPhoto not like", value, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoIn(List<String> values) {
            addCriterion("userPhoto in", values, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoNotIn(List<String> values) {
            addCriterion("userPhoto not in", values, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoBetween(String value1, String value2) {
            addCriterion("userPhoto between", value1, value2, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoNotBetween(String value1, String value2) {
            addCriterion("userPhoto not between", value1, value2, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNull() {
            addCriterion("userSex is null");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNotNull() {
            addCriterion("userSex is not null");
            return (Criteria) this;
        }

        public Criteria andUserSexEqualTo(String value) {
            addCriterion("userSex =", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotEqualTo(String value) {
            addCriterion("userSex <>", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThan(String value) {
            addCriterion("userSex >", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThanOrEqualTo(String value) {
            addCriterion("userSex >=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThan(String value) {
            addCriterion("userSex <", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThanOrEqualTo(String value) {
            addCriterion("userSex <=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLike(String value) {
            addCriterion("userSex like", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotLike(String value) {
            addCriterion("userSex not like", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexIn(List<String> values) {
            addCriterion("userSex in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotIn(List<String> values) {
            addCriterion("userSex not in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexBetween(String value1, String value2) {
            addCriterion("userSex between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotBetween(String value1, String value2) {
            addCriterion("userSex not between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayIsNull() {
            addCriterion("userBirthday is null");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayIsNotNull() {
            addCriterion("userBirthday is not null");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("userBirthday =", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("userBirthday <>", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("userBirthday >", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("userBirthday >=", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("userBirthday <", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("userBirthday <=", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("userBirthday in", values, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("userBirthday not in", values, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("userBirthday between", value1, value2, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("userBirthday not between", value1, value2, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserCardIsNull() {
            addCriterion("userCard is null");
            return (Criteria) this;
        }

        public Criteria andUserCardIsNotNull() {
            addCriterion("userCard is not null");
            return (Criteria) this;
        }

        public Criteria andUserCardEqualTo(String value) {
            addCriterion("userCard =", value, "userCard");
            return (Criteria) this;
        }

        public Criteria andUserCardNotEqualTo(String value) {
            addCriterion("userCard <>", value, "userCard");
            return (Criteria) this;
        }

        public Criteria andUserCardGreaterThan(String value) {
            addCriterion("userCard >", value, "userCard");
            return (Criteria) this;
        }

        public Criteria andUserCardGreaterThanOrEqualTo(String value) {
            addCriterion("userCard >=", value, "userCard");
            return (Criteria) this;
        }

        public Criteria andUserCardLessThan(String value) {
            addCriterion("userCard <", value, "userCard");
            return (Criteria) this;
        }

        public Criteria andUserCardLessThanOrEqualTo(String value) {
            addCriterion("userCard <=", value, "userCard");
            return (Criteria) this;
        }

        public Criteria andUserCardLike(String value) {
            addCriterion("userCard like", value, "userCard");
            return (Criteria) this;
        }

        public Criteria andUserCardNotLike(String value) {
            addCriterion("userCard not like", value, "userCard");
            return (Criteria) this;
        }

        public Criteria andUserCardIn(List<String> values) {
            addCriterion("userCard in", values, "userCard");
            return (Criteria) this;
        }

        public Criteria andUserCardNotIn(List<String> values) {
            addCriterion("userCard not in", values, "userCard");
            return (Criteria) this;
        }

        public Criteria andUserCardBetween(String value1, String value2) {
            addCriterion("userCard between", value1, value2, "userCard");
            return (Criteria) this;
        }

        public Criteria andUserCardNotBetween(String value1, String value2) {
            addCriterion("userCard not between", value1, value2, "userCard");
            return (Criteria) this;
        }

        public Criteria andUserStateIsNull() {
            addCriterion("userState is null");
            return (Criteria) this;
        }

        public Criteria andUserStateIsNotNull() {
            addCriterion("userState is not null");
            return (Criteria) this;
        }

        public Criteria andUserStateEqualTo(Integer value) {
            addCriterion("userState =", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateNotEqualTo(Integer value) {
            addCriterion("userState <>", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateGreaterThan(Integer value) {
            addCriterion("userState >", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("userState >=", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateLessThan(Integer value) {
            addCriterion("userState <", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateLessThanOrEqualTo(Integer value) {
            addCriterion("userState <=", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateIn(List<Integer> values) {
            addCriterion("userState in", values, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateNotIn(List<Integer> values) {
            addCriterion("userState not in", values, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateBetween(Integer value1, Integer value2) {
            addCriterion("userState between", value1, value2, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateNotBetween(Integer value1, Integer value2) {
            addCriterion("userState not between", value1, value2, "userState");
            return (Criteria) this;
        }

        public Criteria andUserDescribeIsNull() {
            addCriterion("userDescribe is null");
            return (Criteria) this;
        }

        public Criteria andUserDescribeIsNotNull() {
            addCriterion("userDescribe is not null");
            return (Criteria) this;
        }

        public Criteria andUserDescribeEqualTo(String value) {
            addCriterion("userDescribe =", value, "userDescribe");
            return (Criteria) this;
        }

        public Criteria andUserDescribeNotEqualTo(String value) {
            addCriterion("userDescribe <>", value, "userDescribe");
            return (Criteria) this;
        }

        public Criteria andUserDescribeGreaterThan(String value) {
            addCriterion("userDescribe >", value, "userDescribe");
            return (Criteria) this;
        }

        public Criteria andUserDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("userDescribe >=", value, "userDescribe");
            return (Criteria) this;
        }

        public Criteria andUserDescribeLessThan(String value) {
            addCriterion("userDescribe <", value, "userDescribe");
            return (Criteria) this;
        }

        public Criteria andUserDescribeLessThanOrEqualTo(String value) {
            addCriterion("userDescribe <=", value, "userDescribe");
            return (Criteria) this;
        }

        public Criteria andUserDescribeLike(String value) {
            addCriterion("userDescribe like", value, "userDescribe");
            return (Criteria) this;
        }

        public Criteria andUserDescribeNotLike(String value) {
            addCriterion("userDescribe not like", value, "userDescribe");
            return (Criteria) this;
        }

        public Criteria andUserDescribeIn(List<String> values) {
            addCriterion("userDescribe in", values, "userDescribe");
            return (Criteria) this;
        }

        public Criteria andUserDescribeNotIn(List<String> values) {
            addCriterion("userDescribe not in", values, "userDescribe");
            return (Criteria) this;
        }

        public Criteria andUserDescribeBetween(String value1, String value2) {
            addCriterion("userDescribe between", value1, value2, "userDescribe");
            return (Criteria) this;
        }

        public Criteria andUserDescribeNotBetween(String value1, String value2) {
            addCriterion("userDescribe not between", value1, value2, "userDescribe");
            return (Criteria) this;
        }

        public Criteria andMarrySituationIsNull() {
            addCriterion("marrySituation is null");
            return (Criteria) this;
        }

        public Criteria andMarrySituationIsNotNull() {
            addCriterion("marrySituation is not null");
            return (Criteria) this;
        }

        public Criteria andMarrySituationEqualTo(String value) {
            addCriterion("marrySituation =", value, "marrySituation");
            return (Criteria) this;
        }

        public Criteria andMarrySituationNotEqualTo(String value) {
            addCriterion("marrySituation <>", value, "marrySituation");
            return (Criteria) this;
        }

        public Criteria andMarrySituationGreaterThan(String value) {
            addCriterion("marrySituation >", value, "marrySituation");
            return (Criteria) this;
        }

        public Criteria andMarrySituationGreaterThanOrEqualTo(String value) {
            addCriterion("marrySituation >=", value, "marrySituation");
            return (Criteria) this;
        }

        public Criteria andMarrySituationLessThan(String value) {
            addCriterion("marrySituation <", value, "marrySituation");
            return (Criteria) this;
        }

        public Criteria andMarrySituationLessThanOrEqualTo(String value) {
            addCriterion("marrySituation <=", value, "marrySituation");
            return (Criteria) this;
        }

        public Criteria andMarrySituationLike(String value) {
            addCriterion("marrySituation like", value, "marrySituation");
            return (Criteria) this;
        }

        public Criteria andMarrySituationNotLike(String value) {
            addCriterion("marrySituation not like", value, "marrySituation");
            return (Criteria) this;
        }

        public Criteria andMarrySituationIn(List<String> values) {
            addCriterion("marrySituation in", values, "marrySituation");
            return (Criteria) this;
        }

        public Criteria andMarrySituationNotIn(List<String> values) {
            addCriterion("marrySituation not in", values, "marrySituation");
            return (Criteria) this;
        }

        public Criteria andMarrySituationBetween(String value1, String value2) {
            addCriterion("marrySituation between", value1, value2, "marrySituation");
            return (Criteria) this;
        }

        public Criteria andMarrySituationNotBetween(String value1, String value2) {
            addCriterion("marrySituation not between", value1, value2, "marrySituation");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("level like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("level not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceIsNull() {
            addCriterion("birthPlace is null");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceIsNotNull() {
            addCriterion("birthPlace is not null");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceEqualTo(String value) {
            addCriterion("birthPlace =", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceNotEqualTo(String value) {
            addCriterion("birthPlace <>", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceGreaterThan(String value) {
            addCriterion("birthPlace >", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("birthPlace >=", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceLessThan(String value) {
            addCriterion("birthPlace <", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceLessThanOrEqualTo(String value) {
            addCriterion("birthPlace <=", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceLike(String value) {
            addCriterion("birthPlace like", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceNotLike(String value) {
            addCriterion("birthPlace not like", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceIn(List<String> values) {
            addCriterion("birthPlace in", values, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceNotIn(List<String> values) {
            addCriterion("birthPlace not in", values, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceBetween(String value1, String value2) {
            addCriterion("birthPlace between", value1, value2, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceNotBetween(String value1, String value2) {
            addCriterion("birthPlace not between", value1, value2, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andNationIsNull() {
            addCriterion("nation is null");
            return (Criteria) this;
        }

        public Criteria andNationIsNotNull() {
            addCriterion("nation is not null");
            return (Criteria) this;
        }

        public Criteria andNationEqualTo(String value) {
            addCriterion("nation =", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotEqualTo(String value) {
            addCriterion("nation <>", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThan(String value) {
            addCriterion("nation >", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("nation >=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThan(String value) {
            addCriterion("nation <", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("nation <=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLike(String value) {
            addCriterion("nation like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotLike(String value) {
            addCriterion("nation not like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationIn(List<String> values) {
            addCriterion("nation in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotIn(List<String> values) {
            addCriterion("nation not in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("nation between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("nation not between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("Telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("Telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("Telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("Telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("Telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("Telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("Telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("Telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("Telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("Telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("Telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("Telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("Telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("Telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andIdplaceIsNull() {
            addCriterion("Idplace is null");
            return (Criteria) this;
        }

        public Criteria andIdplaceIsNotNull() {
            addCriterion("Idplace is not null");
            return (Criteria) this;
        }

        public Criteria andIdplaceEqualTo(String value) {
            addCriterion("Idplace =", value, "idplace");
            return (Criteria) this;
        }

        public Criteria andIdplaceNotEqualTo(String value) {
            addCriterion("Idplace <>", value, "idplace");
            return (Criteria) this;
        }

        public Criteria andIdplaceGreaterThan(String value) {
            addCriterion("Idplace >", value, "idplace");
            return (Criteria) this;
        }

        public Criteria andIdplaceGreaterThanOrEqualTo(String value) {
            addCriterion("Idplace >=", value, "idplace");
            return (Criteria) this;
        }

        public Criteria andIdplaceLessThan(String value) {
            addCriterion("Idplace <", value, "idplace");
            return (Criteria) this;
        }

        public Criteria andIdplaceLessThanOrEqualTo(String value) {
            addCriterion("Idplace <=", value, "idplace");
            return (Criteria) this;
        }

        public Criteria andIdplaceLike(String value) {
            addCriterion("Idplace like", value, "idplace");
            return (Criteria) this;
        }

        public Criteria andIdplaceNotLike(String value) {
            addCriterion("Idplace not like", value, "idplace");
            return (Criteria) this;
        }

        public Criteria andIdplaceIn(List<String> values) {
            addCriterion("Idplace in", values, "idplace");
            return (Criteria) this;
        }

        public Criteria andIdplaceNotIn(List<String> values) {
            addCriterion("Idplace not in", values, "idplace");
            return (Criteria) this;
        }

        public Criteria andIdplaceBetween(String value1, String value2) {
            addCriterion("Idplace between", value1, value2, "idplace");
            return (Criteria) this;
        }

        public Criteria andIdplaceNotBetween(String value1, String value2) {
            addCriterion("Idplace not between", value1, value2, "idplace");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("isDelete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("isDelete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("isDelete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("isDelete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("isDelete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("isDelete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("isDelete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("isDelete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("isDelete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("isDelete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("isDelete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("isDelete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}