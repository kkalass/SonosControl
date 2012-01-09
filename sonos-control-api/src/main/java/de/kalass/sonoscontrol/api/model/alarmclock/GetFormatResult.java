// AUTOGENERATED: 750959c6728669f4d4489b61075c99cd
// AUTOGENERATED: 09.01.2012 13:05:47
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.api.model.alarmclock;

import com.google.common.base.Objects;
import java.io.Serializable;


public final class GetFormatResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private final TimeFormat _currentTimeFormat;
    private final DateFormat _currentDateFormat;

    private GetFormatResult(
        final TimeFormat currentTimeFormat,
        final DateFormat currentDateFormat
    ) {
        _currentTimeFormat = currentTimeFormat;
        _currentDateFormat = currentDateFormat;
    } 

    public static GetFormatResult getInstance(
        final TimeFormat currentTimeFormat,
        final DateFormat currentDateFormat
    ) {
        return new GetFormatResult(currentTimeFormat, currentDateFormat);
    } 
    public TimeFormat getCurrentTimeFormat() {
        return _currentTimeFormat;
    }
    public DateFormat getCurrentDateFormat() {
        return _currentDateFormat;
    }

    public String toString() {
        return Objects.toStringHelper(this)
        .add("currentTimeFormat", _currentTimeFormat)
        .add("currentDateFormat", _currentDateFormat)
        .toString();
    }

    public int hashCode() {
        return Objects.hashCode(
            _currentTimeFormat,
            _currentDateFormat
        );
    }

    public boolean equals(Object other) {
        if (other instanceof GetFormatResult) {
            GetFormatResult obj = (GetFormatResult)other;
            return 
                    Objects.equal(_currentTimeFormat, obj._currentTimeFormat) &&
                    Objects.equal(_currentDateFormat, obj._currentDateFormat) 
            ;
        }
        return false;
    }

}
