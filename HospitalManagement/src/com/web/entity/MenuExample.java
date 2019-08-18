package com.web.entity;

import java.util.ArrayList;
import java.util.List;

public class MenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public MenuExample() {
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

        public Criteria andMenuNameIsNull() {
            addCriterion("menuName is null");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNotNull() {
            addCriterion("menuName is not null");
            return (Criteria) this;
        }

        public Criteria andMenuNameEqualTo(String value) {
            addCriterion("menuName =", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotEqualTo(String value) {
            addCriterion("menuName <>", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThan(String value) {
            addCriterion("menuName >", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThanOrEqualTo(String value) {
            addCriterion("menuName >=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThan(String value) {
            addCriterion("menuName <", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThanOrEqualTo(String value) {
            addCriterion("menuName <=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLike(String value) {
            addCriterion("menuName like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotLike(String value) {
            addCriterion("menuName not like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameIn(List<String> values) {
            addCriterion("menuName in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotIn(List<String> values) {
            addCriterion("menuName not in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameBetween(String value1, String value2) {
            addCriterion("menuName between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotBetween(String value1, String value2) {
            addCriterion("menuName not between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIsNull() {
            addCriterion("menuUrl is null");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIsNotNull() {
            addCriterion("menuUrl is not null");
            return (Criteria) this;
        }

        public Criteria andMenuUrlEqualTo(String value) {
            addCriterion("menuUrl =", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotEqualTo(String value) {
            addCriterion("menuUrl <>", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlGreaterThan(String value) {
            addCriterion("menuUrl >", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlGreaterThanOrEqualTo(String value) {
            addCriterion("menuUrl >=", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLessThan(String value) {
            addCriterion("menuUrl <", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLessThanOrEqualTo(String value) {
            addCriterion("menuUrl <=", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLike(String value) {
            addCriterion("menuUrl like", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotLike(String value) {
            addCriterion("menuUrl not like", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIn(List<String> values) {
            addCriterion("menuUrl in", values, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotIn(List<String> values) {
            addCriterion("menuUrl not in", values, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlBetween(String value1, String value2) {
            addCriterion("menuUrl between", value1, value2, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotBetween(String value1, String value2) {
            addCriterion("menuUrl not between", value1, value2, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuImageIsNull() {
            addCriterion("menuImage is null");
            return (Criteria) this;
        }

        public Criteria andMenuImageIsNotNull() {
            addCriterion("menuImage is not null");
            return (Criteria) this;
        }

        public Criteria andMenuImageEqualTo(String value) {
            addCriterion("menuImage =", value, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageNotEqualTo(String value) {
            addCriterion("menuImage <>", value, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageGreaterThan(String value) {
            addCriterion("menuImage >", value, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageGreaterThanOrEqualTo(String value) {
            addCriterion("menuImage >=", value, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageLessThan(String value) {
            addCriterion("menuImage <", value, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageLessThanOrEqualTo(String value) {
            addCriterion("menuImage <=", value, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageLike(String value) {
            addCriterion("menuImage like", value, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageNotLike(String value) {
            addCriterion("menuImage not like", value, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageIn(List<String> values) {
            addCriterion("menuImage in", values, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageNotIn(List<String> values) {
            addCriterion("menuImage not in", values, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageBetween(String value1, String value2) {
            addCriterion("menuImage between", value1, value2, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageNotBetween(String value1, String value2) {
            addCriterion("menuImage not between", value1, value2, "menuImage");
            return (Criteria) this;
        }

        public Criteria andParentIDIsNull() {
            addCriterion("parentID is null");
            return (Criteria) this;
        }

        public Criteria andParentIDIsNotNull() {
            addCriterion("parentID is not null");
            return (Criteria) this;
        }

        public Criteria andParentIDEqualTo(Integer value) {
            addCriterion("parentID =", value, "parentID");
            return (Criteria) this;
        }

        public Criteria andParentIDNotEqualTo(Integer value) {
            addCriterion("parentID <>", value, "parentID");
            return (Criteria) this;
        }

        public Criteria andParentIDGreaterThan(Integer value) {
            addCriterion("parentID >", value, "parentID");
            return (Criteria) this;
        }

        public Criteria andParentIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("parentID >=", value, "parentID");
            return (Criteria) this;
        }

        public Criteria andParentIDLessThan(Integer value) {
            addCriterion("parentID <", value, "parentID");
            return (Criteria) this;
        }

        public Criteria andParentIDLessThanOrEqualTo(Integer value) {
            addCriterion("parentID <=", value, "parentID");
            return (Criteria) this;
        }

        public Criteria andParentIDIn(List<Integer> values) {
            addCriterion("parentID in", values, "parentID");
            return (Criteria) this;
        }

        public Criteria andParentIDNotIn(List<Integer> values) {
            addCriterion("parentID not in", values, "parentID");
            return (Criteria) this;
        }

        public Criteria andParentIDBetween(Integer value1, Integer value2) {
            addCriterion("parentID between", value1, value2, "parentID");
            return (Criteria) this;
        }

        public Criteria andParentIDNotBetween(Integer value1, Integer value2) {
            addCriterion("parentID not between", value1, value2, "parentID");
            return (Criteria) this;
        }

        public Criteria andMenuLevelIsNull() {
            addCriterion("menuLevel is null");
            return (Criteria) this;
        }

        public Criteria andMenuLevelIsNotNull() {
            addCriterion("menuLevel is not null");
            return (Criteria) this;
        }

        public Criteria andMenuLevelEqualTo(Integer value) {
            addCriterion("menuLevel =", value, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andMenuLevelNotEqualTo(Integer value) {
            addCriterion("menuLevel <>", value, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andMenuLevelGreaterThan(Integer value) {
            addCriterion("menuLevel >", value, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andMenuLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("menuLevel >=", value, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andMenuLevelLessThan(Integer value) {
            addCriterion("menuLevel <", value, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andMenuLevelLessThanOrEqualTo(Integer value) {
            addCriterion("menuLevel <=", value, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andMenuLevelIn(List<Integer> values) {
            addCriterion("menuLevel in", values, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andMenuLevelNotIn(List<Integer> values) {
            addCriterion("menuLevel not in", values, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andMenuLevelBetween(Integer value1, Integer value2) {
            addCriterion("menuLevel between", value1, value2, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andMenuLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("menuLevel not between", value1, value2, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andMenuSortIsNull() {
            addCriterion("menuSort is null");
            return (Criteria) this;
        }

        public Criteria andMenuSortIsNotNull() {
            addCriterion("menuSort is not null");
            return (Criteria) this;
        }

        public Criteria andMenuSortEqualTo(Integer value) {
            addCriterion("menuSort =", value, "menuSort");
            return (Criteria) this;
        }

        public Criteria andMenuSortNotEqualTo(Integer value) {
            addCriterion("menuSort <>", value, "menuSort");
            return (Criteria) this;
        }

        public Criteria andMenuSortGreaterThan(Integer value) {
            addCriterion("menuSort >", value, "menuSort");
            return (Criteria) this;
        }

        public Criteria andMenuSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("menuSort >=", value, "menuSort");
            return (Criteria) this;
        }

        public Criteria andMenuSortLessThan(Integer value) {
            addCriterion("menuSort <", value, "menuSort");
            return (Criteria) this;
        }

        public Criteria andMenuSortLessThanOrEqualTo(Integer value) {
            addCriterion("menuSort <=", value, "menuSort");
            return (Criteria) this;
        }

        public Criteria andMenuSortIn(List<Integer> values) {
            addCriterion("menuSort in", values, "menuSort");
            return (Criteria) this;
        }

        public Criteria andMenuSortNotIn(List<Integer> values) {
            addCriterion("menuSort not in", values, "menuSort");
            return (Criteria) this;
        }

        public Criteria andMenuSortBetween(Integer value1, Integer value2) {
            addCriterion("menuSort between", value1, value2, "menuSort");
            return (Criteria) this;
        }

        public Criteria andMenuSortNotBetween(Integer value1, Integer value2) {
            addCriterion("menuSort not between", value1, value2, "menuSort");
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