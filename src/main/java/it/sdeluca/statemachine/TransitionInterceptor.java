package it.sdeluca.statemachine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.statemachine.ExtendedState;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

@WithStateMachine
public class TransitionInterceptor {

	private static Logger log = LoggerFactory.getLogger(TransitionInterceptor.class);
	
	@OnTransition(source = "STATE1", target = "STATE2")
    public void fromS1ToS2(ExtendedState extendedState) {
		log.debug(extendedState.getVariables().toString());
		log.debug("Transition to state 2");
    }

	@OnTransition(source = "STATE2", target = "STATE1")
	public void fromS2ToS1(ExtendedState extendedState) {
		log.debug("Transition to state 1");
	}
	
}