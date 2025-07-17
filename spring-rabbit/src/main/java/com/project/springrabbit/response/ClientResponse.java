package com.project.springrabbit.response;

public record ClientResponse(
        String clientId,
        String firstName,
        String lastName,
        String emailAddress,
        String phoneNumber,
        String addressLine,
        String city,
        String state,
        Integer codeProduct,
        boolean isActive
) {
}
