package com.web.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SupplierDrugOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public SupplierDrugOrderExample() {
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

        public Criteria andSupplierIDIsNull() {
            addCriterion("supplierID is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIDIsNotNull() {
            addCriterion("supplierID is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierIDEqualTo(Integer value) {
            addCriterion("supplierID =", value, "supplierID");
            return (Criteria) this;
        }

        public Criteria andSupplierIDNotEqualTo(Integer value) {
            addCriterion("supplierID <>", value, "supplierID");
            return (Criteria) this;
        }

        public Criteria andSupplierIDGreaterThan(Integer value) {
            addCriterion("supplierID >", value, "supplierID");
            return (Criteria) this;
        }

        public Criteria andSupplierIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("supplierID >=", value, "supplierID");
            return (Criteria) this;
        }

        public Criteria andSupplierIDLessThan(Integer value) {
            addCriterion("supplierID <", value, "supplierID");
            return (Criteria) this;
        }

        public Criteria andSupplierIDLessThanOrEqualTo(Integer value) {
            addCriterion("supplierID <=", value, "supplierID");
            return (Criteria) this;
        }

        public Criteria andSupplierIDIn(List<Integer> values) {
            addCriterion("supplierID in", values, "supplierID");
            return (Criteria) this;
        }

        public Criteria andSupplierIDNotIn(List<Integer> values) {
            addCriterion("supplierID not in", values, "supplierID");
            return (Criteria) this;
        }

        public Criteria andSupplierIDBetween(Integer value1, Integer value2) {
            addCriterion("supplierID between", value1, value2, "supplierID");
            return (Criteria) this;
        }

        public Criteria andSupplierIDNotBetween(Integer value1, Integer value2) {
            addCriterion("supplierID not between", value1, value2, "supplierID");
            return (Criteria) this;
        }

        public Criteria andDrugOrderIDIsNull() {
            addCriterion("drugOrderID is null");
            return (Criteria) this;
        }

        public Criteria andDrugOrderIDIsNotNull() {
            addCriterion("drugOrderID is not null");
            return (Criteria) this;
        }

        public Criteria andDrugOrderIDEqualTo(Integer value) {
            addCriterion("drugOrderID =", value, "drugOrderID");
            return (Criteria) this;
        }

        public Criteria andDrugOrderIDNotEqualTo(Integer value) {
            addCriterion("drugOrderID <>", value, "drugOrderID");
            return (Criteria) this;
        }

        public Criteria andDrugOrderIDGreaterThan(Integer value) {
            addCriterion("drugOrderID >", value, "drugOrderID");
            return (Criteria) this;
        }

        public Criteria andDrugOrderIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("drugOrderID >=", value, "drugOrderID");
            return (Criteria) this;
        }

        public Criteria andDrugOrderIDLessThan(Integer value) {
            addCriterion("drugOrderID <", value, "drugOrderID");
            return (Criteria) this;
        }

        public Criteria andDrugOrderIDLessThanOrEqualTo(Integer value) {
            addCriterion("drugOrderID <=", value, "drugOrderID");
            return (Criteria) this;
        }

        public Criteria andDrugOrderIDIn(List<Integer> values) {
            addCriterion("drugOrderID in", values, "drugOrderID");
            return (Criteria) this;
        }

        public Criteria andDrugOrderIDNotIn(List<Integer> values) {
            addCriterion("drugOrderID not in", values, "drugOrderID");
            return (Criteria) this;
        }

        public Criteria andDrugOrderIDBetween(Integer value1, Integer value2) {
            addCriterion("drugOrderID between", value1, value2, "drugOrderID");
            return (Criteria) this;
        }

        public Criteria andDrugOrderIDNotBetween(Integer value1, Integer value2) {
            addCriterion("drugOrderID not between", value1, value2, "drugOrderID");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderMakeDateIsNull() {
            addCriterion("supplierOrderMakeDate is null");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderMakeDateIsNotNull() {
            addCriterion("supplierOrderMakeDate is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderMakeDateEqualTo(Date value) {
            addCriterionForJDBCDate("supplierOrderMakeDate =", value, "supplierOrderMakeDate");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderMakeDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("supplierOrderMakeDate <>", value, "supplierOrderMakeDate");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderMakeDateGreaterThan(Date value) {
            addCriterionForJDBCDate("supplierOrderMakeDate >", value, "supplierOrderMakeDate");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderMakeDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("supplierOrderMakeDate >=", value, "supplierOrderMakeDate");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderMakeDateLessThan(Date value) {
            addCriterionForJDBCDate("supplierOrderMakeDate <", value, "supplierOrderMakeDate");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderMakeDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("supplierOrderMakeDate <=", value, "supplierOrderMakeDate");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderMakeDateIn(List<Date> values) {
            addCriterionForJDBCDate("supplierOrderMakeDate in", values, "supplierOrderMakeDate");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderMakeDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("supplierOrderMakeDate not in", values, "supplierOrderMakeDate");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderMakeDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("supplierOrderMakeDate between", value1, value2, "supplierOrderMakeDate");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderMakeDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("supplierOrderMakeDate not between", value1, value2, "supplierOrderMakeDate");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderFinishDateIsNull() {
            addCriterion("supplierOrderFinishDate is null");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderFinishDateIsNotNull() {
            addCriterion("supplierOrderFinishDate is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderFinishDateEqualTo(Date value) {
            addCriterionForJDBCDate("supplierOrderFinishDate =", value, "supplierOrderFinishDate");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderFinishDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("supplierOrderFinishDate <>", value, "supplierOrderFinishDate");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderFinishDateGreaterThan(Date value) {
            addCriterionForJDBCDate("supplierOrderFinishDate >", value, "supplierOrderFinishDate");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderFinishDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("supplierOrderFinishDate >=", value, "supplierOrderFinishDate");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderFinishDateLessThan(Date value) {
            addCriterionForJDBCDate("supplierOrderFinishDate <", value, "supplierOrderFinishDate");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderFinishDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("supplierOrderFinishDate <=", value, "supplierOrderFinishDate");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderFinishDateIn(List<Date> values) {
            addCriterionForJDBCDate("supplierOrderFinishDate in", values, "supplierOrderFinishDate");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderFinishDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("supplierOrderFinishDate not in", values, "supplierOrderFinishDate");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderFinishDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("supplierOrderFinishDate between", value1, value2, "supplierOrderFinishDate");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderFinishDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("supplierOrderFinishDate not between", value1, value2, "supplierOrderFinishDate");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderAddressIsNull() {
            addCriterion("supplierOrderAddress is null");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderAddressIsNotNull() {
            addCriterion("supplierOrderAddress is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderAddressEqualTo(String value) {
            addCriterion("supplierOrderAddress =", value, "supplierOrderAddress");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderAddressNotEqualTo(String value) {
            addCriterion("supplierOrderAddress <>", value, "supplierOrderAddress");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderAddressGreaterThan(String value) {
            addCriterion("supplierOrderAddress >", value, "supplierOrderAddress");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderAddressGreaterThanOrEqualTo(String value) {
            addCriterion("supplierOrderAddress >=", value, "supplierOrderAddress");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderAddressLessThan(String value) {
            addCriterion("supplierOrderAddress <", value, "supplierOrderAddress");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderAddressLessThanOrEqualTo(String value) {
            addCriterion("supplierOrderAddress <=", value, "supplierOrderAddress");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderAddressLike(String value) {
            addCriterion("supplierOrderAddress like", value, "supplierOrderAddress");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderAddressNotLike(String value) {
            addCriterion("supplierOrderAddress not like", value, "supplierOrderAddress");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderAddressIn(List<String> values) {
            addCriterion("supplierOrderAddress in", values, "supplierOrderAddress");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderAddressNotIn(List<String> values) {
            addCriterion("supplierOrderAddress not in", values, "supplierOrderAddress");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderAddressBetween(String value1, String value2) {
            addCriterion("supplierOrderAddress between", value1, value2, "supplierOrderAddress");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderAddressNotBetween(String value1, String value2) {
            addCriterion("supplierOrderAddress not between", value1, value2, "supplierOrderAddress");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderCountIsNull() {
            addCriterion("supplierOrderCount is null");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderCountIsNotNull() {
            addCriterion("supplierOrderCount is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderCountEqualTo(Integer value) {
            addCriterion("supplierOrderCount =", value, "supplierOrderCount");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderCountNotEqualTo(Integer value) {
            addCriterion("supplierOrderCount <>", value, "supplierOrderCount");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderCountGreaterThan(Integer value) {
            addCriterion("supplierOrderCount >", value, "supplierOrderCount");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("supplierOrderCount >=", value, "supplierOrderCount");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderCountLessThan(Integer value) {
            addCriterion("supplierOrderCount <", value, "supplierOrderCount");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderCountLessThanOrEqualTo(Integer value) {
            addCriterion("supplierOrderCount <=", value, "supplierOrderCount");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderCountIn(List<Integer> values) {
            addCriterion("supplierOrderCount in", values, "supplierOrderCount");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderCountNotIn(List<Integer> values) {
            addCriterion("supplierOrderCount not in", values, "supplierOrderCount");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderCountBetween(Integer value1, Integer value2) {
            addCriterion("supplierOrderCount between", value1, value2, "supplierOrderCount");
            return (Criteria) this;
        }

        public Criteria andSupplierOrderCountNotBetween(Integer value1, Integer value2) {
            addCriterion("supplierOrderCount not between", value1, value2, "supplierOrderCount");
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