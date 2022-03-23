package cpp.context.work.management.proxy.taskapiservice.domain.model;

import java.io.Serializable;

/**
 *
 * @author betrand.ugorji1
 */
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String assignee;

    //Datetime
    private String created;

    //Datetime
    private String due;

    private String followUp;

    //enum
    private String delegationState;

    private String description;

    private String executionId;

    private String owner;

    private String parentTaskId;

    private int priority;

    private String processDefinitionId;

    private String processInstanceId;

    private String taskDefinitionKey;

    private String caseExecutionId;

    private String caseInstanceId;

    private String caseDefinitionId;

    private boolean suspended;

    private String formKey;

    private String tenantId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }

    public String getFollowUp() {
        return followUp;
    }

    public void setFollowUp(String followUp) {
        this.followUp = followUp;
    }

    public String getDelegationState() {
        return delegationState;
    }

    public void setDelegationState(String delegationState) {
        this.delegationState = delegationState;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExecutionId() {
        return executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getParentTaskId() {
        return parentTaskId;
    }

    public void setParentTaskId(String parentTaskId) {
        this.parentTaskId = parentTaskId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getTaskDefinitionKey() {
        return taskDefinitionKey;
    }

    public void setTaskDefinitionKey(String taskDefinitionKey) {
        this.taskDefinitionKey = taskDefinitionKey;
    }

    public String getCaseExecutionId() {
        return caseExecutionId;
    }

    public void setCaseExecutionId(String caseExecutionId) {
        this.caseExecutionId = caseExecutionId;
    }

    public String getCaseInstanceId() {
        return caseInstanceId;
    }

    public void setCaseInstanceId(String caseInstanceId) {
        this.caseInstanceId = caseInstanceId;
    }

    public String getCaseDefinitionId() {
        return caseDefinitionId;
    }

    public void setCaseDefinitionId(String caseDefinitionId) {
        this.caseDefinitionId = caseDefinitionId;
    }

    public boolean isSuspended() {
        return suspended;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }

    public String getFormKey() {
        return formKey;
    }

    public void setFormKey(String formKey) {
        this.formKey = formKey;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Task)) {
            return false;
        }
        
        Task other = (Task) object;
        
        return !((this.id == null && other.id != null) || 
                (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "cpp.context.work.management.proxy.taskapiservice.domain.model.Task[ id=" + id + " ]";
    }
    
}
