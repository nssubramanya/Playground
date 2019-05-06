package com.subbu.aws.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaFunctionHandler implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object input, Context context) {
        context.getLogger().log("Input: " + input);
        context.getLogger().log("Function Name: " + context.getFunctionName());
        context.getLogger().log("Remaining Time in Millis: " + Integer.toString(context.getRemainingTimeInMillis()));

        // TODO: implement your handler
        return "Hello from Lambda!";
    }

}
