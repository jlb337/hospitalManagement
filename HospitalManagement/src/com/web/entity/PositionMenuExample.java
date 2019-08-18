package com.web.entity;

import java.util.ArrayList;
import java.util.List;

public class PositionMenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public PositionMenuExample() {
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

        public Criteria andMenuIDIsNull() {
            addCriterion("menuID is null");
            return (Criteria) this;
        }

        public Criteria andMenuIDIsNotNull() {
            addCriterion("menuID is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIDEqualTo(Integer value) {
            addCriterion("menuID =", value, "menuID");
            return (Criteria) this;
        }

        public Criteria andMenuIDNotEqualTo(Integer value) {
            addCriterion("menuID <>", value, "menuID");
            return (Criteria) this;
        }

        public Criteria andMenuIDGreaterThan(Integer value) {
            addCriterion("menuID >", value, "menuID");
            return (Criteria) this;
        }

        public Criteria andMenuIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("menuID >=", value, "menuID");
            return (Criteria) this;
        }

        public Criteria andMenuIDLessThan(Integer value) {
            addCriterion("menuID <", value, "menuID");
            return (Criteria) this;
        }

        public Criteria andMenuIDLessThanOrEqualTo(Integer value) {
            addCriterion("menuID <=", value, "menuID");
            return (Criteria) this;
        }

        public Criteria andMenuIDIn(List<Integer> values) {
            addCriterion("menuID in", values, "menuID");
            return (Criteria) this;
        }

        public Criteria andMenuIDNotIn(List<Integer> values) {
            addCriterion("menuID not in", values, "menuID");
            return (Criteria) this;
        }

        public Criteria andMenuIDBetween(Integer value1, Integer value2) {
            addCriterion("menuID between", value1, value2, "menuID");
            return (Criteria) this;
        }

        public Criteria andMenuIDNotBetween(Integer value1, Integer value2) {
            addCriterion("menuID not between", value1, value2, "menuID");
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

        public Criteria andPositionMenuIDIsNull() {
            addCriterion("positionMenuID is null");
            return (Criteria) this;
        }

        public Criteria andPositionMenuIDIsNotNull() {
            addCriterion("positionMenuID is not null");
            return (Criteria) this;
        }

        public Criteria andPositionMenuIDEqualTo(Integer value) {
            addCriterion("positionMenuID =", value, "positionMenuID");
            return (Criteria) this;
        }

        public Criteria andPositionMenuIDNotEqualTo(Integer value) {
            addCriterion("positionMenuID <>", value, "positionMenuID");
            return (Criteria) this;
        }

        public Criteria andPositionMenuIDGreaterThan(Integer value) {
            addCriterion("positionMenuID >", value, "positionMenuID");
            return (Criteria) this;
        }

        public Criteria andPositionMenuIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("positionMenuID >=", value, "positionMenuID");
            return (Criteria) this;
        }

        public Criteria andPositionMenuIDLessThan(Integer value) {
            addCriterion("positionMenuID <", value, "positionMenuID");
            return (Criteria) this;
        }

        public Criteria andPositionMenuIDLessThanOrEqualTo(Integer value) {
            addCriterion("positionMenuID <=", value, "positionMenuID");
            return (Criteria) this;
        }

        public Criteria andPositionMenuIDIn(List<Integer> values) {
            addCriterion("positionMenuID in", values, "positionMenuID");
            return (Criteria) this;
        }

        public Criteria andPositionMenuIDNotIn(List<Integer> values) {
            addCriterion("positionMenuID not in", values, "positionMenuID");
            return (Criteria) this;
        }

        public Criteria andPositionMenuIDBetween(Integer value1, Integer value2) {
            addCriterion("positionMenuID between", value1, value2, "positionMenuID");
            return (Criteria) this;
        }

        public Criteria andPositionMenuIDNotBetween(Integer value1, Integer value2) {
            addCriterion("positionMenuID not between", value1, value2, "positionMenuID");
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