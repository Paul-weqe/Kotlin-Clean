package clean.school.entity

data class Teacher(
    override var isTeacher: Boolean = true,
    override var entityName: String = "Teacher"
): BaseUser()