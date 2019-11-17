package com.camunda.consulting;

import java.io.File;

import org.camunda.bpm.model.bpmn.Bpmn;
import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.camunda.bpm.model.bpmn.builder.ServiceTaskBuilder;

public class ProcessCreator {

  public static void main(String[] args) {
    ServiceTaskBuilder lastServiceTask = Bpmn.createExecutableProcess("LargeProcess").startEvent()
        .serviceTask("Task1").camundaDelegateExpression("${true}").name("Task 1");
        
    for (int i = 2; i < 10; i++) {
      System.out.println(i);
      lastServiceTask = lastServiceTask.serviceTask("Task" + i).camundaDelegateExpression("${true}").name("Task " + i);
    }
    
    BpmnModelInstance modelInstance = lastServiceTask.endEvent("End").name("End").done();
    
    System.out.println(Bpmn.convertToString(modelInstance));
    Bpmn.writeModelToFile(new File("veryLargeProcess.bpmn"), modelInstance);
  }

}
