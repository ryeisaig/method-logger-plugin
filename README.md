# custom-method-logger
This sample Java Spring Boot application that I made simplifies the traditional way of putting start and end logs per method using custom annotation.

Any component can use the ```@LogStartEnd``` annotation on method level to automatically log the *start* and *end* transaction with arguments and the return value of that method.

**Below is the sample logs on runtime**
```
Started CustomMethodLoggerApplication in 0.925 seconds (process running for 1.618)
Started calling testLog with args: [name=Rye, countryOrigin=Philippines]
Finished calling testLog with args: [name=Rye, countryOrigin=Philippines] and result: Hello Rye from Philippines!
Started calling testLogNoReturn with args: [name=Rye, countryOrigin=Philippines]
Finished calling testLogNoReturn with args: [name=Rye, countryOrigin=Philippines] and result: null
```
