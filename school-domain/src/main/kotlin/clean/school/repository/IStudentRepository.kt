package clean.school.repository

import clean.school.entity.Student

interface IStudentRepository {
    fun findById(id: Int): Student
    fun findByEmail(email: String): Student
    fun findByEmailAndPassword(email: String, password: String): Student
    fun findAllByFirstName(firstName: String): MutableList<Student>
    fun findAllByLastName(lastName: String): MutableList<Student>
    fun findAllByFirstNameAndLastName(firstName: String, lastName: String): MutableList<Student>

    fun save(student: Student): Student
    fun update(student: Student): Boolean
    fun delete(id: Int): Boolean
}
