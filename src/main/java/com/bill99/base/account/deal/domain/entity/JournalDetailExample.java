package com.bill99.base.account.deal.domain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JournalDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JournalDetailExample() {
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

        public Criteria andSubIdIsNull() {
            addCriterion("sub_id is null");
            return (Criteria) this;
        }

        public Criteria andSubIdIsNotNull() {
            addCriterion("sub_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubIdEqualTo(Long value) {
            addCriterion("sub_id =", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdNotEqualTo(Long value) {
            addCriterion("sub_id <>", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdGreaterThan(Long value) {
            addCriterion("sub_id >", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sub_id >=", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdLessThan(Long value) {
            addCriterion("sub_id <", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdLessThanOrEqualTo(Long value) {
            addCriterion("sub_id <=", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdIn(List<Long> values) {
            addCriterion("sub_id in", values, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdNotIn(List<Long> values) {
            addCriterion("sub_id not in", values, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdBetween(Long value1, Long value2) {
            addCriterion("sub_id between", value1, value2, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdNotBetween(Long value1, Long value2) {
            addCriterion("sub_id not between", value1, value2, "subId");
            return (Criteria) this;
        }

        public Criteria andJournalIdIsNull() {
            addCriterion("journal_id is null");
            return (Criteria) this;
        }

        public Criteria andJournalIdIsNotNull() {
            addCriterion("journal_id is not null");
            return (Criteria) this;
        }

        public Criteria andJournalIdEqualTo(String value) {
            addCriterion("journal_id =", value, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdNotEqualTo(String value) {
            addCriterion("journal_id <>", value, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdGreaterThan(String value) {
            addCriterion("journal_id >", value, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdGreaterThanOrEqualTo(String value) {
            addCriterion("journal_id >=", value, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdLessThan(String value) {
            addCriterion("journal_id <", value, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdLessThanOrEqualTo(String value) {
            addCriterion("journal_id <=", value, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdLike(String value) {
            addCriterion("journal_id like", value, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdNotLike(String value) {
            addCriterion("journal_id not like", value, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdIn(List<String> values) {
            addCriterion("journal_id in", values, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdNotIn(List<String> values) {
            addCriterion("journal_id not in", values, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdBetween(String value1, String value2) {
            addCriterion("journal_id between", value1, value2, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdNotBetween(String value1, String value2) {
            addCriterion("journal_id not between", value1, value2, "journalId");
            return (Criteria) this;
        }

        public Criteria andOrigJournalIdIsNull() {
            addCriterion("orig_journal_id is null");
            return (Criteria) this;
        }

        public Criteria andOrigJournalIdIsNotNull() {
            addCriterion("orig_journal_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrigJournalIdEqualTo(String value) {
            addCriterion("orig_journal_id =", value, "origJournalId");
            return (Criteria) this;
        }

        public Criteria andOrigJournalIdNotEqualTo(String value) {
            addCriterion("orig_journal_id <>", value, "origJournalId");
            return (Criteria) this;
        }

        public Criteria andOrigJournalIdGreaterThan(String value) {
            addCriterion("orig_journal_id >", value, "origJournalId");
            return (Criteria) this;
        }

        public Criteria andOrigJournalIdGreaterThanOrEqualTo(String value) {
            addCriterion("orig_journal_id >=", value, "origJournalId");
            return (Criteria) this;
        }

        public Criteria andOrigJournalIdLessThan(String value) {
            addCriterion("orig_journal_id <", value, "origJournalId");
            return (Criteria) this;
        }

        public Criteria andOrigJournalIdLessThanOrEqualTo(String value) {
            addCriterion("orig_journal_id <=", value, "origJournalId");
            return (Criteria) this;
        }

        public Criteria andOrigJournalIdLike(String value) {
            addCriterion("orig_journal_id like", value, "origJournalId");
            return (Criteria) this;
        }

        public Criteria andOrigJournalIdNotLike(String value) {
            addCriterion("orig_journal_id not like", value, "origJournalId");
            return (Criteria) this;
        }

        public Criteria andOrigJournalIdIn(List<String> values) {
            addCriterion("orig_journal_id in", values, "origJournalId");
            return (Criteria) this;
        }

        public Criteria andOrigJournalIdNotIn(List<String> values) {
            addCriterion("orig_journal_id not in", values, "origJournalId");
            return (Criteria) this;
        }

        public Criteria andOrigJournalIdBetween(String value1, String value2) {
            addCriterion("orig_journal_id between", value1, value2, "origJournalId");
            return (Criteria) this;
        }

        public Criteria andOrigJournalIdNotBetween(String value1, String value2) {
            addCriterion("orig_journal_id not between", value1, value2, "origJournalId");
            return (Criteria) this;
        }

        public Criteria andPostingRuleIsNull() {
            addCriterion("posting_rule is null");
            return (Criteria) this;
        }

        public Criteria andPostingRuleIsNotNull() {
            addCriterion("posting_rule is not null");
            return (Criteria) this;
        }

        public Criteria andPostingRuleEqualTo(String value) {
            addCriterion("posting_rule =", value, "postingRule");
            return (Criteria) this;
        }

        public Criteria andPostingRuleNotEqualTo(String value) {
            addCriterion("posting_rule <>", value, "postingRule");
            return (Criteria) this;
        }

        public Criteria andPostingRuleGreaterThan(String value) {
            addCriterion("posting_rule >", value, "postingRule");
            return (Criteria) this;
        }

        public Criteria andPostingRuleGreaterThanOrEqualTo(String value) {
            addCriterion("posting_rule >=", value, "postingRule");
            return (Criteria) this;
        }

        public Criteria andPostingRuleLessThan(String value) {
            addCriterion("posting_rule <", value, "postingRule");
            return (Criteria) this;
        }

        public Criteria andPostingRuleLessThanOrEqualTo(String value) {
            addCriterion("posting_rule <=", value, "postingRule");
            return (Criteria) this;
        }

        public Criteria andPostingRuleLike(String value) {
            addCriterion("posting_rule like", value, "postingRule");
            return (Criteria) this;
        }

        public Criteria andPostingRuleNotLike(String value) {
            addCriterion("posting_rule not like", value, "postingRule");
            return (Criteria) this;
        }

        public Criteria andPostingRuleIn(List<String> values) {
            addCriterion("posting_rule in", values, "postingRule");
            return (Criteria) this;
        }

        public Criteria andPostingRuleNotIn(List<String> values) {
            addCriterion("posting_rule not in", values, "postingRule");
            return (Criteria) this;
        }

        public Criteria andPostingRuleBetween(String value1, String value2) {
            addCriterion("posting_rule between", value1, value2, "postingRule");
            return (Criteria) this;
        }

        public Criteria andPostingRuleNotBetween(String value1, String value2) {
            addCriterion("posting_rule not between", value1, value2, "postingRule");
            return (Criteria) this;
        }

        public Criteria andPostingRuleTypeIsNull() {
            addCriterion("posting_rule_type is null");
            return (Criteria) this;
        }

        public Criteria andPostingRuleTypeIsNotNull() {
            addCriterion("posting_rule_type is not null");
            return (Criteria) this;
        }

        public Criteria andPostingRuleTypeEqualTo(String value) {
            addCriterion("posting_rule_type =", value, "postingRuleType");
            return (Criteria) this;
        }

        public Criteria andPostingRuleTypeNotEqualTo(String value) {
            addCriterion("posting_rule_type <>", value, "postingRuleType");
            return (Criteria) this;
        }

        public Criteria andPostingRuleTypeGreaterThan(String value) {
            addCriterion("posting_rule_type >", value, "postingRuleType");
            return (Criteria) this;
        }

        public Criteria andPostingRuleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("posting_rule_type >=", value, "postingRuleType");
            return (Criteria) this;
        }

        public Criteria andPostingRuleTypeLessThan(String value) {
            addCriterion("posting_rule_type <", value, "postingRuleType");
            return (Criteria) this;
        }

        public Criteria andPostingRuleTypeLessThanOrEqualTo(String value) {
            addCriterion("posting_rule_type <=", value, "postingRuleType");
            return (Criteria) this;
        }

        public Criteria andPostingRuleTypeLike(String value) {
            addCriterion("posting_rule_type like", value, "postingRuleType");
            return (Criteria) this;
        }

        public Criteria andPostingRuleTypeNotLike(String value) {
            addCriterion("posting_rule_type not like", value, "postingRuleType");
            return (Criteria) this;
        }

        public Criteria andPostingRuleTypeIn(List<String> values) {
            addCriterion("posting_rule_type in", values, "postingRuleType");
            return (Criteria) this;
        }

        public Criteria andPostingRuleTypeNotIn(List<String> values) {
            addCriterion("posting_rule_type not in", values, "postingRuleType");
            return (Criteria) this;
        }

        public Criteria andPostingRuleTypeBetween(String value1, String value2) {
            addCriterion("posting_rule_type between", value1, value2, "postingRuleType");
            return (Criteria) this;
        }

        public Criteria andPostingRuleTypeNotBetween(String value1, String value2) {
            addCriterion("posting_rule_type not between", value1, value2, "postingRuleType");
            return (Criteria) this;
        }

        public Criteria andSeqIsNull() {
            addCriterion("seq is null");
            return (Criteria) this;
        }

        public Criteria andSeqIsNotNull() {
            addCriterion("seq is not null");
            return (Criteria) this;
        }

        public Criteria andSeqEqualTo(Integer value) {
            addCriterion("seq =", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotEqualTo(Integer value) {
            addCriterion("seq <>", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThan(Integer value) {
            addCriterion("seq >", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("seq >=", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThan(Integer value) {
            addCriterion("seq <", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThanOrEqualTo(Integer value) {
            addCriterion("seq <=", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqIn(List<Integer> values) {
            addCriterion("seq in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotIn(List<Integer> values) {
            addCriterion("seq not in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqBetween(Integer value1, Integer value2) {
            addCriterion("seq between", value1, value2, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotBetween(Integer value1, Integer value2) {
            addCriterion("seq not between", value1, value2, "seq");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Long value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Long value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Long value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Long value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Long value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Long> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Long> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Long value1, Long value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Long value1, Long value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andMembercodeIsNull() {
            addCriterion("memberCode is null");
            return (Criteria) this;
        }

        public Criteria andMembercodeIsNotNull() {
            addCriterion("memberCode is not null");
            return (Criteria) this;
        }

        public Criteria andMembercodeEqualTo(String value) {
            addCriterion("memberCode =", value, "membercode");
            return (Criteria) this;
        }

        public Criteria andMembercodeNotEqualTo(String value) {
            addCriterion("memberCode <>", value, "membercode");
            return (Criteria) this;
        }

        public Criteria andMembercodeGreaterThan(String value) {
            addCriterion("memberCode >", value, "membercode");
            return (Criteria) this;
        }

        public Criteria andMembercodeGreaterThanOrEqualTo(String value) {
            addCriterion("memberCode >=", value, "membercode");
            return (Criteria) this;
        }

        public Criteria andMembercodeLessThan(String value) {
            addCriterion("memberCode <", value, "membercode");
            return (Criteria) this;
        }

        public Criteria andMembercodeLessThanOrEqualTo(String value) {
            addCriterion("memberCode <=", value, "membercode");
            return (Criteria) this;
        }

        public Criteria andMembercodeLike(String value) {
            addCriterion("memberCode like", value, "membercode");
            return (Criteria) this;
        }

        public Criteria andMembercodeNotLike(String value) {
            addCriterion("memberCode not like", value, "membercode");
            return (Criteria) this;
        }

        public Criteria andMembercodeIn(List<String> values) {
            addCriterion("memberCode in", values, "membercode");
            return (Criteria) this;
        }

        public Criteria andMembercodeNotIn(List<String> values) {
            addCriterion("memberCode not in", values, "membercode");
            return (Criteria) this;
        }

        public Criteria andMembercodeBetween(String value1, String value2) {
            addCriterion("memberCode between", value1, value2, "membercode");
            return (Criteria) this;
        }

        public Criteria andMembercodeNotBetween(String value1, String value2) {
            addCriterion("memberCode not between", value1, value2, "membercode");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNull() {
            addCriterion("direction is null");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNotNull() {
            addCriterion("direction is not null");
            return (Criteria) this;
        }

        public Criteria andDirectionEqualTo(Integer value) {
            addCriterion("direction =", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotEqualTo(Integer value) {
            addCriterion("direction <>", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThan(Integer value) {
            addCriterion("direction >", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThanOrEqualTo(Integer value) {
            addCriterion("direction >=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThan(Integer value) {
            addCriterion("direction <", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThanOrEqualTo(Integer value) {
            addCriterion("direction <=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionIn(List<Integer> values) {
            addCriterion("direction in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotIn(List<Integer> values) {
            addCriterion("direction not in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionBetween(Integer value1, Integer value2) {
            addCriterion("direction between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotBetween(Integer value1, Integer value2) {
            addCriterion("direction not between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeIsNull() {
            addCriterion("currency_code is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeIsNotNull() {
            addCriterion("currency_code is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeEqualTo(String value) {
            addCriterion("currency_code =", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeNotEqualTo(String value) {
            addCriterion("currency_code <>", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeGreaterThan(String value) {
            addCriterion("currency_code >", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("currency_code >=", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeLessThan(String value) {
            addCriterion("currency_code <", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeLessThanOrEqualTo(String value) {
            addCriterion("currency_code <=", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeLike(String value) {
            addCriterion("currency_code like", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeNotLike(String value) {
            addCriterion("currency_code not like", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeIn(List<String> values) {
            addCriterion("currency_code in", values, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeNotIn(List<String> values) {
            addCriterion("currency_code not in", values, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeBetween(String value1, String value2) {
            addCriterion("currency_code between", value1, value2, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeNotBetween(String value1, String value2) {
            addCriterion("currency_code not between", value1, value2, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andPeOrderIdIsNull() {
            addCriterion("pe_order_id is null");
            return (Criteria) this;
        }

        public Criteria andPeOrderIdIsNotNull() {
            addCriterion("pe_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andPeOrderIdEqualTo(String value) {
            addCriterion("pe_order_id =", value, "peOrderId");
            return (Criteria) this;
        }

        public Criteria andPeOrderIdNotEqualTo(String value) {
            addCriterion("pe_order_id <>", value, "peOrderId");
            return (Criteria) this;
        }

        public Criteria andPeOrderIdGreaterThan(String value) {
            addCriterion("pe_order_id >", value, "peOrderId");
            return (Criteria) this;
        }

        public Criteria andPeOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("pe_order_id >=", value, "peOrderId");
            return (Criteria) this;
        }

        public Criteria andPeOrderIdLessThan(String value) {
            addCriterion("pe_order_id <", value, "peOrderId");
            return (Criteria) this;
        }

        public Criteria andPeOrderIdLessThanOrEqualTo(String value) {
            addCriterion("pe_order_id <=", value, "peOrderId");
            return (Criteria) this;
        }

        public Criteria andPeOrderIdLike(String value) {
            addCriterion("pe_order_id like", value, "peOrderId");
            return (Criteria) this;
        }

        public Criteria andPeOrderIdNotLike(String value) {
            addCriterion("pe_order_id not like", value, "peOrderId");
            return (Criteria) this;
        }

        public Criteria andPeOrderIdIn(List<String> values) {
            addCriterion("pe_order_id in", values, "peOrderId");
            return (Criteria) this;
        }

        public Criteria andPeOrderIdNotIn(List<String> values) {
            addCriterion("pe_order_id not in", values, "peOrderId");
            return (Criteria) this;
        }

        public Criteria andPeOrderIdBetween(String value1, String value2) {
            addCriterion("pe_order_id between", value1, value2, "peOrderId");
            return (Criteria) this;
        }

        public Criteria andPeOrderIdNotBetween(String value1, String value2) {
            addCriterion("pe_order_id not between", value1, value2, "peOrderId");
            return (Criteria) this;
        }

        public Criteria andPeDealIdIsNull() {
            addCriterion("pe_deal_id is null");
            return (Criteria) this;
        }

        public Criteria andPeDealIdIsNotNull() {
            addCriterion("pe_deal_id is not null");
            return (Criteria) this;
        }

        public Criteria andPeDealIdEqualTo(String value) {
            addCriterion("pe_deal_id =", value, "peDealId");
            return (Criteria) this;
        }

        public Criteria andPeDealIdNotEqualTo(String value) {
            addCriterion("pe_deal_id <>", value, "peDealId");
            return (Criteria) this;
        }

        public Criteria andPeDealIdGreaterThan(String value) {
            addCriterion("pe_deal_id >", value, "peDealId");
            return (Criteria) this;
        }

        public Criteria andPeDealIdGreaterThanOrEqualTo(String value) {
            addCriterion("pe_deal_id >=", value, "peDealId");
            return (Criteria) this;
        }

        public Criteria andPeDealIdLessThan(String value) {
            addCriterion("pe_deal_id <", value, "peDealId");
            return (Criteria) this;
        }

        public Criteria andPeDealIdLessThanOrEqualTo(String value) {
            addCriterion("pe_deal_id <=", value, "peDealId");
            return (Criteria) this;
        }

        public Criteria andPeDealIdLike(String value) {
            addCriterion("pe_deal_id like", value, "peDealId");
            return (Criteria) this;
        }

        public Criteria andPeDealIdNotLike(String value) {
            addCriterion("pe_deal_id not like", value, "peDealId");
            return (Criteria) this;
        }

        public Criteria andPeDealIdIn(List<String> values) {
            addCriterion("pe_deal_id in", values, "peDealId");
            return (Criteria) this;
        }

        public Criteria andPeDealIdNotIn(List<String> values) {
            addCriterion("pe_deal_id not in", values, "peDealId");
            return (Criteria) this;
        }

        public Criteria andPeDealIdBetween(String value1, String value2) {
            addCriterion("pe_deal_id between", value1, value2, "peDealId");
            return (Criteria) this;
        }

        public Criteria andPeDealIdNotBetween(String value1, String value2) {
            addCriterion("pe_deal_id not between", value1, value2, "peDealId");
            return (Criteria) this;
        }

        public Criteria andPeOrderSeqIdIsNull() {
            addCriterion("pe_order_seq_id is null");
            return (Criteria) this;
        }

        public Criteria andPeOrderSeqIdIsNotNull() {
            addCriterion("pe_order_seq_id is not null");
            return (Criteria) this;
        }

        public Criteria andPeOrderSeqIdEqualTo(Long value) {
            addCriterion("pe_order_seq_id =", value, "peOrderSeqId");
            return (Criteria) this;
        }

        public Criteria andPeOrderSeqIdNotEqualTo(Long value) {
            addCriterion("pe_order_seq_id <>", value, "peOrderSeqId");
            return (Criteria) this;
        }

        public Criteria andPeOrderSeqIdGreaterThan(Long value) {
            addCriterion("pe_order_seq_id >", value, "peOrderSeqId");
            return (Criteria) this;
        }

        public Criteria andPeOrderSeqIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pe_order_seq_id >=", value, "peOrderSeqId");
            return (Criteria) this;
        }

        public Criteria andPeOrderSeqIdLessThan(Long value) {
            addCriterion("pe_order_seq_id <", value, "peOrderSeqId");
            return (Criteria) this;
        }

        public Criteria andPeOrderSeqIdLessThanOrEqualTo(Long value) {
            addCriterion("pe_order_seq_id <=", value, "peOrderSeqId");
            return (Criteria) this;
        }

        public Criteria andPeOrderSeqIdIn(List<Long> values) {
            addCriterion("pe_order_seq_id in", values, "peOrderSeqId");
            return (Criteria) this;
        }

        public Criteria andPeOrderSeqIdNotIn(List<Long> values) {
            addCriterion("pe_order_seq_id not in", values, "peOrderSeqId");
            return (Criteria) this;
        }

        public Criteria andPeOrderSeqIdBetween(Long value1, Long value2) {
            addCriterion("pe_order_seq_id between", value1, value2, "peOrderSeqId");
            return (Criteria) this;
        }

        public Criteria andPeOrderSeqIdNotBetween(Long value1, Long value2) {
            addCriterion("pe_order_seq_id not between", value1, value2, "peOrderSeqId");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("memo is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("memo is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("memo =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("memo <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("memo >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("memo >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("memo <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("memo <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("memo like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("memo not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("memo in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("memo not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("memo between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("memo not between", value1, value2, "memo");
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

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIsNull() {
            addCriterion("request_time is null");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIsNotNull() {
            addCriterion("request_time is not null");
            return (Criteria) this;
        }

        public Criteria andRequestTimeEqualTo(Date value) {
            addCriterion("request_time =", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotEqualTo(Date value) {
            addCriterion("request_time <>", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeGreaterThan(Date value) {
            addCriterion("request_time >", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("request_time >=", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeLessThan(Date value) {
            addCriterion("request_time <", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeLessThanOrEqualTo(Date value) {
            addCriterion("request_time <=", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIn(List<Date> values) {
            addCriterion("request_time in", values, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotIn(List<Date> values) {
            addCriterion("request_time not in", values, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeBetween(Date value1, Date value2) {
            addCriterion("request_time between", value1, value2, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotBetween(Date value1, Date value2) {
            addCriterion("request_time not between", value1, value2, "requestTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIsNull() {
            addCriterion("crt_time is null");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIsNotNull() {
            addCriterion("crt_time is not null");
            return (Criteria) this;
        }

        public Criteria andCrtTimeEqualTo(Date value) {
            addCriterion("crt_time =", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotEqualTo(Date value) {
            addCriterion("crt_time <>", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeGreaterThan(Date value) {
            addCriterion("crt_time >", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("crt_time >=", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeLessThan(Date value) {
            addCriterion("crt_time <", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeLessThanOrEqualTo(Date value) {
            addCriterion("crt_time <=", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIn(List<Date> values) {
            addCriterion("crt_time in", values, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotIn(List<Date> values) {
            addCriterion("crt_time not in", values, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeBetween(Date value1, Date value2) {
            addCriterion("crt_time between", value1, value2, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotBetween(Date value1, Date value2) {
            addCriterion("crt_time not between", value1, value2, "crtTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIsNull() {
            addCriterion("upd_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIsNotNull() {
            addCriterion("upd_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdTimeEqualTo(Date value) {
            addCriterion("upd_time =", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotEqualTo(Date value) {
            addCriterion("upd_time <>", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeGreaterThan(Date value) {
            addCriterion("upd_time >", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("upd_time >=", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeLessThan(Date value) {
            addCriterion("upd_time <", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeLessThanOrEqualTo(Date value) {
            addCriterion("upd_time <=", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIn(List<Date> values) {
            addCriterion("upd_time in", values, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotIn(List<Date> values) {
            addCriterion("upd_time not in", values, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeBetween(Date value1, Date value2) {
            addCriterion("upd_time between", value1, value2, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotBetween(Date value1, Date value2) {
            addCriterion("upd_time not between", value1, value2, "updTime");
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