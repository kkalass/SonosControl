package de.kalass.sonoscontrol.api.core;

import javax.annotation.Nonnull;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public class ZoneName {
	private final String _name;
	
	public ZoneName(@Nonnull String name) {
		_name = Preconditions.checkNotNull(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ZoneName) {
			final ZoneName other = (ZoneName) obj;
			return Objects.equal(_name, other._name);
		}
		return false;
	}
	@Override
	public int hashCode() {
		return _name.hashCode();
	}
	
	@Override
	public String toString() {
		return _name;
	}
	
	public static ZoneName getInstance(String name) {
		return new ZoneName(name);
	}
}
