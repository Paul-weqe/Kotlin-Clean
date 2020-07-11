package clean.school.entity

data class StudentClassroom (
    var id: Int = 0,
    var student: Student = Student(),
    var classroom: Classroom = Classroom(),
    var is_default: Boolean = false
)