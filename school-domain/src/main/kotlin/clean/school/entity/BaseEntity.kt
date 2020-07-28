package clean.school.entity

abstract class BaseEntity {
    open var id: Int = 0
    open var entityName: String = ""
    open var isDefault: Boolean = true
}
