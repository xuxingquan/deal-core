package com.bill99.base.account.deal.domain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubAccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubAccountExample() {
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

        public Criteria andMemberCodeIsNull() {
            addCriterion("member_code is null");
            return (Criteria) this;
        }

        public Criteria andMemberCodeIsNotNull() {
            addCriterion("member_code is not null");
            return (Criteria) this;
        }

        public Criteria andMemberCodeEqualTo(String value) {
            addCriterion("member_code =", value, "memberCode");
            return (Criteria) this;
        }

        public Criteria andMemberCodeNotEqualTo(String value) {
            addCriterion("member_code <>", value, "memberCode");
            return (Criteria) this;
        }

        public Criteria andMemberCodeGreaterThan(String value) {
            addCriterion("member_code >", value, "memberCode");
            return (Criteria) this;
        }

        public Criteria andMemberCodeGreaterThanOrEqualTo(String value) {
            addCriterion("member_code >=", value, "memberCode");
            return (Criteria) this;
        }

        public Criteria andMemberCodeLessThan(String value) {
            addCriterion("member_code <", value, "memberCode");
            return (Criteria) this;
        }

        public Criteria andMemberCodeLessThanOrEqualTo(String value) {
            addCriterion("member_code <=", value, "memberCode");
            return (Criteria) this;
        }

        public Criteria andMemberCodeLike(String value) {
            addCriterion("member_code like", value, "memberCode");
            return (Criteria) this;
        }

        public Criteria andMemberCodeNotLike(String value) {
            addCriterion("member_code not like", value, "memberCode");
            return (Criteria) this;
        }

        public Criteria andMemberCodeIn(List<String> values) {
            addCriterion("member_code in", values, "memberCode");
            return (Criteria) this;
        }

        public Criteria andMemberCodeNotIn(List<String> values) {
            addCriterion("member_code not in", values, "memberCode");
            return (Criteria) this;
        }

        public Criteria andMemberCodeBetween(String value1, String value2) {
            addCriterion("member_code between", value1, value2, "memberCode");
            return (Criteria) this;
        }

        public Criteria andMemberCodeNotBetween(String value1, String value2) {
            addCriterion("member_code not between", value1, value2, "memberCode");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSubAcctNameIsNull() {
            addCriterion("sub_acct_name is null");
            return (Criteria) this;
        }

        public Criteria andSubAcctNameIsNotNull() {
            addCriterion("sub_acct_name is not null");
            return (Criteria) this;
        }

        public Criteria andSubAcctNameEqualTo(String value) {
            addCriterion("sub_acct_name =", value, "subAcctName");
            return (Criteria) this;
        }

        public Criteria andSubAcctNameNotEqualTo(String value) {
            addCriterion("sub_acct_name <>", value, "subAcctName");
            return (Criteria) this;
        }

        public Criteria andSubAcctNameGreaterThan(String value) {
            addCriterion("sub_acct_name >", value, "subAcctName");
            return (Criteria) this;
        }

        public Criteria andSubAcctNameGreaterThanOrEqualTo(String value) {
            addCriterion("sub_acct_name >=", value, "subAcctName");
            return (Criteria) this;
        }

        public Criteria andSubAcctNameLessThan(String value) {
            addCriterion("sub_acct_name <", value, "subAcctName");
            return (Criteria) this;
        }

        public Criteria andSubAcctNameLessThanOrEqualTo(String value) {
            addCriterion("sub_acct_name <=", value, "subAcctName");
            return (Criteria) this;
        }

        public Criteria andSubAcctNameLike(String value) {
            addCriterion("sub_acct_name like", value, "subAcctName");
            return (Criteria) this;
        }

        public Criteria andSubAcctNameNotLike(String value) {
            addCriterion("sub_acct_name not like", value, "subAcctName");
            return (Criteria) this;
        }

        public Criteria andSubAcctNameIn(List<String> values) {
            addCriterion("sub_acct_name in", values, "subAcctName");
            return (Criteria) this;
        }

        public Criteria andSubAcctNameNotIn(List<String> values) {
            addCriterion("sub_acct_name not in", values, "subAcctName");
            return (Criteria) this;
        }

        public Criteria andSubAcctNameBetween(String value1, String value2) {
            addCriterion("sub_acct_name between", value1, value2, "subAcctName");
            return (Criteria) this;
        }

        public Criteria andSubAcctNameNotBetween(String value1, String value2) {
            addCriterion("sub_acct_name not between", value1, value2, "subAcctName");
            return (Criteria) this;
        }

        public Criteria andSubAcctTypeIsNull() {
            addCriterion("sub_acct_type is null");
            return (Criteria) this;
        }

        public Criteria andSubAcctTypeIsNotNull() {
            addCriterion("sub_acct_type is not null");
            return (Criteria) this;
        }

        public Criteria andSubAcctTypeEqualTo(String value) {
            addCriterion("sub_acct_type =", value, "subAcctType");
            return (Criteria) this;
        }

        public Criteria andSubAcctTypeNotEqualTo(String value) {
            addCriterion("sub_acct_type <>", value, "subAcctType");
            return (Criteria) this;
        }

        public Criteria andSubAcctTypeGreaterThan(String value) {
            addCriterion("sub_acct_type >", value, "subAcctType");
            return (Criteria) this;
        }

        public Criteria andSubAcctTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sub_acct_type >=", value, "subAcctType");
            return (Criteria) this;
        }

        public Criteria andSubAcctTypeLessThan(String value) {
            addCriterion("sub_acct_type <", value, "subAcctType");
            return (Criteria) this;
        }

        public Criteria andSubAcctTypeLessThanOrEqualTo(String value) {
            addCriterion("sub_acct_type <=", value, "subAcctType");
            return (Criteria) this;
        }

        public Criteria andSubAcctTypeLike(String value) {
            addCriterion("sub_acct_type like", value, "subAcctType");
            return (Criteria) this;
        }

        public Criteria andSubAcctTypeNotLike(String value) {
            addCriterion("sub_acct_type not like", value, "subAcctType");
            return (Criteria) this;
        }

        public Criteria andSubAcctTypeIn(List<String> values) {
            addCriterion("sub_acct_type in", values, "subAcctType");
            return (Criteria) this;
        }

        public Criteria andSubAcctTypeNotIn(List<String> values) {
            addCriterion("sub_acct_type not in", values, "subAcctType");
            return (Criteria) this;
        }

        public Criteria andSubAcctTypeBetween(String value1, String value2) {
            addCriterion("sub_acct_type between", value1, value2, "subAcctType");
            return (Criteria) this;
        }

        public Criteria andSubAcctTypeNotBetween(String value1, String value2) {
            addCriterion("sub_acct_type not between", value1, value2, "subAcctType");
            return (Criteria) this;
        }

        public Criteria andSubAcctDescriptionIsNull() {
            addCriterion("sub_acct_description is null");
            return (Criteria) this;
        }

        public Criteria andSubAcctDescriptionIsNotNull() {
            addCriterion("sub_acct_description is not null");
            return (Criteria) this;
        }

        public Criteria andSubAcctDescriptionEqualTo(String value) {
            addCriterion("sub_acct_description =", value, "subAcctDescription");
            return (Criteria) this;
        }

        public Criteria andSubAcctDescriptionNotEqualTo(String value) {
            addCriterion("sub_acct_description <>", value, "subAcctDescription");
            return (Criteria) this;
        }

        public Criteria andSubAcctDescriptionGreaterThan(String value) {
            addCriterion("sub_acct_description >", value, "subAcctDescription");
            return (Criteria) this;
        }

        public Criteria andSubAcctDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("sub_acct_description >=", value, "subAcctDescription");
            return (Criteria) this;
        }

        public Criteria andSubAcctDescriptionLessThan(String value) {
            addCriterion("sub_acct_description <", value, "subAcctDescription");
            return (Criteria) this;
        }

        public Criteria andSubAcctDescriptionLessThanOrEqualTo(String value) {
            addCriterion("sub_acct_description <=", value, "subAcctDescription");
            return (Criteria) this;
        }

        public Criteria andSubAcctDescriptionLike(String value) {
            addCriterion("sub_acct_description like", value, "subAcctDescription");
            return (Criteria) this;
        }

        public Criteria andSubAcctDescriptionNotLike(String value) {
            addCriterion("sub_acct_description not like", value, "subAcctDescription");
            return (Criteria) this;
        }

        public Criteria andSubAcctDescriptionIn(List<String> values) {
            addCriterion("sub_acct_description in", values, "subAcctDescription");
            return (Criteria) this;
        }

        public Criteria andSubAcctDescriptionNotIn(List<String> values) {
            addCriterion("sub_acct_description not in", values, "subAcctDescription");
            return (Criteria) this;
        }

        public Criteria andSubAcctDescriptionBetween(String value1, String value2) {
            addCriterion("sub_acct_description between", value1, value2, "subAcctDescription");
            return (Criteria) this;
        }

        public Criteria andSubAcctDescriptionNotBetween(String value1, String value2) {
            addCriterion("sub_acct_description not between", value1, value2, "subAcctDescription");
            return (Criteria) this;
        }

        public Criteria andSubAcctSubjectIsNull() {
            addCriterion("sub_acct_subject is null");
            return (Criteria) this;
        }

        public Criteria andSubAcctSubjectIsNotNull() {
            addCriterion("sub_acct_subject is not null");
            return (Criteria) this;
        }

        public Criteria andSubAcctSubjectEqualTo(String value) {
            addCriterion("sub_acct_subject =", value, "subAcctSubject");
            return (Criteria) this;
        }

        public Criteria andSubAcctSubjectNotEqualTo(String value) {
            addCriterion("sub_acct_subject <>", value, "subAcctSubject");
            return (Criteria) this;
        }

        public Criteria andSubAcctSubjectGreaterThan(String value) {
            addCriterion("sub_acct_subject >", value, "subAcctSubject");
            return (Criteria) this;
        }

        public Criteria andSubAcctSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("sub_acct_subject >=", value, "subAcctSubject");
            return (Criteria) this;
        }

        public Criteria andSubAcctSubjectLessThan(String value) {
            addCriterion("sub_acct_subject <", value, "subAcctSubject");
            return (Criteria) this;
        }

        public Criteria andSubAcctSubjectLessThanOrEqualTo(String value) {
            addCriterion("sub_acct_subject <=", value, "subAcctSubject");
            return (Criteria) this;
        }

        public Criteria andSubAcctSubjectLike(String value) {
            addCriterion("sub_acct_subject like", value, "subAcctSubject");
            return (Criteria) this;
        }

        public Criteria andSubAcctSubjectNotLike(String value) {
            addCriterion("sub_acct_subject not like", value, "subAcctSubject");
            return (Criteria) this;
        }

        public Criteria andSubAcctSubjectIn(List<String> values) {
            addCriterion("sub_acct_subject in", values, "subAcctSubject");
            return (Criteria) this;
        }

        public Criteria andSubAcctSubjectNotIn(List<String> values) {
            addCriterion("sub_acct_subject not in", values, "subAcctSubject");
            return (Criteria) this;
        }

        public Criteria andSubAcctSubjectBetween(String value1, String value2) {
            addCriterion("sub_acct_subject between", value1, value2, "subAcctSubject");
            return (Criteria) this;
        }

        public Criteria andSubAcctSubjectNotBetween(String value1, String value2) {
            addCriterion("sub_acct_subject not between", value1, value2, "subAcctSubject");
            return (Criteria) this;
        }

        public Criteria andSubAcctCurrencyIsNull() {
            addCriterion("sub_acct_currency is null");
            return (Criteria) this;
        }

        public Criteria andSubAcctCurrencyIsNotNull() {
            addCriterion("sub_acct_currency is not null");
            return (Criteria) this;
        }

        public Criteria andSubAcctCurrencyEqualTo(String value) {
            addCriterion("sub_acct_currency =", value, "subAcctCurrency");
            return (Criteria) this;
        }

        public Criteria andSubAcctCurrencyNotEqualTo(String value) {
            addCriterion("sub_acct_currency <>", value, "subAcctCurrency");
            return (Criteria) this;
        }

        public Criteria andSubAcctCurrencyGreaterThan(String value) {
            addCriterion("sub_acct_currency >", value, "subAcctCurrency");
            return (Criteria) this;
        }

        public Criteria andSubAcctCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("sub_acct_currency >=", value, "subAcctCurrency");
            return (Criteria) this;
        }

        public Criteria andSubAcctCurrencyLessThan(String value) {
            addCriterion("sub_acct_currency <", value, "subAcctCurrency");
            return (Criteria) this;
        }

        public Criteria andSubAcctCurrencyLessThanOrEqualTo(String value) {
            addCriterion("sub_acct_currency <=", value, "subAcctCurrency");
            return (Criteria) this;
        }

        public Criteria andSubAcctCurrencyLike(String value) {
            addCriterion("sub_acct_currency like", value, "subAcctCurrency");
            return (Criteria) this;
        }

        public Criteria andSubAcctCurrencyNotLike(String value) {
            addCriterion("sub_acct_currency not like", value, "subAcctCurrency");
            return (Criteria) this;
        }

        public Criteria andSubAcctCurrencyIn(List<String> values) {
            addCriterion("sub_acct_currency in", values, "subAcctCurrency");
            return (Criteria) this;
        }

        public Criteria andSubAcctCurrencyNotIn(List<String> values) {
            addCriterion("sub_acct_currency not in", values, "subAcctCurrency");
            return (Criteria) this;
        }

        public Criteria andSubAcctCurrencyBetween(String value1, String value2) {
            addCriterion("sub_acct_currency between", value1, value2, "subAcctCurrency");
            return (Criteria) this;
        }

        public Criteria andSubAcctCurrencyNotBetween(String value1, String value2) {
            addCriterion("sub_acct_currency not between", value1, value2, "subAcctCurrency");
            return (Criteria) this;
        }

        public Criteria andSubAcctBalancebyIsNull() {
            addCriterion("sub_acct_balanceby is null");
            return (Criteria) this;
        }

        public Criteria andSubAcctBalancebyIsNotNull() {
            addCriterion("sub_acct_balanceby is not null");
            return (Criteria) this;
        }

        public Criteria andSubAcctBalancebyEqualTo(String value) {
            addCriterion("sub_acct_balanceby =", value, "subAcctBalanceby");
            return (Criteria) this;
        }

        public Criteria andSubAcctBalancebyNotEqualTo(String value) {
            addCriterion("sub_acct_balanceby <>", value, "subAcctBalanceby");
            return (Criteria) this;
        }

        public Criteria andSubAcctBalancebyGreaterThan(String value) {
            addCriterion("sub_acct_balanceby >", value, "subAcctBalanceby");
            return (Criteria) this;
        }

        public Criteria andSubAcctBalancebyGreaterThanOrEqualTo(String value) {
            addCriterion("sub_acct_balanceby >=", value, "subAcctBalanceby");
            return (Criteria) this;
        }

        public Criteria andSubAcctBalancebyLessThan(String value) {
            addCriterion("sub_acct_balanceby <", value, "subAcctBalanceby");
            return (Criteria) this;
        }

        public Criteria andSubAcctBalancebyLessThanOrEqualTo(String value) {
            addCriterion("sub_acct_balanceby <=", value, "subAcctBalanceby");
            return (Criteria) this;
        }

        public Criteria andSubAcctBalancebyLike(String value) {
            addCriterion("sub_acct_balanceby like", value, "subAcctBalanceby");
            return (Criteria) this;
        }

        public Criteria andSubAcctBalancebyNotLike(String value) {
            addCriterion("sub_acct_balanceby not like", value, "subAcctBalanceby");
            return (Criteria) this;
        }

        public Criteria andSubAcctBalancebyIn(List<String> values) {
            addCriterion("sub_acct_balanceby in", values, "subAcctBalanceby");
            return (Criteria) this;
        }

        public Criteria andSubAcctBalancebyNotIn(List<String> values) {
            addCriterion("sub_acct_balanceby not in", values, "subAcctBalanceby");
            return (Criteria) this;
        }

        public Criteria andSubAcctBalancebyBetween(String value1, String value2) {
            addCriterion("sub_acct_balanceby between", value1, value2, "subAcctBalanceby");
            return (Criteria) this;
        }

        public Criteria andSubAcctBalancebyNotBetween(String value1, String value2) {
            addCriterion("sub_acct_balanceby not between", value1, value2, "subAcctBalanceby");
            return (Criteria) this;
        }

        public Criteria andSubAcctInterestIsNull() {
            addCriterion("sub_acct_interest is null");
            return (Criteria) this;
        }

        public Criteria andSubAcctInterestIsNotNull() {
            addCriterion("sub_acct_interest is not null");
            return (Criteria) this;
        }

        public Criteria andSubAcctInterestEqualTo(String value) {
            addCriterion("sub_acct_interest =", value, "subAcctInterest");
            return (Criteria) this;
        }

        public Criteria andSubAcctInterestNotEqualTo(String value) {
            addCriterion("sub_acct_interest <>", value, "subAcctInterest");
            return (Criteria) this;
        }

        public Criteria andSubAcctInterestGreaterThan(String value) {
            addCriterion("sub_acct_interest >", value, "subAcctInterest");
            return (Criteria) this;
        }

        public Criteria andSubAcctInterestGreaterThanOrEqualTo(String value) {
            addCriterion("sub_acct_interest >=", value, "subAcctInterest");
            return (Criteria) this;
        }

        public Criteria andSubAcctInterestLessThan(String value) {
            addCriterion("sub_acct_interest <", value, "subAcctInterest");
            return (Criteria) this;
        }

        public Criteria andSubAcctInterestLessThanOrEqualTo(String value) {
            addCriterion("sub_acct_interest <=", value, "subAcctInterest");
            return (Criteria) this;
        }

        public Criteria andSubAcctInterestLike(String value) {
            addCriterion("sub_acct_interest like", value, "subAcctInterest");
            return (Criteria) this;
        }

        public Criteria andSubAcctInterestNotLike(String value) {
            addCriterion("sub_acct_interest not like", value, "subAcctInterest");
            return (Criteria) this;
        }

        public Criteria andSubAcctInterestIn(List<String> values) {
            addCriterion("sub_acct_interest in", values, "subAcctInterest");
            return (Criteria) this;
        }

        public Criteria andSubAcctInterestNotIn(List<String> values) {
            addCriterion("sub_acct_interest not in", values, "subAcctInterest");
            return (Criteria) this;
        }

        public Criteria andSubAcctInterestBetween(String value1, String value2) {
            addCriterion("sub_acct_interest between", value1, value2, "subAcctInterest");
            return (Criteria) this;
        }

        public Criteria andSubAcctInterestNotBetween(String value1, String value2) {
            addCriterion("sub_acct_interest not between", value1, value2, "subAcctInterest");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowDepositIsNull() {
            addCriterion("sub_acct_allow_deposit is null");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowDepositIsNotNull() {
            addCriterion("sub_acct_allow_deposit is not null");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowDepositEqualTo(String value) {
            addCriterion("sub_acct_allow_deposit =", value, "subAcctAllowDeposit");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowDepositNotEqualTo(String value) {
            addCriterion("sub_acct_allow_deposit <>", value, "subAcctAllowDeposit");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowDepositGreaterThan(String value) {
            addCriterion("sub_acct_allow_deposit >", value, "subAcctAllowDeposit");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowDepositGreaterThanOrEqualTo(String value) {
            addCriterion("sub_acct_allow_deposit >=", value, "subAcctAllowDeposit");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowDepositLessThan(String value) {
            addCriterion("sub_acct_allow_deposit <", value, "subAcctAllowDeposit");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowDepositLessThanOrEqualTo(String value) {
            addCriterion("sub_acct_allow_deposit <=", value, "subAcctAllowDeposit");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowDepositLike(String value) {
            addCriterion("sub_acct_allow_deposit like", value, "subAcctAllowDeposit");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowDepositNotLike(String value) {
            addCriterion("sub_acct_allow_deposit not like", value, "subAcctAllowDeposit");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowDepositIn(List<String> values) {
            addCriterion("sub_acct_allow_deposit in", values, "subAcctAllowDeposit");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowDepositNotIn(List<String> values) {
            addCriterion("sub_acct_allow_deposit not in", values, "subAcctAllowDeposit");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowDepositBetween(String value1, String value2) {
            addCriterion("sub_acct_allow_deposit between", value1, value2, "subAcctAllowDeposit");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowDepositNotBetween(String value1, String value2) {
            addCriterion("sub_acct_allow_deposit not between", value1, value2, "subAcctAllowDeposit");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowWithdrawIsNull() {
            addCriterion("sub_acct_allow_withdraw is null");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowWithdrawIsNotNull() {
            addCriterion("sub_acct_allow_withdraw is not null");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowWithdrawEqualTo(String value) {
            addCriterion("sub_acct_allow_withdraw =", value, "subAcctAllowWithdraw");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowWithdrawNotEqualTo(String value) {
            addCriterion("sub_acct_allow_withdraw <>", value, "subAcctAllowWithdraw");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowWithdrawGreaterThan(String value) {
            addCriterion("sub_acct_allow_withdraw >", value, "subAcctAllowWithdraw");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowWithdrawGreaterThanOrEqualTo(String value) {
            addCriterion("sub_acct_allow_withdraw >=", value, "subAcctAllowWithdraw");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowWithdrawLessThan(String value) {
            addCriterion("sub_acct_allow_withdraw <", value, "subAcctAllowWithdraw");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowWithdrawLessThanOrEqualTo(String value) {
            addCriterion("sub_acct_allow_withdraw <=", value, "subAcctAllowWithdraw");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowWithdrawLike(String value) {
            addCriterion("sub_acct_allow_withdraw like", value, "subAcctAllowWithdraw");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowWithdrawNotLike(String value) {
            addCriterion("sub_acct_allow_withdraw not like", value, "subAcctAllowWithdraw");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowWithdrawIn(List<String> values) {
            addCriterion("sub_acct_allow_withdraw in", values, "subAcctAllowWithdraw");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowWithdrawNotIn(List<String> values) {
            addCriterion("sub_acct_allow_withdraw not in", values, "subAcctAllowWithdraw");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowWithdrawBetween(String value1, String value2) {
            addCriterion("sub_acct_allow_withdraw between", value1, value2, "subAcctAllowWithdraw");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowWithdrawNotBetween(String value1, String value2) {
            addCriterion("sub_acct_allow_withdraw not between", value1, value2, "subAcctAllowWithdraw");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowOverdraftIsNull() {
            addCriterion("sub_acct_allow_overdraft is null");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowOverdraftIsNotNull() {
            addCriterion("sub_acct_allow_overdraft is not null");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowOverdraftEqualTo(String value) {
            addCriterion("sub_acct_allow_overdraft =", value, "subAcctAllowOverdraft");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowOverdraftNotEqualTo(String value) {
            addCriterion("sub_acct_allow_overdraft <>", value, "subAcctAllowOverdraft");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowOverdraftGreaterThan(String value) {
            addCriterion("sub_acct_allow_overdraft >", value, "subAcctAllowOverdraft");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowOverdraftGreaterThanOrEqualTo(String value) {
            addCriterion("sub_acct_allow_overdraft >=", value, "subAcctAllowOverdraft");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowOverdraftLessThan(String value) {
            addCriterion("sub_acct_allow_overdraft <", value, "subAcctAllowOverdraft");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowOverdraftLessThanOrEqualTo(String value) {
            addCriterion("sub_acct_allow_overdraft <=", value, "subAcctAllowOverdraft");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowOverdraftLike(String value) {
            addCriterion("sub_acct_allow_overdraft like", value, "subAcctAllowOverdraft");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowOverdraftNotLike(String value) {
            addCriterion("sub_acct_allow_overdraft not like", value, "subAcctAllowOverdraft");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowOverdraftIn(List<String> values) {
            addCriterion("sub_acct_allow_overdraft in", values, "subAcctAllowOverdraft");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowOverdraftNotIn(List<String> values) {
            addCriterion("sub_acct_allow_overdraft not in", values, "subAcctAllowOverdraft");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowOverdraftBetween(String value1, String value2) {
            addCriterion("sub_acct_allow_overdraft between", value1, value2, "subAcctAllowOverdraft");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowOverdraftNotBetween(String value1, String value2) {
            addCriterion("sub_acct_allow_overdraft not between", value1, value2, "subAcctAllowOverdraft");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowPayIsNull() {
            addCriterion("sub_acct_allow_pay is null");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowPayIsNotNull() {
            addCriterion("sub_acct_allow_pay is not null");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowPayEqualTo(String value) {
            addCriterion("sub_acct_allow_pay =", value, "subAcctAllowPay");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowPayNotEqualTo(String value) {
            addCriterion("sub_acct_allow_pay <>", value, "subAcctAllowPay");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowPayGreaterThan(String value) {
            addCriterion("sub_acct_allow_pay >", value, "subAcctAllowPay");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowPayGreaterThanOrEqualTo(String value) {
            addCriterion("sub_acct_allow_pay >=", value, "subAcctAllowPay");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowPayLessThan(String value) {
            addCriterion("sub_acct_allow_pay <", value, "subAcctAllowPay");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowPayLessThanOrEqualTo(String value) {
            addCriterion("sub_acct_allow_pay <=", value, "subAcctAllowPay");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowPayLike(String value) {
            addCriterion("sub_acct_allow_pay like", value, "subAcctAllowPay");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowPayNotLike(String value) {
            addCriterion("sub_acct_allow_pay not like", value, "subAcctAllowPay");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowPayIn(List<String> values) {
            addCriterion("sub_acct_allow_pay in", values, "subAcctAllowPay");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowPayNotIn(List<String> values) {
            addCriterion("sub_acct_allow_pay not in", values, "subAcctAllowPay");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowPayBetween(String value1, String value2) {
            addCriterion("sub_acct_allow_pay between", value1, value2, "subAcctAllowPay");
            return (Criteria) this;
        }

        public Criteria andSubAcctAllowPayNotBetween(String value1, String value2) {
            addCriterion("sub_acct_allow_pay not between", value1, value2, "subAcctAllowPay");
            return (Criteria) this;
        }

        public Criteria andSubAcctLevelIsNull() {
            addCriterion("sub_acct_level is null");
            return (Criteria) this;
        }

        public Criteria andSubAcctLevelIsNotNull() {
            addCriterion("sub_acct_level is not null");
            return (Criteria) this;
        }

        public Criteria andSubAcctLevelEqualTo(String value) {
            addCriterion("sub_acct_level =", value, "subAcctLevel");
            return (Criteria) this;
        }

        public Criteria andSubAcctLevelNotEqualTo(String value) {
            addCriterion("sub_acct_level <>", value, "subAcctLevel");
            return (Criteria) this;
        }

        public Criteria andSubAcctLevelGreaterThan(String value) {
            addCriterion("sub_acct_level >", value, "subAcctLevel");
            return (Criteria) this;
        }

        public Criteria andSubAcctLevelGreaterThanOrEqualTo(String value) {
            addCriterion("sub_acct_level >=", value, "subAcctLevel");
            return (Criteria) this;
        }

        public Criteria andSubAcctLevelLessThan(String value) {
            addCriterion("sub_acct_level <", value, "subAcctLevel");
            return (Criteria) this;
        }

        public Criteria andSubAcctLevelLessThanOrEqualTo(String value) {
            addCriterion("sub_acct_level <=", value, "subAcctLevel");
            return (Criteria) this;
        }

        public Criteria andSubAcctLevelLike(String value) {
            addCriterion("sub_acct_level like", value, "subAcctLevel");
            return (Criteria) this;
        }

        public Criteria andSubAcctLevelNotLike(String value) {
            addCriterion("sub_acct_level not like", value, "subAcctLevel");
            return (Criteria) this;
        }

        public Criteria andSubAcctLevelIn(List<String> values) {
            addCriterion("sub_acct_level in", values, "subAcctLevel");
            return (Criteria) this;
        }

        public Criteria andSubAcctLevelNotIn(List<String> values) {
            addCriterion("sub_acct_level not in", values, "subAcctLevel");
            return (Criteria) this;
        }

        public Criteria andSubAcctLevelBetween(String value1, String value2) {
            addCriterion("sub_acct_level between", value1, value2, "subAcctLevel");
            return (Criteria) this;
        }

        public Criteria andSubAcctLevelNotBetween(String value1, String value2) {
            addCriterion("sub_acct_level not between", value1, value2, "subAcctLevel");
            return (Criteria) this;
        }

        public Criteria andSubAcctVisibleIsNull() {
            addCriterion("sub_acct_visible is null");
            return (Criteria) this;
        }

        public Criteria andSubAcctVisibleIsNotNull() {
            addCriterion("sub_acct_visible is not null");
            return (Criteria) this;
        }

        public Criteria andSubAcctVisibleEqualTo(String value) {
            addCriterion("sub_acct_visible =", value, "subAcctVisible");
            return (Criteria) this;
        }

        public Criteria andSubAcctVisibleNotEqualTo(String value) {
            addCriterion("sub_acct_visible <>", value, "subAcctVisible");
            return (Criteria) this;
        }

        public Criteria andSubAcctVisibleGreaterThan(String value) {
            addCriterion("sub_acct_visible >", value, "subAcctVisible");
            return (Criteria) this;
        }

        public Criteria andSubAcctVisibleGreaterThanOrEqualTo(String value) {
            addCriterion("sub_acct_visible >=", value, "subAcctVisible");
            return (Criteria) this;
        }

        public Criteria andSubAcctVisibleLessThan(String value) {
            addCriterion("sub_acct_visible <", value, "subAcctVisible");
            return (Criteria) this;
        }

        public Criteria andSubAcctVisibleLessThanOrEqualTo(String value) {
            addCriterion("sub_acct_visible <=", value, "subAcctVisible");
            return (Criteria) this;
        }

        public Criteria andSubAcctVisibleLike(String value) {
            addCriterion("sub_acct_visible like", value, "subAcctVisible");
            return (Criteria) this;
        }

        public Criteria andSubAcctVisibleNotLike(String value) {
            addCriterion("sub_acct_visible not like", value, "subAcctVisible");
            return (Criteria) this;
        }

        public Criteria andSubAcctVisibleIn(List<String> values) {
            addCriterion("sub_acct_visible in", values, "subAcctVisible");
            return (Criteria) this;
        }

        public Criteria andSubAcctVisibleNotIn(List<String> values) {
            addCriterion("sub_acct_visible not in", values, "subAcctVisible");
            return (Criteria) this;
        }

        public Criteria andSubAcctVisibleBetween(String value1, String value2) {
            addCriterion("sub_acct_visible between", value1, value2, "subAcctVisible");
            return (Criteria) this;
        }

        public Criteria andSubAcctVisibleNotBetween(String value1, String value2) {
            addCriterion("sub_acct_visible not between", value1, value2, "subAcctVisible");
            return (Criteria) this;
        }

        public Criteria andSubAcctFrozenIsNull() {
            addCriterion("sub_acct_frozen is null");
            return (Criteria) this;
        }

        public Criteria andSubAcctFrozenIsNotNull() {
            addCriterion("sub_acct_frozen is not null");
            return (Criteria) this;
        }

        public Criteria andSubAcctFrozenEqualTo(String value) {
            addCriterion("sub_acct_frozen =", value, "subAcctFrozen");
            return (Criteria) this;
        }

        public Criteria andSubAcctFrozenNotEqualTo(String value) {
            addCriterion("sub_acct_frozen <>", value, "subAcctFrozen");
            return (Criteria) this;
        }

        public Criteria andSubAcctFrozenGreaterThan(String value) {
            addCriterion("sub_acct_frozen >", value, "subAcctFrozen");
            return (Criteria) this;
        }

        public Criteria andSubAcctFrozenGreaterThanOrEqualTo(String value) {
            addCriterion("sub_acct_frozen >=", value, "subAcctFrozen");
            return (Criteria) this;
        }

        public Criteria andSubAcctFrozenLessThan(String value) {
            addCriterion("sub_acct_frozen <", value, "subAcctFrozen");
            return (Criteria) this;
        }

        public Criteria andSubAcctFrozenLessThanOrEqualTo(String value) {
            addCriterion("sub_acct_frozen <=", value, "subAcctFrozen");
            return (Criteria) this;
        }

        public Criteria andSubAcctFrozenLike(String value) {
            addCriterion("sub_acct_frozen like", value, "subAcctFrozen");
            return (Criteria) this;
        }

        public Criteria andSubAcctFrozenNotLike(String value) {
            addCriterion("sub_acct_frozen not like", value, "subAcctFrozen");
            return (Criteria) this;
        }

        public Criteria andSubAcctFrozenIn(List<String> values) {
            addCriterion("sub_acct_frozen in", values, "subAcctFrozen");
            return (Criteria) this;
        }

        public Criteria andSubAcctFrozenNotIn(List<String> values) {
            addCriterion("sub_acct_frozen not in", values, "subAcctFrozen");
            return (Criteria) this;
        }

        public Criteria andSubAcctFrozenBetween(String value1, String value2) {
            addCriterion("sub_acct_frozen between", value1, value2, "subAcctFrozen");
            return (Criteria) this;
        }

        public Criteria andSubAcctFrozenNotBetween(String value1, String value2) {
            addCriterion("sub_acct_frozen not between", value1, value2, "subAcctFrozen");
            return (Criteria) this;
        }

        public Criteria andSubAcctForbidInIsNull() {
            addCriterion("sub_acct_forbid_in is null");
            return (Criteria) this;
        }

        public Criteria andSubAcctForbidInIsNotNull() {
            addCriterion("sub_acct_forbid_in is not null");
            return (Criteria) this;
        }

        public Criteria andSubAcctForbidInEqualTo(String value) {
            addCriterion("sub_acct_forbid_in =", value, "subAcctForbidIn");
            return (Criteria) this;
        }

        public Criteria andSubAcctForbidInNotEqualTo(String value) {
            addCriterion("sub_acct_forbid_in <>", value, "subAcctForbidIn");
            return (Criteria) this;
        }

        public Criteria andSubAcctForbidInGreaterThan(String value) {
            addCriterion("sub_acct_forbid_in >", value, "subAcctForbidIn");
            return (Criteria) this;
        }

        public Criteria andSubAcctForbidInGreaterThanOrEqualTo(String value) {
            addCriterion("sub_acct_forbid_in >=", value, "subAcctForbidIn");
            return (Criteria) this;
        }

        public Criteria andSubAcctForbidInLessThan(String value) {
            addCriterion("sub_acct_forbid_in <", value, "subAcctForbidIn");
            return (Criteria) this;
        }

        public Criteria andSubAcctForbidInLessThanOrEqualTo(String value) {
            addCriterion("sub_acct_forbid_in <=", value, "subAcctForbidIn");
            return (Criteria) this;
        }

        public Criteria andSubAcctForbidInLike(String value) {
            addCriterion("sub_acct_forbid_in like", value, "subAcctForbidIn");
            return (Criteria) this;
        }

        public Criteria andSubAcctForbidInNotLike(String value) {
            addCriterion("sub_acct_forbid_in not like", value, "subAcctForbidIn");
            return (Criteria) this;
        }

        public Criteria andSubAcctForbidInIn(List<String> values) {
            addCriterion("sub_acct_forbid_in in", values, "subAcctForbidIn");
            return (Criteria) this;
        }

        public Criteria andSubAcctForbidInNotIn(List<String> values) {
            addCriterion("sub_acct_forbid_in not in", values, "subAcctForbidIn");
            return (Criteria) this;
        }

        public Criteria andSubAcctForbidInBetween(String value1, String value2) {
            addCriterion("sub_acct_forbid_in between", value1, value2, "subAcctForbidIn");
            return (Criteria) this;
        }

        public Criteria andSubAcctForbidInNotBetween(String value1, String value2) {
            addCriterion("sub_acct_forbid_in not between", value1, value2, "subAcctForbidIn");
            return (Criteria) this;
        }

        public Criteria andSubAcctForbidOutIsNull() {
            addCriterion("sub_acct_forbid_out is null");
            return (Criteria) this;
        }

        public Criteria andSubAcctForbidOutIsNotNull() {
            addCriterion("sub_acct_forbid_out is not null");
            return (Criteria) this;
        }

        public Criteria andSubAcctForbidOutEqualTo(String value) {
            addCriterion("sub_acct_forbid_out =", value, "subAcctForbidOut");
            return (Criteria) this;
        }

        public Criteria andSubAcctForbidOutNotEqualTo(String value) {
            addCriterion("sub_acct_forbid_out <>", value, "subAcctForbidOut");
            return (Criteria) this;
        }

        public Criteria andSubAcctForbidOutGreaterThan(String value) {
            addCriterion("sub_acct_forbid_out >", value, "subAcctForbidOut");
            return (Criteria) this;
        }

        public Criteria andSubAcctForbidOutGreaterThanOrEqualTo(String value) {
            addCriterion("sub_acct_forbid_out >=", value, "subAcctForbidOut");
            return (Criteria) this;
        }

        public Criteria andSubAcctForbidOutLessThan(String value) {
            addCriterion("sub_acct_forbid_out <", value, "subAcctForbidOut");
            return (Criteria) this;
        }

        public Criteria andSubAcctForbidOutLessThanOrEqualTo(String value) {
            addCriterion("sub_acct_forbid_out <=", value, "subAcctForbidOut");
            return (Criteria) this;
        }

        public Criteria andSubAcctForbidOutLike(String value) {
            addCriterion("sub_acct_forbid_out like", value, "subAcctForbidOut");
            return (Criteria) this;
        }

        public Criteria andSubAcctForbidOutNotLike(String value) {
            addCriterion("sub_acct_forbid_out not like", value, "subAcctForbidOut");
            return (Criteria) this;
        }

        public Criteria andSubAcctForbidOutIn(List<String> values) {
            addCriterion("sub_acct_forbid_out in", values, "subAcctForbidOut");
            return (Criteria) this;
        }

        public Criteria andSubAcctForbidOutNotIn(List<String> values) {
            addCriterion("sub_acct_forbid_out not in", values, "subAcctForbidOut");
            return (Criteria) this;
        }

        public Criteria andSubAcctForbidOutBetween(String value1, String value2) {
            addCriterion("sub_acct_forbid_out between", value1, value2, "subAcctForbidOut");
            return (Criteria) this;
        }

        public Criteria andSubAcctForbidOutNotBetween(String value1, String value2) {
            addCriterion("sub_acct_forbid_out not between", value1, value2, "subAcctForbidOut");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorIsNull() {
            addCriterion("create_operator is null");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorIsNotNull() {
            addCriterion("create_operator is not null");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorEqualTo(String value) {
            addCriterion("create_operator =", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorNotEqualTo(String value) {
            addCriterion("create_operator <>", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorGreaterThan(String value) {
            addCriterion("create_operator >", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("create_operator >=", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorLessThan(String value) {
            addCriterion("create_operator <", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorLessThanOrEqualTo(String value) {
            addCriterion("create_operator <=", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorLike(String value) {
            addCriterion("create_operator like", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorNotLike(String value) {
            addCriterion("create_operator not like", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorIn(List<String> values) {
            addCriterion("create_operator in", values, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorNotIn(List<String> values) {
            addCriterion("create_operator not in", values, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorBetween(String value1, String value2) {
            addCriterion("create_operator between", value1, value2, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorNotBetween(String value1, String value2) {
            addCriterion("create_operator not between", value1, value2, "createOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorIsNull() {
            addCriterion("update_operator is null");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorIsNotNull() {
            addCriterion("update_operator is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorEqualTo(String value) {
            addCriterion("update_operator =", value, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorNotEqualTo(String value) {
            addCriterion("update_operator <>", value, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorGreaterThan(String value) {
            addCriterion("update_operator >", value, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("update_operator >=", value, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorLessThan(String value) {
            addCriterion("update_operator <", value, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorLessThanOrEqualTo(String value) {
            addCriterion("update_operator <=", value, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorLike(String value) {
            addCriterion("update_operator like", value, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorNotLike(String value) {
            addCriterion("update_operator not like", value, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorIn(List<String> values) {
            addCriterion("update_operator in", values, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorNotIn(List<String> values) {
            addCriterion("update_operator not in", values, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorBetween(String value1, String value2) {
            addCriterion("update_operator between", value1, value2, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorNotBetween(String value1, String value2) {
            addCriterion("update_operator not between", value1, value2, "updateOperator");
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