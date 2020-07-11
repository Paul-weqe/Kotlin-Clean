package clean.school.entity

data class Student(
    var id: Int = 0,
    var firstName: String = "",
    var lastName: String = "",
    var email: String = "",
    var password: String = "",
    var isLocked: Boolean = false,
    var isStudent: Boolean = true,
    var isTeacher: Boolean = false,
    var isDefault: Boolean = false
)