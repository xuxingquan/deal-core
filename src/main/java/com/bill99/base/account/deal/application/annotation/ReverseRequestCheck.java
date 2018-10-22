package com.bill99.base.account.deal.application.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import org.apache.commons.lang3.StringUtils;

import com.bill99.base.account.deal.application.request.ReverseRequest;

@Constraint(validatedBy = { ReverseRequestCheck.ReverseValidator.class })
@Documented
@Target({ ElementType.ANNOTATION_TYPE, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ReverseRequestCheck {

	String message() default "invalid ReverseRequest";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	public class ReverseValidator implements ConstraintValidator<ReverseRequestCheck, ReverseRequest> {

		public void initialize(ReverseRequestCheck balance) {
		}

		public boolean isValid(ReverseRequest request,ConstraintValidatorContext context) {
			String orignDealId = request.getOrignDealId();
			String orignOrderId = request.getOrignOrderId();
			String orignOutTradeNo = request.getOrignOutTradeNo();
			return StringUtils.isNotBlank(orignDealId) || 
					(StringUtils.isNotBlank(orignOrderId) && StringUtils.isNotBlank(orignOutTradeNo));
		}
	}

}
