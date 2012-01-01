package de.kalass.sonoscontrol.api.generator;

import java.util.List;

public final class SCDP {

	public static final class StateVariable {
		private final String name;
		private final String dataType;
		private final List<String> allowedValueList;
		public StateVariable(String name, String dataType,
				List<String> allowedValueList) {
			super();
			this.name = name;
			this.dataType = dataType;
			this.allowedValueList = allowedValueList;
		}
		
		public String getName() {
			return name;
		}
		
		public String getDataType() {
			return dataType;
		}
		public List<String> getAllowedValueList() {
			return allowedValueList;
		}
	}
	
	public static final class ActionArgument {
		private final String _name;
		private final SCDP.StateVariable _relatedStateVariable;
		public ActionArgument(String name, SCDP.StateVariable relatedStateVariable) {
			_name = name;
			_relatedStateVariable = relatedStateVariable;
		}
		public String getName() {
			return _name;
		}
		public SCDP.StateVariable getRelatedStateVariable() {
			return _relatedStateVariable;
		}
	}
	
	public static final class Action {
		private final String _name;
		private final List<SCDP.ActionArgument> _inputParameters;
		private final List<SCDP.ActionArgument> _outputParameters;
		public Action(String name, List<SCDP.ActionArgument> inputParameters, List<SCDP.ActionArgument> outputParameters) {
			_name = name;
			_inputParameters = inputParameters;
			_outputParameters = outputParameters;
		}
		
		public String getName() {
			return _name;
		}

		public List<SCDP.ActionArgument> getInputParameters() {
			return _inputParameters;
		}
		
		public List<SCDP.ActionArgument> getOutputParameters() {
			return _outputParameters;
		}
		
	}
	private final List<SCDP.StateVariable> _stateVariables;
	private final List<SCDP.Action> _actions;
	public SCDP(List<SCDP.StateVariable> stateVariables, List<SCDP.Action> actions) {
		_stateVariables = stateVariables;
		_actions = actions;
	}
	public List<SCDP.Action> getActions() {
		return _actions;
	}
	public List<SCDP.StateVariable> getStateVariables() {
		return _stateVariables;
	}
}