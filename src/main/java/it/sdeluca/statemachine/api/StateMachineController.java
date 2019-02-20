package it.sdeluca.statemachine.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import it.sdeluca.statemachine.enums.Events;
import it.sdeluca.statemachine.enums.States;

@RestController
@RequestMapping("/api/v1/statemachine")
@Api(value = "Controller to state machine")
public class StateMachineController {

	@Autowired
    private StateMachine<States, Events> stateMachine;

	@ApiOperation("Start state machine")
	@PostMapping("/start")
	public void start() {
		stateMachine.start();
	}
	
	@ApiOperation("Start state machine")
	@PutMapping("/next")
	public void next() {
		if(stateMachine.getState().getId().equals(States.STATE1)) {
			stateMachine.getExtendedState().getVariables().put("ProvaKey", "ProvaValue");
			stateMachine.sendEvent(Events.EVENT1);
		} else if(stateMachine.getState().getId().equals(States.STATE2)) {
			stateMachine.sendEvent(Events.EVENT2);
		} else throw new RuntimeException("Not a valid state");
	}
	
}