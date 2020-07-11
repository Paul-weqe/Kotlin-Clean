package clean.school.entity

data class Teacher(
    // var id: Int = 0,
    var firstName: String = "",
    var lastName: String = "",
    var email: String = "",
    var password: String = "",
    var isLocked: Boolean = false,
    var isStudent: Boolean = false,
    var isTeacher: Boolean = true,
    var isDefault: Boolean = false
): BaseEntity()