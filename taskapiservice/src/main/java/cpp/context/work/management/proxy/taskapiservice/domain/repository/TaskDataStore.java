package cpp.context.work.management.proxy.taskapiservice.domain.repository;

import cpp.context.work.management.proxy.taskapiservice.domain.response.CreateTaskResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author bu
 */
@Singleton
@Startup
public class TaskDataStore {

    private static final Map<String, CreateTaskResponse> db = new HashMap<>();

    public CreateTaskResponse getTaskById(String id) {
        return db.get(id);
    }

    public List<CreateTaskResponse> getTasks() {
        return new ArrayList<>(db.values());
    }

    public void updateTask(CreateTaskResponse task) {
        db.put(task.getId(), task);
    }

    public void createTask(CreateTaskResponse task) {
        db.put(task.getId(), task);
    }

    public void deleteTask(String taskId) {
        db.remove(taskId);
    }

    public void clear() {
        db.clear();
    }

}
