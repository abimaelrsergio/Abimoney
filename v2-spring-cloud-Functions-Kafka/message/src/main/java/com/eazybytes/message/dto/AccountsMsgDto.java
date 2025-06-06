package com.eazybytes.message.dto;

/**
 * Represents a data transfer object for account messages.
 *
 * This record class holds the necessary information for account messages.
 *
 * @author Abimael Sergio
 * @since 1.0
 */
public record AccountsMsgDto(Long accountNumber, String name, String email, String mobileNumber) {
}
