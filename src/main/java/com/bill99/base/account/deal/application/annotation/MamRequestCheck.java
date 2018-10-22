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

import com.bill99.mam.application.MamRequest;

@Constraint(validatedBy = { MamRequestCheck.BalanceValidator.class })
@Documented
@Target({ ElementType.ANNOTATION_TYPE, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface MamRequestCheck {

	String message() default "illegal MamRequest parameters";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	/**
	 * 对MamRequest参数的校验
	 * @author jerry.xu.coc
	 */
	public class BalanceValidator implements
			ConstraintValidator<MamRequestCheck, MamRequest> {
		
		public void initialize(MamRequestCheck balance) {
		}

		public boolean isValid(MamRequest request,ConstraintValidatorContext context) {
			String appId = request.getAppId();
			String bizCode = request.getBizCode();
			if (StringUtils.isBlank(appId) || StringUtils.isBlank(bizCode)) {
				return false;
			}
			return true;
		}
	}

}
