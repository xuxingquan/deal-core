package com.bill99.base.account.deal.domain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubAcctBalanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubAcctBalanceExample() {
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

        public Criteria andSubAcctIdIsNull() {
            addCriterion("sub_acct_id is null");
            return (Criteria) this;
        }

        public Criteria andSubAcctIdIsNotNull() {
            addCriterion("sub_acct_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubAcctIdEqualTo(String value) {
            addCriterion("sub_acct_id =", value, "subAcctId");
            return (Criteria) this;
        }

        public Criteria andSubAcctIdNotEqualTo(String value) {
            addCriterion("sub_acct_id <>", value, "subAcctId");
            return (Criteria) this;
        }

        public Criteria andSubAcctIdGreaterThan(String value) {
            addCriterion("sub_acct_id >", value, "subAcctId");
            return (Criteria) this;
        }

        public Criteria andSubAcctIdGreaterThanOrEqualTo(String value) {
            addCriterion("sub_acct_id >=", value, "subAcctId");
            return (Criteria) this;
        }

        public Criteria andSubAcctIdLessThan(String value) {
            addCriterion("sub_acct_id <", value, "subAcctId");
            return (Criteria) this;
        }

        public Criteria andSubAcctIdLessThanOrEqualTo(String value) {
            addCriterion("sub_acct_id <=", value, "subAcctId");
            return (Criteria) this;
        }

        public Criteria andSubAcctIdLike(String value) {
            addCriterion("sub_acct_id like", value, "subAcctId");
            return (Criteria) this;
        }

        public Criteria andSubAcctIdNotLike(String value) {
            addCriterion("sub_acct_id not like", value, "subAcctId");
            return (Criteria) this;
        }

        public Criteria andSubAcctIdIn(List<String> values) {
            addCriterion("sub_acct_id in", values, "subAcctId");
            return (Criteria) this;
        }

        public Criteria andSubAcctIdNotIn(List<String> values) {
            addCriterion("sub_acct_id not in", values, "subAcctId");
            return (Criteria) this;
        }

        public Criteria andSubAcctIdBetween(String value1, String value2) {
            addCriterion("sub_acct_id between", value1, value2, "subAcctId");
            return (Criteria) this;
        }

        public Criteria andSubAcctIdNotBetween(String value1, String value2) {
            addCriterion("sub_acct_id not between", value1, value2, "subAcctId");
            return (Criteria) this;
        }

        public Criteria andSubAcctBalanceIsNull() {
            addCriterion("sub_acct_balance is null");
            return (Criteria) this;
        }

        public Criteria andSubAcctBalanceIsNotNull() {
            addCriterion("sub_acct_balance is not null");
            return (Criteria) this;
        }

        public Criteria andSubAcctBalanceEqualTo(Long value) {
            addCriterion("sub_acct_balance =", value, "subAcctBalance");
            return (Criteria) this;
        }

        public Criteria andSubAcctBalanceNotEqualTo(Long value) {
            addCriterion("sub_acct_balance <>", value, "subAcctBalance");
            return (Criteria) this;
        }

        public Criteria andSubAcctBalanceGreaterThan(Long value) {
            addCriterion("sub_acct_balance >", value, "subAcctBalance");
            return (Criteria) this;
        }

        public Criteria andSubAcctBalanceGreaterThanOrEqualTo(Long value) {
            addCriterion("sub_acct_balance >=", value, "subAcctBalance");
            return (Criteria) this;
        }

        public Criteria andSubAcctBalanceLessThan(Long value) {
            addCriterion("sub_acct_balance <", value, "subAcctBalance");
            return (Criteria) this;
        }

        public Criteria andSubAcctBalanceLessThanOrEqualTo(Long value) {
            addCriterion("sub_acct_balance <=", value, "subAcctBalance");
            return (Criteria) this;
        }

        public Criteria andSubAcctBalanceIn(List<Long> values) {
            addCriterion("sub_acct_balance in", values, "subAcctBalance");
            return (Criteria) this;
        }

        public Criteria andSubAcctBalanceNotIn(List<Long> values) {
            addCriterion("sub_acct_balance not in", values, "subAcctBalance");
            return (Criteria) this;
        }

        public Criteria andSubAcctBalanceBetween(Long value1, Long value2) {
            addCriterion("sub_acct_balance between", value1, value2, "subAcctBalance");
            return (Criteria) this;
        }

        public Criteria andSubAcctBalanceNotBetween(Long value1, Long value2) {
            addCriterion("sub_acct_balance not between", value1, value2, "subAcctBalance");
            return (Criteria) this;
        }

        public Criteria andCreditbalanceIsNull() {
            addCriterion("CREDITBALANCE is null");
            return (Criteria) this;
        }

        public Criteria andCreditbalanceIsNotNull() {
            addCriterion("CREDITBALANCE is not null");
            return (Criteria) this;
        }

        public Criteria andCreditbalanceEqualTo(Long value) {
            addCriterion("CREDITBALANCE =", value, "creditbalance");
            return (Criteria) this;
        }

        public Criteria andCreditbalanceNotEqualTo(Long value) {
            addCriterion("CREDITBALANCE <>", value, "creditbalance");
            return (Criteria) this;
        }

        public Criteria andCreditbalanceGreaterThan(Long value) {
            addCriterion("CREDITBALANCE >", value, "creditbalance");
            return (Criteria) this;
        }

        public Criteria andCreditbalanceGreaterThanOrEqualTo(Long value) {
            addCriterion("CREDITBALANCE >=", value, "creditbalance");
            return (Criteria) this;
        }

        public Criteria andCreditbalanceLessThan(Long value) {
            addCriterion("CREDITBALANCE <", value, "creditbalance");
            return (Criteria) this;
        }

        public Criteria andCreditbalanceLessThanOrEqualTo(Long value) {
            addCriterion("CREDITBALANCE <=", value, "creditbalance");
            return (Criteria) this;
        }

        public Criteria andCreditbalanceIn(List<Long> values) {
            addCriterion("CREDITBALANCE in", values, "creditbalance");
            return (Criteria) this;
        }

        public Criteria andCreditbalanceNotIn(List<Long> values) {
            addCriterion("CREDITBALANCE not in", values, "creditbalance");
            return (Criteria) this;
        }

        public Criteria andCreditbalanceBetween(Long value1, Long value2) {
            addCriterion("CREDITBALANCE between", value1, value2, "creditbalance");
            return (Criteria) this;
        }

        public Criteria andCreditbalanceNotBetween(Long value1, Long value2) {
            addCriterion("CREDITBALANCE not between", value1, value2, "creditbalance");
            return (Criteria) this;
        }

        public Criteria andDebitbalanceIsNull() {
            addCriterion("DEBITBALANCE is null");
            return (Criteria) this;
        }

        public Criteria andDebitbalanceIsNotNull() {
            addCriterion("DEBITBALANCE is not null");
            return (Criteria) this;
        }

        public Criteria andDebitbalanceEqualTo(Long value) {
            addCriterion("DEBITBALANCE =", value, "debitbalance");
            return (Criteria) this;
        }

        public Criteria andDebitbalanceNotEqualTo(Long value) {
            addCriterion("DEBITBALANCE <>", value, "debitbalance");
            return (Criteria) this;
        }

        public Criteria andDebitbalanceGreaterThan(Long value) {
            addCriterion("DEBITBALANCE >", value, "debitbalance");
            return (Criteria) this;
        }

        public Criteria andDebitbalanceGreaterThanOrEqualTo(Long value) {
            addCriterion("DEBITBALANCE >=", value, "debitbalance");
            return (Criteria) this;
        }

        public Criteria andDebitbalanceLessThan(Long value) {
            addCriterion("DEBITBALANCE <", value, "debitbalance");
            return (Criteria) this;
        }

        public Criteria andDebitbalanceLessThanOrEqualTo(Long value) {
            addCriterion("DEBITBALANCE <=", value, "debitbalance");
            return (Criteria) this;
        }

        public Criteria andDebitbalanceIn(List<Long> values) {
            addCriterion("DEBITBALANCE in", values, "debitbalance");
            return (Criteria) this;
        }

        public Criteria andDebitbalanceNotIn(List<Long> values) {
            addCriterion("DEBITBALANCE not in", values, "debitbalance");
            return (Criteria) this;
        }

        public Criteria andDebitbalanceBetween(Long value1, Long value2) {
            addCriterion("DEBITBALANCE between", value1, value2, "debitbalance");
            return (Criteria) this;
        }

        public Criteria andDebitbalanceNotBetween(Long value1, Long value2) {
            addCriterion("DEBITBALANCE not between", value1, value2, "debitbalance");
            return (Criteria) this;
        }

        public Criteria andFrozenbalanceIsNull() {
            addCriterion("FROZENBALANCE is null");
            return (Criteria) this;
        }

        public Criteria andFrozenbalanceIsNotNull() {
            addCriterion("FROZENBALANCE is not null");
            return (Criteria) this;
        }

        public Criteria andFrozenbalanceEqualTo(Long value) {
            addCriterion("FROZENBALANCE =", value, "frozenbalance");
            return (Criteria) this;
        }

        public Criteria andFrozenbalanceNotEqualTo(Long value) {
            addCriterion("FROZENBALANCE <>", value, "frozenbalance");
            return (Criteria) this;
        }

        public Criteria andFrozenbalanceGreaterThan(Long value) {
            addCriterion("FROZENBALANCE >", value, "frozenbalance");
            return (Criteria) this;
        }

        public Criteria andFrozenbalanceGreaterThanOrEqualTo(Long value) {
            addCriterion("FROZENBALANCE >=", value, "frozenbalance");
            return (Criteria) this;
        }

        public Criteria andFrozenbalanceLessThan(Long value) {
            addCriterion("FROZENBALANCE <", value, "frozenbalance");
            return (Criteria) this;
        }

        public Criteria andFrozenbalanceLessThanOrEqualTo(Long value) {
            addCriterion("FROZENBALANCE <=", value, "frozenbalance");
            return (Criteria) this;
        }

        public Criteria andFrozenbalanceIn(List<Long> values) {
            addCriterion("FROZENBALANCE in", values, "frozenbalance");
            return (Criteria) this;
        }

        public Criteria andFrozenbalanceNotIn(List<Long> values) {
            addCriterion("FROZENBALANCE not in", values, "frozenbalance");
            return (Criteria) this;
        }

        public Criteria andFrozenbalanceBetween(Long value1, Long value2) {
            addCriterion("FROZENBALANCE between", value1, value2, "frozenbalance");
            return (Criteria) this;
        }

        public Criteria andFrozenbalanceNotBetween(Long value1, Long value2) {
            addCriterion("FROZENBALANCE not between", value1, value2, "frozenbalance");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIsNull() {
            addCriterion("CRT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIsNotNull() {
            addCriterion("CRT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCrtTimeEqualTo(Date value) {
            addCriterion("CRT_TIME =", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotEqualTo(Date value) {
            addCriterion("CRT_TIME <>", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeGreaterThan(Date value) {
            addCriterion("CRT_TIME >", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CRT_TIME >=", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeLessThan(Date value) {
            addCriterion("CRT_TIME <", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeLessThanOrEqualTo(Date value) {
            addCriterion("CRT_TIME <=", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIn(List<Date> values) {
            addCriterion("CRT_TIME in", values, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotIn(List<Date> values) {
            addCriterion("CRT_TIME not in", values, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeBetween(Date value1, Date value2) {
            addCriterion("CRT_TIME between", value1, value2, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotBetween(Date value1, Date value2) {
            addCriterion("CRT_TIME not between", value1, value2, "crtTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIsNull() {
            addCriterion("UPD_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIsNotNull() {
            addCriterion("UPD_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdTimeEqualTo(Date value) {
            addCriterion("UPD_TIME =", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotEqualTo(Date value) {
            addCriterion("UPD_TIME <>", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeGreaterThan(Date value) {
            addCriterion("UPD_TIME >", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPD_TIME >=", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeLessThan(Date value) {
            addCriterion("UPD_TIME <", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPD_TIME <=", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIn(List<Date> values) {
            addCriterion("UPD_TIME in", values, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotIn(List<Date> values) {
            addCriterion("UPD_TIME not in", values, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeBetween(Date value1, Date value2) {
            addCriterion("UPD_TIME between", value1, value2, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPD_TIME not between", value1, value2, "updTime");
            return (Criteria) this;
        }

        public Criteria andExt1IsNull() {
            addCriterion("ext1 is null");
            return (Criteria) this;
        }

        public Criteria andExt1IsNotNull() {
            addCriterion("ext1 is not null");
            return (Criteria) this;
        }

        public Criteria andExt1EqualTo(String value) {
            addCriterion("ext1 =", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotEqualTo(String value) {
            addCriterion("ext1 <>", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThan(String value) {
            addCriterion("ext1 >", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThanOrEqualTo(String value) {
            addCriterion("ext1 >=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThan(String value) {
            addCriterion("ext1 <", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThanOrEqualTo(String value) {
            addCriterion("ext1 <=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Like(String value) {
            addCriterion("ext1 like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotLike(String value) {
            addCriterion("ext1 not like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1In(List<String> values) {
            addCriterion("ext1 in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotIn(List<String> values) {
            addCriterion("ext1 not in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Between(String value1, String value2) {
            addCriterion("ext1 between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotBetween(String value1, String value2) {
            addCriterion("ext1 not between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt2IsNull() {
            addCriterion("ext2 is null");
            return (Criteria) this;
        }

        public Criteria andExt2IsNotNull() {
            addCriterion("ext2 is not null");
            return (Criteria) this;
        }

        public Criteria andExt2EqualTo(String value) {
            addCriterion("ext2 =", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotEqualTo(String value) {
            addCriterion("ext2 <>", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThan(String value) {
            addCriterion("ext2 >", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThanOrEqualTo(String value) {
            addCriterion("ext2 >=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThan(String value) {
            addCriterion("ext2 <", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThanOrEqualTo(String value) {
            addCriterion("ext2 <=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Like(String value) {
            addCriterion("ext2 like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotLike(String value) {
            addCriterion("ext2 not like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2In(List<String> values) {
            addCriterion("ext2 in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotIn(List<String> values) {
            addCriterion("ext2 not in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Between(String value1, String value2) {
            addCriterion("ext2 between", value1, value2, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotBetween(String value1, String value2) {
            addCriterion("ext2 not between", value1, value2, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt3IsNull() {
            addCriterion("ext3 is null");
            return (Criteria) this;
        }

        public Criteria andExt3IsNotNull() {
            addCriterion("ext3 is not null");
            return (Criteria) this;
        }

        public Criteria andExt3EqualTo(String value) {
            addCriterion("ext3 =", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotEqualTo(String value) {
            addCriterion("ext3 <>", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3GreaterThan(String value) {
            addCriterion("ext3 >", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3GreaterThanOrEqualTo(String value) {
            addCriterion("ext3 >=", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3LessThan(String value) {
            addCriterion("ext3 <", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3LessThanOrEqualTo(String value) {
            addCriterion("ext3 <=", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3Like(String value) {
            addCriterion("ext3 like", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotLike(String value) {
            addCriterion("ext3 not like", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3In(List<String> values) {
            addCriterion("ext3 in", values, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotIn(List<String> values) {
            addCriterion("ext3 not in", values, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3Between(String value1, String value2) {
            addCriterion("ext3 between", value1, value2, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotBetween(String value1, String value2) {
            addCriterion("ext3 not between", value1, value2, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt4IsNull() {
            addCriterion("ext4 is null");
            return (Criteria) this;
        }

        public Criteria andExt4IsNotNull() {
            addCriterion("ext4 is not null");
            return (Criteria) this;
        }

        public Criteria andExt4EqualTo(String value) {
            addCriterion("ext4 =", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4NotEqualTo(String value) {
            addCriterion("ext4 <>", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4GreaterThan(String value) {
            addCriterion("ext4 >", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4GreaterThanOrEqualTo(String value) {
            addCriterion("ext4 >=", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4LessThan(String value) {
            addCriterion("ext4 <", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4LessThanOrEqualTo(String value) {
            addCriterion("ext4 <=", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4Like(String value) {
            addCriterion("ext4 like", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4NotLike(String value) {
            addCriterion("ext4 not like", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4In(List<String> values) {
            addCriterion("ext4 in", values, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4NotIn(List<String> values) {
            addCriterion("ext4 not in", values, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4Between(String value1, String value2) {
            addCriterion("ext4 between", value1, value2, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4NotBetween(String value1, String value2) {
            addCriterion("ext4 not between", value1, value2, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt5IsNull() {
            addCriterion("ext5 is null");
            return (Criteria) this;
        }

        public Criteria andExt5IsNotNull() {
            addCriterion("ext5 is not null");
            return (Criteria) this;
        }

        public Criteria andExt5EqualTo(String value) {
            addCriterion("ext5 =", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5NotEqualTo(String value) {
            addCriterion("ext5 <>", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5GreaterThan(String value) {
            addCriterion("ext5 >", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5GreaterThanOrEqualTo(String value) {
            addCriterion("ext5 >=", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5LessThan(String value) {
            addCriterion("ext5 <", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5LessThanOrEqualTo(String value) {
            addCriterion("ext5 <=", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5Like(String value) {
            addCriterion("ext5 like", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5NotLike(String value) {
            addCriterion("ext5 not like", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5In(List<String> values) {
            addCriterion("ext5 in", values, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5NotIn(List<String> values) {
            addCriterion("ext5 not in", values, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5Between(String value1, String value2) {
            addCriterion("ext5 between", value1, value2, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5NotBetween(String value1, String value2) {
            addCriterion("ext5 not between", value1, value2, "ext5");
            return (Criteria) this;
        }

        public Criteria andAllowWithdrawBalanceIsNull() {
            addCriterion("allow_withDraw_balance is null");
            return (Criteria) this;
        }

        public Criteria andAllowWithdrawBalanceIsNotNull() {
            addCriterion("allow_withDraw_balance is not null");
            return (Criteria) this;
        }

        public Criteria andAllowWithdrawBalanceEqualTo(Long value) {
            addCriterion("allow_withDraw_balance =", value, "allowWithdrawBalance");
            return (Criteria) this;
        }

        public Criteria andAllowWithdrawBalanceNotEqualTo(Long value) {
            addCriterion("allow_withDraw_balance <>", value, "allowWithdrawBalance");
            return (Criteria) this;
        }

        public Criteria andAllowWithdrawBalanceGreaterThan(Long value) {
            addCriterion("allow_withDraw_balance >", value, "allowWithdrawBalance");
            return (Criteria) this;
        }

        public Criteria andAllowWithdrawBalanceGreaterThanOrEqualTo(Long value) {
            addCriterion("allow_withDraw_balance >=", value, "allowWithdrawBalance");
            return (Criteria) this;
        }

        public Criteria andAllowWithdrawBalanceLessThan(Long value) {
            addCriterion("allow_withDraw_balance <", value, "allowWithdrawBalance");
            return (Criteria) this;
        }

        public Criteria andAllowWithdrawBalanceLessThanOrEqualTo(Long value) {
            addCriterion("allow_withDraw_balance <=", value, "allowWithdrawBalance");
            return (Criteria) this;
        }

        public Criteria andAllowWithdrawBalanceIn(List<Long> values) {
            addCriterion("allow_withDraw_balance in", values, "allowWithdrawBalance");
            return (Criteria) this;
        }

        public Criteria andAllowWithdrawBalanceNotIn(List<Long> values) {
            addCriterion("allow_withDraw_balance not in", values, "allowWithdrawBalance");
            return (Criteria) this;
        }

        public Criteria andAllowWithdrawBalanceBetween(Long value1, Long value2) {
            addCriterion("allow_withDraw_balance between", value1, value2, "allowWithdrawBalance");
            return (Criteria) this;
        }

        public Criteria andAllowWithdrawBalanceNotBetween(Long value1, Long value2) {
            addCriterion("allow_withDraw_balance not between", value1, value2, "allowWithdrawBalance");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Long value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Long value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Long value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Long value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Long value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Long> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Long> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Long value1, Long value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Long value1, Long value2) {
            addCriterion("version not between", value1, value2, "version");
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