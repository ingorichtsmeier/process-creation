# Performance Measurements for `find()`

Creating large process model by api and use them for performance measurements.

The Junit test loops over serveral processes with 10, 50 , 100, 250 500 and even 1000 tasks.

In the surefire reposrt you can get an idea about the performance of  `find("Task name")`, which is not bad for processes up to 250 tasks.

`find()` maps element names to element IDs and is submitted as a pull request to [camunda-bpm-assert](https://github.com/camunda/camunda-bpm-assert).

Then you can write

```java
assertThat(processInstance).isWaitingAt(find("My long task name"));
```

instead of 
```java
assertThat(processInstance).isWaitingAt("Task_126gsw");
```
