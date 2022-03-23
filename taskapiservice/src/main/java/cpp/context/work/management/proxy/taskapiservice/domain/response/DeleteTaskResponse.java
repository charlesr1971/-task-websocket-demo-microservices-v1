package cpp.context.work.management.proxy.taskapiservice.domain.response;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author bu
 */
public class DeleteTaskResponse implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String id;
    
    private String message;

    public DeleteTaskResponse(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DeleteTaskResponse other = (DeleteTaskResponse) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "DeleteTaskResponse{" + "id=" + id + ", message=" + message + '}';
    }
        
}
