package cpp.context.work.management.proxy.taskapiservice.domain.response;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author bu
 */
public class UpdateTaskResponse implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String id;
    
    private String status;

    public UpdateTaskResponse(String id, String status) {
        this.id = id;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final UpdateTaskResponse other = (UpdateTaskResponse) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "cpp.context.work.management.proxy.taskapiservice.domain.model.Task[ id=" + id + " ]";
    }
    
}
