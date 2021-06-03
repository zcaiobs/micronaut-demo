package com.example.validator

import io.micronaut.core.annotation.AnnotationValue
import javax.inject.Singleton
import javax.validation.Constraint
import io.micronaut.validation.validator.constraints.ConstraintValidator
import io.micronaut.validation.validator.constraints.ConstraintValidatorContext
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.*

@MustBeDocumented
@Target(FIELD, CONSTRUCTOR)
@Retention(RUNTIME)
@Constraint(validatedBy = [DemoValidation::class])
annotation class DemoValid(val message: String = "Value is not valid")

@Singleton
class DemoValidation: ConstraintValidator<DemoValid, String> {
    override fun isValid(
        value: String?,
        annotationMetadata: AnnotationValue<DemoValid>,
        context: ConstraintValidatorContext
    ): Boolean {
        if (value == null) {
            return false
        }

        return value.startsWith("D")
    }
}