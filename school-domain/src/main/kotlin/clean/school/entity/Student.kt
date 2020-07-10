package clean.school.entity

data class Student(
    override var is_student: Boolean = true,
    var studetId: String = ""
): AbstractUser()