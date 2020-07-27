package clean.school.entity

data class Student(
    override var isStudent: Boolean = true,
    override var entityName: String = "Student"
): BaseUser()