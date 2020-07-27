package clean.school.entity

abstract class BaseEntity {
    open var id: Int = 0
    open var entityName: String = "Student"
    open var isDefault: Boolean = true
}
