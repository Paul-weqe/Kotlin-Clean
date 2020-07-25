package clean.school.repository

import clean.school.entity.Teacher 

interface ITeacherRepository {
    fun findById(id: Int): Teacher
    fun findByEmail(email: String): Teacher
    fun findByEmailAndPassword(email: String, password: String): Teacher
    fun findAllByFirstName(firstName: String): MutableList<Teacher>
    fun findAllByLastName(lastName: String): MutableList<Teacher>
    fun findAllByFirstNameAndLastName(firstName: String, lastName: String): MutableList<Teacher>

    fun save(teacher: Teacher): Teacher
    fun update(teacher: Teacher): Boolean
    fun delete(id: Int): Boolean
}