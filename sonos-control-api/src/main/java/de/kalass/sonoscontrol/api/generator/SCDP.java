package de.kalass.sonoscontrol.api.generator;

import java.util.List;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.base.Preconditions;

public final class SCDP {

	public static final class AllowedValueRange {
		@Nonnull
		private final String _minimum;
		@Nonnull
		private final String _maximum;
		@CheckForNull
		private final String _step;
		
		public AllowedValueRange(@Nonnull String minimum, @Nonnull  String maximum, @Nullable String step) {
			_minimum = Preconditions.checkNotNull(minimum);
			_maximum = Preconditions.checkNotNull(maximum);
			_step = step;
		}
		
		public String getMinimum() {
			return _minimum;
		}
		
		public String getMaximum() {
			return _maximum;
		}
		
		public String getStep() {
			return _step;
		}
	}
	
	public static final class StateVariable {
		@Nonnull 
		private final String name;
		@Nonnull 
		private final String dataType;
		@Nonnull 
		private final List<String> allowedValueList;
		@CheckForNull
		private final AllowedValueRange allowedValueRange;
		
		public StateVariable(
				@Nonnull String name,
				@Nonnull String dataType,
				@Nonnull List<String> allowedValueList,
				@Nullable
				AllowedValueRange allowedValueRange
				) {
			super();
			this.name = Preconditions.checkNotNull(name);
			this.dataType = Preconditions.checkNotNull(dataType);
			this.allowedValueList = Preconditions.checkNotNull(allowedValueList);
			this.allowedValueRange = allowedValueRange;
		}
		
		@Nonnull 
		public String getName() {
			return name;
		}
		
		@Nonnull 
		public String getDataType() {
			return dataType;
		}
		
		@Nonnull 
		public List<String> getAllowedValueList() {
			return allowedValueList;
		}
		
		@CheckForNull
		public AllowedValueRange getAllowedValueRange() {
			return allowedValueRange;
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