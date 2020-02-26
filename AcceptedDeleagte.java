package org.boa.usvisaprocess.delegates;

import java.util.logging.Logger;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.SignalEventReceivedBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("acceptedDelegate")
public class AcceptedDeleagte implements JavaDelegate{

	Logger logger=Logger.getLogger(AcceptedDeleagte.class.getName());
	@Autowired
    private RuntimeService runTimeService;
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		logger.info(execution.getVariable("status").toString());
		SignalEventReceivedBuilder signalEventReceivedBuilder=
				runTimeService.createSignalEvent("Signal_3dv95j4");
		signalEventReceivedBuilder.send();
	}

}
