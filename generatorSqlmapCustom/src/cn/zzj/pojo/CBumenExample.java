package cn.zzj.pojo;

import java.util.ArrayList;
import java.util.List;

public class CBumenExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CBumenExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSuoshubumenIsNull() {
            addCriterion("suoshubumen is null");
            return (Criteria) this;
        }

        public Criteria andSuoshubumenIsNotNull() {
            addCriterion("suoshubumen is not null");
            return (Criteria) this;
        }

        public Criteria andSuoshubumenEqualTo(String value) {
            addCriterion("suoshubumen =", value, "suoshubumen");
            return (Criteria) this;
        }

        public Criteria andSuoshubumenNotEqualTo(String value) {
            addCriterion("suoshubumen <>", value, "suoshubumen");
            return (Criteria) this;
        }

        public Criteria andSuoshubumenGreaterThan(String value) {
            addCriterion("suoshubumen >", value, "suoshubumen");
            return (Criteria) this;
        }

        public Criteria andSuoshubumenGreaterThanOrEqualTo(String value) {
            addCriterion("suoshubumen >=", value, "suoshubumen");
            return (Criteria) this;
        }

        public Criteria andSuoshubumenLessThan(String value) {
            addCriterion("suoshubumen <", value, "suoshubumen");
            return (Criteria) this;
        }

        public Criteria andSuoshubumenLessThanOrEqualTo(String value) {
            addCriterion("suoshubumen <=", value, "suoshubumen");
            return (Criteria) this;
        }

        public Criteria andSuoshubumenLike(String value) {
            addCriterion("suoshubumen like", value, "suoshubumen");
            return (Criteria) this;
        }

        public Criteria andSuoshubumenNotLike(String value) {
            addCriterion("suoshubumen not like", value, "suoshubumen");
            return (Criteria) this;
        }

        public Criteria andSuoshubumenIn(List<String> values) {
            addCriterion("suoshubumen in", values, "suoshubumen");
            return (Criteria) this;
        }

        public Criteria andSuoshubumenNotIn(List<String> values) {
            addCriterion("suoshubumen not in", values, "suoshubumen");
            return (Criteria) this;
        }

        public Criteria andSuoshubumenBetween(String value1, String value2) {
            addCriterion("suoshubumen between", value1, value2, "suoshubumen");
            return (Criteria) this;
        }

        public Criteria andSuoshubumenNotBetween(String value1, String value2) {
            addCriterion("suoshubumen not between", value1, value2, "suoshubumen");
            return (Criteria) this;
        }

        public Criteria andBumenmingchengIsNull() {
            addCriterion("bumenmingcheng is null");
            return (Criteria) this;
        }

        public Criteria andBumenmingchengIsNotNull() {
            addCriterion("bumenmingcheng is not null");
            return (Criteria) this;
        }

        public Criteria andBumenmingchengEqualTo(String value) {
            addCriterion("bumenmingcheng =", value, "bumenmingcheng");
            return (Criteria) this;
        }

        public Criteria andBumenmingchengNotEqualTo(String value) {
            addCriterion("bumenmingcheng <>", value, "bumenmingcheng");
            return (Criteria) this;
        }

        public Criteria andBumenmingchengGreaterThan(String value) {
            addCriterion("bumenmingcheng >", value, "bumenmingcheng");
            return (Criteria) this;
        }

        public Criteria andBumenmingchengGreaterThanOrEqualTo(String value) {
            addCriterion("bumenmingcheng >=", value, "bumenmingcheng");
            return (Criteria) this;
        }

        public Criteria andBumenmingchengLessThan(String value) {
            addCriterion("bumenmingcheng <", value, "bumenmingcheng");
            return (Criteria) this;
        }

        public Criteria andBumenmingchengLessThanOrEqualTo(String value) {
            addCriterion("bumenmingcheng <=", value, "bumenmingcheng");
            return (Criteria) this;
        }

        public Criteria andBumenmingchengLike(String value) {
            addCriterion("bumenmingcheng like", value, "bumenmingcheng");
            return (Criteria) this;
        }

        public Criteria andBumenmingchengNotLike(String value) {
            addCriterion("bumenmingcheng not like", value, "bumenmingcheng");
            return (Criteria) this;
        }

        public Criteria andBumenmingchengIn(List<String> values) {
            addCriterion("bumenmingcheng in", values, "bumenmingcheng");
            return (Criteria) this;
        }

        public Criteria andBumenmingchengNotIn(List<String> values) {
            addCriterion("bumenmingcheng not in", values, "bumenmingcheng");
            return (Criteria) this;
        }

        public Criteria andBumenmingchengBetween(String value1, String value2) {
            addCriterion("bumenmingcheng between", value1, value2, "bumenmingcheng");
            return (Criteria) this;
        }

        public Criteria andBumenmingchengNotBetween(String value1, String value2) {
            addCriterion("bumenmingcheng not between", value1, value2, "bumenmingcheng");
            return (Criteria) this;
        }

        public Criteria andSuoshubumenidIsNull() {
            addCriterion("suoshubumenID is null");
            return (Criteria) this;
        }

        public Criteria andSuoshubumenidIsNotNull() {
            addCriterion("suoshubumenID is not null");
            return (Criteria) this;
        }

        public Criteria andSuoshubumenidEqualTo(Integer value) {
            addCriterion("suoshubumenID =", value, "suoshubumenid");
            return (Criteria) this;
        }

        public Criteria andSuoshubumenidNotEqualTo(Integer value) {
            addCriterion("suoshubumenID <>", value, "suoshubumenid");
            return (Criteria) this;
        }

        public Criteria andSuoshubumenidGreaterThan(Integer value) {
            addCriterion("suoshubumenID >", value, "suoshubumenid");
            return (Criteria) this;
        }

        public Criteria andSuoshubumenidGreaterThanOrEqualTo(Integer value) {
            addCriterion("suoshubumenID >=", value, "suoshubumenid");
            return (Criteria) this;
        }

        public Criteria andSuoshubumenidLessThan(Integer value) {
            addCriterion("suoshubumenID <", value, "suoshubumenid");
            return (Criteria) this;
        }

        public Criteria andSuoshubumenidLessThanOrEqualTo(Integer value) {
            addCriterion("suoshubumenID <=", value, "suoshubumenid");
            return (Criteria) this;
        }

        public Criteria andSuoshubumenidIn(List<Integer> values) {
            addCriterion("suoshubumenID in", values, "suoshubumenid");
            return (Criteria) this;
        }

        public Criteria andSuoshubumenidNotIn(List<Integer> values) {
            addCriterion("suoshubumenID not in", values, "suoshubumenid");
            return (Criteria) this;
        }

        public Criteria andSuoshubumenidBetween(Integer value1, Integer value2) {
            addCriterion("suoshubumenID between", value1, value2, "suoshubumenid");
            return (Criteria) this;
        }

        public Criteria andSuoshubumenidNotBetween(Integer value1, Integer value2) {
            addCriterion("suoshubumenID not between", value1, value2, "suoshubumenid");
            return (Criteria) this;
        }
    }

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