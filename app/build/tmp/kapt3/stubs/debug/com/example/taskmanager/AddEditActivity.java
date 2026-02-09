package com.example.taskmanager;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\t\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/taskmanager/AddEditActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/taskmanager/databinding/ActivityAddEditBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "saveTask", "Companion", "app_debug"})
public final class AddEditActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.taskmanager.databinding.ActivityAddEditBinding binding;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.taskmanager.AddEditActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_ID = "com.example.taskmanager.EXTRA_ID";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_TITLE = "com.example.taskmanager.EXTRA_TITLE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_DESCRIPTION = "com.example.taskmanager.EXTRA_DESCRIPTION";
    
    public AddEditActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void saveTask() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/example/taskmanager/AddEditActivity$Companion;", "", "()V", "EXTRA_DESCRIPTION", "", "EXTRA_ID", "EXTRA_TITLE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}