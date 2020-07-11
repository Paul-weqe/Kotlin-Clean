package clean.school.entity

data class Course (
    var id: Int = 0,
    var teacher: Teacher = Teacher(),
    var name: String = "",
    var classroom: Classroom = Classroom(),
    var is_default: Boolean = false
)