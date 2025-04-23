package com.structura.project.core.project.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;

@Data
public final class Project {
    private String id;
    private ProjectOwner owner;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private List<ProjectTask> tasks;
    private List<ProjectMember> members;

    public Project(
            String id,
            ProjectOwner owner,
            String name,
            String description,
            LocalDateTime createdAt,
            List<ProjectTask> tasks,
            List<ProjectMember> members
    ) {
        this.id = id == null ? UUID.randomUUID().toString() : id;
        this.owner = owner;
        this.name = requireNonBlank(name, "Project name cannot be null or empty");
        this.description = description;
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
        this.tasks = tasks == null ? new ArrayList<>() : tasks;
        this.members = members == null ? Arrays.asList(new ProjectMember(owner.userEmail())) : members;
    }

    public Project(String id, ProjectOwner owner, String name, String description, List<ProjectTask> tasks, List<ProjectMember> members) {
        this(id, owner, name, description, null, tasks, members);
    }

    public Project(String id, ProjectOwner owner, String name, String description) {
        this(id, owner, name, description, null, null);
    }

    public Project(Project project, List<ProjectMember> members) {
        this(
                project.id(),
                project.owner(),
                project.name(),
                project.description(),
                project.createdAt(),
                project.tasks(),
                Stream.concat(Objects.requireNonNull(members, "members must not be null").stream(),
                                Stream.of(new ProjectMember(project.owner.userEmail())))
                        .distinct()
                        .toList()
        );
    }

    public static String requireNonBlank(String obj, String message) {
        if (obj == null || obj.isBlank())
            throw new IllegalArgumentException(message);
        return obj;
    }


    public Project copyAppendingTask(ProjectTask task) {
        return new Project(
                this.id(),
                this.owner(),
                this.name(),
                this.description(),
                this.createdAt(),
                Stream.concat(
                        Objects.requireNonNull(this.tasks, "tasks must not be null")
                                .stream(), Stream.of(task)).toList(),
                this.members
        );
    }

    public boolean isNotAMember(ProjectMember member) {
        return !isMember(member);
    }

    public boolean isMember(ProjectMember member) {
        return members.contains(member);
    }

    public void addTask(ProjectTask task) {
        if (!members.contains(task.assignedTo())) {
            throw new IllegalArgumentException("Task cannot be assigned to a non-member");
        }

        tasks.add(task);
    }

    public String id() {
        return id;
    }

    public ProjectOwner owner() {
        return owner;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public List<ProjectTask> tasks() {
        return tasks;
    }

    public List<ProjectMember> members() {
        return members;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Project) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.owner, that.owner) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.description, that.description) &&
                Objects.equals(this.createdAt, that.createdAt) &&
                Objects.equals(this.tasks, that.tasks) &&
                Objects.equals(this.members, that.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, owner, name, description, createdAt, tasks, members);
    }

    @Override
    public String toString() {
        return "Project[" +
                "id=" + id + ", " +
                "owner=" + owner + ", " +
                "name=" + name + ", " +
                "description=" + description + ", " +
                "createdAt=" + createdAt + ", " +
                "tasks=" + tasks + ", " +
                "members=" + members + ']';
    }

}
