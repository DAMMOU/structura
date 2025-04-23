
import java.time.LocalDateTime;

public record ProjectTask(
        String id,
        String title,
        String description,
        TaskOwner owner,
        ProjectMember assignedTo,
        TaskStatus status,
        LocalDateTime createdAt
) {
    public ProjectTask {
        if (id == null) {
            throw new IllegalArgumentException("id must not be null");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title must not be null or blank");
        }

        if (owner == null) {
            throw new IllegalArgumentException("owner must not be null");
        }

        if (status == null) {
            throw new IllegalArgumentException("status must not be null");
        }
    }

    public ProjectTask(String id, String title, String description, TaskOwner owner, ProjectMember assignedTo) {
        this(id, title, description, owner, assignedTo, TaskStatus.TODO, LocalDateTime.now());
    }
}
