package ru.project.examtest.data.db;

import androidx.room.*;
import ru.project.examtest.data.inerfaces.*;
import ru.project.examtest.data.models.*;

@Database(
        entities = {
                RoomTeacher.class,
                RoomTerms.class,
                RoomTheory.class,
                RoomStudent.class,
                RoomBasicFormula.class,
                RoomDiagrams.class,
                RoomTables.class,
                RoomTasks.class,
                RoomTestOgeP.class
        },
        version = 1
)
public abstract class MyRoomManager extends RoomDatabase {
    public abstract TeacherDAO teacherDAO();
    public abstract TermsDAO termsDAO();
    public abstract TheoryDAO theoryDAO();
    public abstract StudentDAO studentDAO();
    public abstract BasicFormulasDAO basicFormulasDAO();
    public abstract DiagramsDAO diagramsDAO();
    public abstract TablesDAO tablesDAO();
    public abstract TasksDAO tasksDAO();
    public abstract TestOgeP_DAO roomTestOgeP();
}
