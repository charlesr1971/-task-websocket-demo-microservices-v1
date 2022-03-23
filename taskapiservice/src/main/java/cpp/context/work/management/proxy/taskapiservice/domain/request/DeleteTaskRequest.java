package cpp.context.work.management.proxy.taskapiservice.domain.request;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author bu
 */
public class DeleteTaskRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    public DeleteTaskRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final DeleteTaskRequest other = (DeleteTaskRequest) obj;
        return Objects.equals(this.id, other.id);
    }

}
