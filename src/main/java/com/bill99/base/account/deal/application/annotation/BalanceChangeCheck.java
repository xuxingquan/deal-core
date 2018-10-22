package com.bill99.base.account.deal.application.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.bill99.base.account.deal.application.request.BalanceChange;
import com.bill99.base.account.deal.application.request.ChangeBalanceRequest;

@Constraint(validatedBy = { BalanceChangeCheck.BalanceValidator.class })
@Documented
@Target({ ElementType.ANNOTATION_TYPE, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface BalanceChangeCheck {

	String message() default "invalid ChangeBalanceRequest";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	public class BalanceValidator implements
			ConstraintValidator<BalanceChangeCheck, ChangeBalanceRequest> {

		public void initialize(BalanceChangeCheck balance) {
		}

		public boolean isValid(ChangeBalanceRequest request,
				ConstraintValidatorContext context) {
			
			List<BalanceChange> balanceChangeList = request.getBalanceChange();
			if (CollectionUtils.isEmpty(balanceChangeList)) {
				return false;
			}
			String subAcctType = null;
			String subAcctSubjectCode = null;
			for (BalanceChange balanceChange : balanceChangeList) {
				subAcctType = balanceChange.getSubAcctType();
				subAcctSubjectCode = balanceChange.getSubAcctSubjectCode();
				if (StringUtils.isBlank(subAcctType) && 
						StringUtils.isBlank(subAcctSubjectCode)) {
					return false;
				}
			}
			return true;
		}
	}

}
