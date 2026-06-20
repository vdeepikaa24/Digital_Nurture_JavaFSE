# Scenario 3: Add New Customer

## Description

This stored procedure inserts a new customer into the `Customers` table. It includes error handling to verify that the customer ID does not already exist. If a duplicate customer ID is found, the procedure logs an appropriate error message and prevents the insertion.

## Files

* `solution.sql`: Contains the `AddNewCustomer` stored procedure definition.
* `verification.sql`: Tests both a successful customer insertion and a failure scenario (duplicate customer ID).

## Execution Steps

1. Run `solution.sql` to compile the procedure.
2. Run `verification.sql` to observe the successful insertion and error handling behavior.
