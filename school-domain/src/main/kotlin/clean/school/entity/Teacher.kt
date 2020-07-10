package clean.school.entity

data class Teacher(
    override var is_teacher: Boolean = true,
    var teacherId: String = ""
): AbstractUser()