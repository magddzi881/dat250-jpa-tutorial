# DAT250 Experiment 4 Report

## Technical Problems Encountered

During the installation and use of JPA, I encountered technical issues:

1. **Database Constraints**: I encountered primary key and unique constraint violations when attempting to persist objects, specifically with credit cards and customers. This was resolved by verifying the uniqueness of the objects. 


2. **Test Assertion Failures**: In my test cases, I faced assertion failures related to the comparison of collections. Initially, the test expected a specific type of collection but received another. I resolved this by modifying the assertion to check for equality in contents rather than the specific collection type. I changed the assertion to:
   ```java
   assertTrue(bank.getOwnedCards().containsAll(Set.of(firstCard, secondCard)) &&
              Set.of(firstCard, secondCard).containsAll(bank.getOwnedCards()));
   ```

## Code Link

The complete code for Experiment repository: [GitHub Repository](https://github.com/magddzi881/dat250-jpa-tutorial).

## Database Inspection

To inspect the database tables created by JPA, I used logger.
The following tables were created:

- `CUSTOMER`
- `CREDITCARD`
- `BANK`
- `ADDRESS`
- `PINCODE`

## Pending Issues

There are currently no pending issues with this assignment. 