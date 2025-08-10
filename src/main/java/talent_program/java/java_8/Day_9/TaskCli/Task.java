package main.java.talent_program.java.java_8.Day_9.TaskCli;

import java.time.LocalDate;

public class Task {
    private long id = System.currentTimeMillis();
    private String description;
    private LocalDate deadLine;
    private Priority priority;
    private Status status = Status.Undone;

    public Task() {
    }

    public Task(long id, String description, LocalDate deadLine, Priority priority, Status status) {
        this.id = id;
        this.description = description;
        this.deadLine = deadLine;
        this.priority = priority;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return STR."Task{id=\{id}, description='\{description}', deadLine=\{deadLine}, priority=\{priority}, status=\{status}}";
    }
}
