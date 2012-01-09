// AUTOGENERATED: 94d4300678c1866d44f2aba1cbce8d3e
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.api.model.contentdirectory;

import com.google.common.base.Objects;
import java.io.Serializable;


public final class CreateObjectResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private final ObjectID _objectID;
    private final Result _result;

    private CreateObjectResult(
        final ObjectID objectID,
        final Result result
    ) {
        _objectID = objectID;
        _result = result;
    } 

    public static CreateObjectResult getInstance(
        final ObjectID objectID,
        final Result result
    ) {
        return new CreateObjectResult(objectID, result);
    } 
    public ObjectID getObjectID() {
        return _objectID;
    }
    public Result getResult() {
        return _result;
    }

    public String toString() {
        return Objects.toStringHelper(this)
        .add("objectID", _objectID)
        .add("result", _result)
        .toString();
    }

    public int hashCode() {
        return Objects.hashCode(
            _objectID,
            _result
        );
    }

    public boolean equals(Object other) {
        if (other instanceof CreateObjectResult) {
            CreateObjectResult obj = (CreateObjectResult)other;
            return 
                    Objects.equal(_objectID, obj._objectID) &&
                    Objects.equal(_result, obj._result) 
            ;
        }
        return false;
    }

}
