package clean.school.entity

abstract class BaseUser: BaseEntity(){
    // open var id: Int = 0
    open var firstName: String = ""
    open var lastName: String = ""
    open var email: String = ""
    open var password: String = ""
    open var isLocked: Boolean = false
    open var isStudent: Boolean = false
    open var isTeacher: Boolean = false
    // open var isDefault: Boolean = true
}