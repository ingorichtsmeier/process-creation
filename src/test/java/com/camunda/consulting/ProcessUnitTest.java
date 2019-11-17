package com.camunda.consulting;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.*;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProcessUnitTest {
  
  @Rule
  public ProcessEngineRule rule = new ProcessEngineRule();

  @Before
  public void setup() {
    init(rule.getProcessEngine());
  }
  
  @Test
  @Deployment(resources = "normalProcess.bpmn")
  public void testFind0001InNormal() {
    assertThat(find("Set reminder date")).isEqualTo("Task_1ff5pjf");
  }

  @Test
  @Deployment(resources = "10TasksProcess.bpmn")
  public void testFind100In0010TasksProcess() {
    for (int i = 0; i < 10; i++) {
      for (int j = 1; j < 10; j++) {
        assertThat(find("Task "+ 1)).isEqualTo("Task" + 1);              
      }
    }
  }

  @Test
  @Deployment(resources = "50TasksProcess.bpmn")
  public void testFind100In0050TasksProcess() {
    for (int i = 0; i < 2; i++) {
      for (int j = 1; j < 50; j++) {
        assertThat(find("Task "+ 1)).isEqualTo("Task" + 1);              
      }
    }
  }

  @Test
  @Deployment(resources = "100TasksProcess.bpmn")
  public void testFind100In0100TasksProcess() {
    for (int i = 1; i < 100; i++) {
      assertThat(find("Task "+ 1)).isEqualTo("Task" + 1);
    }
  }
  
  @Test
  @Deployment(resources = "250TasksProcess.bpmn")
  public void testFind100In0250TasksProcess() {
    for (int i = 1; i < 100; i++) {
      assertThat(find("Task "+ 1)).isEqualTo("Task" + 1);      
    }    
  }

  @Test
  @Deployment(resources = "500TasksProcess.bpmn")
  public void testFind100In0500TasksProcess() {
    for (int i = 1; i < 100; i++) {
      assertThat(find("Task "+ 1)).isEqualTo("Task" + 1);      
    }    
  }

  //  @Test
  @Deployment(resources = "1000TasksProcess.bpmn")
  public void testFind100In1000Process() {
    for (int i = 1; i < 100; i++) {
      assertThat(find("Task "+ 1)).isEqualTo("Task" + 1);      
    }
  }
  
  @Test
  @Deployment(resources = "100TasksProcess.bpmn")
  public void testFindSingleIn0100TasksProcess() {
    assertThat(find("Task 50")).isEqualTo("Task50");
  }

  @Test
  @Deployment(resources = "500TasksProcess.bpmn")
  public void testFindSingleIn0500TasksProcess() {
    assertThat(find("Task 250")).isEqualTo("Task250");
  }

  @Test
  @Deployment(resources = "1000TasksProcess.bpmn")
  public void testFindSingleIn1000TasksProcess() {
    assertThat(find("Task 500")).isEqualTo("Task500");
  }

}
