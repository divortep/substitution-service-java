## Substitutions REST service
This is a REST service, taking a set of boolean flags and numbers as an input, and returning a substitution result along with a type of the applied substitution.

#### Technologies and frameworks

- Java 11, Spring, Lombok, Maven
- Groovy and Spock framework for testing

#### Architecture and implementation details

- A domain model consists of Input, Output, SubstitutionType, Substitution, SubstitutionSet and SubstitutionSetFactory classes.
- There are 6 different substitutions, that might be aggregated into substitution sets.
- Some substitution classes reuse logic from other ones through composition, since it is a good practice to use composition instead inheritance where it is possible.
- Also, 3 predefined substitution sets are available through SubstitutionSetFactory methods.
- This model allows easily create new substitutions and combine them into different sets.
- The application has two main layers: controller and service.
- The controller just passes an input to the service, since it is not recommended putting any business logic into controllers, only simple manipulations on requests and responses.
- The service contains references to 3 different sets of substitutions, created through factory methods.
- A 'SubstitutionSet' class itself contains encapsulated logic for choosing a substitution from a set, based on input parameters, and applying this substitution to the input.
- I did my best to cover most of the logic by unit tests and coverage is 98%.
- The application can be run in a docker container via deploy.sh script.

#### Endpoints

- /substitution/baseSet
- /substitution/customSet
- /substitution/customSet1

##### Request example
```text
POST /substitution/baseSet
Body:
{
    "a": true,
    "b": true,
    "c": false,
    "d": 1.1,
    "e": 1,
    "f": 1
}
```
