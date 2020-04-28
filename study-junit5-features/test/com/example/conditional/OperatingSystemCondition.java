package com.example.conditional;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.util.AnnotationUtils;

import java.util.Arrays;

public class OperatingSystemCondition implements ExecutionCondition {

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext ec) {
        ConditionEvaluationResult result = ConditionEvaluationResult.enabled("@ConditionalTestOnOperatingSystem is not available");
        var element = ec.getElement();
        var condition = AnnotationUtils.findAnnotation(element, ConditionalTestOnOperatingSystem.class);
        if (condition.isPresent()){
            OperatingSystem currentOs = OperatingSystem.determine();
            var values = condition.get().value();
            var found = Arrays.stream(values)
                              .filter( value -> value.equals(currentOs))
                              .findFirst();
            if (found.isPresent())
                result = ConditionEvaluationResult.enabled("Test is enabled");
            else
                result = ConditionEvaluationResult.disabled("Test is disabled");
        }
        return result;
    }
}
