package clean.school.entity

abstract class AbstractUser(
    open var id: Int = 0,
    open var first_name: String = "",
    open var last_name: String = "",
    open var email: String = "",
    open var password: String = "",
    open var is_locked: Boolean = false,
    open var is_student: Boolean = false,
    open var is_teacher: Boolean = false
)